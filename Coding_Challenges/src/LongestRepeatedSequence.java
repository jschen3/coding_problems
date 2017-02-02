import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestRepeatedSequence {
	public static void main(String args[]){
		System.out.println(longestRepeatedSequence("abcab"));
	}
	public static String longestRepeatedSequence(String s){
		Map<Integer, List<String>> positionToStringMap = new HashMap<Integer, List<String>>();
		Set<String> stringSet = new HashSet<String>();
		String longestString="";
		int longestLength=0;
		for(int i=0;i<s.length();i++){
			List<String> previousPosition= positionToStringMap.get(i-1);
			List<String> currentPosition = new ArrayList<String>();
			if (previousPosition!=null){
				for(String a:previousPosition){
					String newString = a+s.charAt(i);
					currentPosition.add(newString);
					if (stringSet.contains(newString)){
						if (newString.length()>longestLength){
							longestString=newString;
							longestLength=newString.length();
						}
					}
					stringSet.add(newString);
				}
			}
			String newString=s.charAt(i)+"";
			currentPosition.add(newString);
			if (stringSet.contains(newString)){
				if (newString.length()>longestLength){
					longestString=newString;
					longestLength=newString.length();
				}
			}
			stringSet.add(newString);
			positionToStringMap.put(i, currentPosition);
		}
		return longestString;
	}
}
