import java.util.ArrayList;
import java.util.List;

public class CombinationsOfString {
	public static void main(String args[]){
		System.out.println(combinationsOfString("abc"));
		System.out.println(combinationsOfStringLengthK("abcde",3));
	}
	public static List<String> combinationsOfString(String a){
		List<String> combinations = new ArrayList<String>();
		String b="";
		combinationsOfString("abcd",b, combinations);
		return combinations;
	}
	public static void combinationsOfString(String a, String b, List<String> combinations){
		combinations.add(b);
		for (int i = 0; i < a.length(); i++)
            combinationsOfString(a.substring(i + 1), b + a.charAt(i), combinations);
	}
	public static List<String> combinationsOfStringLengthK(String a, int k){
		List<String> combinations = new ArrayList<String>();
		String prefix="";
		combinationsOfStringLengthK(a,k,prefix,combinations);
		return combinations;
	}
	public static void combinationsOfStringLengthK(String a, int k, String prefix, List<String> combinations){
		if (k==0){
			combinations.add(prefix);
			return;
		}
		for(int i=0;i<a.length();i++){
			combinationsOfStringLengthK(a.substring(i+1), k-1, prefix+ a.charAt(i), combinations );
		}
	}
}
