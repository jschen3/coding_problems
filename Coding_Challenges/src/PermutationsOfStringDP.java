import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationsOfStringDP {
	public static void main(String args[]){
		System.out.println(permutationsOfStringDP("abc"));
	}
	
	public static List<String> permutationsOfStringDP(String a){
		Map<String, ArrayList<String>> permutations = new HashMap<String, ArrayList<String>>();
		ArrayList<String> permSingleChar = new ArrayList<String>();
		permSingleChar.add(a.charAt(0)+"");
		permutations.put(a.charAt(0)+"", permSingleChar);
		
		for(int i=1;i<a.length();i++){
			ArrayList<String> permutationsOfIMinus1 = permutations.get(a.substring(0, i));
			ArrayList<String> newPermutations = new ArrayList<String>();
			for(String perm:permutationsOfIMinus1){
				for(int position=0;position<perm.length()+1;position++){
					String start=perm.substring(0, position);
					String end=perm.substring(position);
					newPermutations.add(start+a.charAt(i)+end);
				}
			}
			permutations.put(a.substring(0,i+1), newPermutations);
		}
		return permutations.get(a);
	}
}
