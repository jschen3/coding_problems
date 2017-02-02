import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnorderedAnagrams {
	public static void main(String args[]){
		System.out.println(unorderedAnagrams("aabb"));
	}
	public static int unorderedAnagrams(String s){
		Map<Integer, ArrayList<String>> lengthToStringMap= new HashMap<Integer, ArrayList<String>>();
		for(int i=0;i<s.length();i++){
			for(int j=i+1;j<s.length()+1;j++){
				String subString = s.substring(i, j);
				if (lengthToStringMap.containsKey(subString.length())){
					ArrayList<String> lengthArray = lengthToStringMap.remove(subString.length());
					lengthArray.add(subString);
					lengthToStringMap.put(subString.length(), lengthArray);
				}
				else{
					ArrayList<String> lengthArray = new ArrayList<String>();
					lengthArray.add(subString);
					lengthToStringMap.put(subString.length(), lengthArray);
				}
			}
		}
		int anagramCount=0;
		for (int i =1;i<s.length();i++){
			ArrayList<String> subStrings = lengthToStringMap.get(i);
			for(int j=0;j<subStrings.size();j++){
				for(int k=j+1;k<subStrings.size();k++){
					if (checkAnagram(subStrings.get(j), subStrings.get(k)))
						anagramCount++;
				}
			}
		}
		return anagramCount;
	}
	public static boolean checkAnagram(String a, String b){
		int[] charsA = new int[26];
		int[] charsB = new int[26];
		for(int i=0;i<a.length();i++){
			int index=(int)(a.charAt(i)) - (int)'a';
			charsA[index]++;
		}
		for(int i=0;i<b.length();i++){
			int index=(int)(b.charAt(i)) - (int)'a';
			charsB[index]++;
		}
		for(int i=0;i<charsA.length;i++){
			if (charsA[i]==charsB[i])
				continue;
			else
				return false;
		}
		return true;
	}
}
