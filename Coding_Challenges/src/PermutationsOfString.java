import java.util.ArrayList;
import java.util.List;

public class PermutationsOfString {
	public static void main(String args[]){
		List<String> permutations = permutationsOfString("band");
		System.out.println(permutations);
		System.out.println(permutations.size());
	}
	public static List<String> permutationsOfString(String s){
		List<String> permutations = new ArrayList<String>();
		permutationsOfString(s,"",permutations);
		return permutations;
	}
	public static void permutationsOfString(String initial, String permutation, List<String> listOfPermutations){
		if (listOfPermutations==null)
			listOfPermutations=new ArrayList<String>();
		for(int i=0;i<initial.length();i++){
			String before=initial.substring(0,i);
			String after=initial.substring(i+1,initial.length());
			char charAtI=initial.charAt(i);
			permutationsOfString(before+after,permutation+charAtI, listOfPermutations);
		}
		if (initial.length()==0){
			listOfPermutations.add(permutation);
		}
	}
}
