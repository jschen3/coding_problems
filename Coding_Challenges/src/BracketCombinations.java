import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BracketCombinations {
	public static void main(String args[]){
		List<String> bracketCombinations = bracketCombinations(3);
		System.out.println(bracketCombinations);
		System.out.println(bracketCombinations.size());
	}
	public static List<String> bracketCombinations(int n){
		Map<Integer, ArrayList<String>> bracketCombinationsForN = new HashMap<Integer, ArrayList<String>>();
		ArrayList<String> bracketCombinationsFor0 = new ArrayList<String>();
		bracketCombinationsFor0.add("");
		bracketCombinationsForN.put(0, bracketCombinationsFor0);
		for(int i=1;i<n+1;i++){
			Set<String> combinationsForNext = new HashSet<String>();
			for(int j=i-1;j>0;j--){
				ArrayList<String> combinationsForJ = bracketCombinationsForN.get(j);
				for(String jCombination:combinationsForJ){
					ArrayList<String>combinationsForIminusJ = bracketCombinationsForN.get(i-j);
					for(String iMinusJCombination:combinationsForIminusJ){
						String combination = jCombination+iMinusJCombination;
						combinationsForNext.add(combination);
					}
				}
			}
			combinationsForNext.addAll(wrappingCombinations(bracketCombinationsForN.get(i-1)));
			bracketCombinationsForN.put(i,setToList(combinationsForNext));
		}
		return bracketCombinationsForN.get(n);
	}
	public static List<String> wrappingCombinations(List<String> previous){
		List<String> wrappingCombinations = new ArrayList<String>();
		for(String previousCombination:previous){
			String s = "("+previousCombination+")";
			wrappingCombinations.add(s);
		}
		return wrappingCombinations;
	}
	public static ArrayList<String> setToList(Set<String> set){
		ArrayList<String> list = new ArrayList<String>();
		for(String s:set){
			list.add(s);
		}
		return list;
	}
	
}
