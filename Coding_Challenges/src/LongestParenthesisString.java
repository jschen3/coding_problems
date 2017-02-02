import java.util.AbstractMap;
import java.util.Map.Entry;
import java.util.Stack;

public class LongestParenthesisString {

	public static void main(String[] args) {
		String testString1="(()))(((()())";
		String testString2="))()()((";
		String testString3="(()()(()";
		String testString4=")()(()";
		System.out.println(longestParenthesisString(testString1));
		System.out.println(longestParenthesisString(testString2));
		System.out.println(longestParenthesisString(testString3));
		System.out.println(longestParenthesisString(testString4));
	}
	public static int longestParenthesisString(String string){
		if (!isValidString(string))
			return -1;
		else{
			int maxLength=0;
			int lastClosedSegment=0;
			int currentLength=0;
			Stack<Entry<Integer, Character>> parenthesisStack = new Stack<Entry<Integer,Character>>();
			for(int i=0;i<string.length();i++){
				char c = string.charAt(i);
				if (c=='('){
					Entry<Integer, Character> e = new AbstractMap.SimpleEntry<Integer, Character>(i, c);
					parenthesisStack.push(e);
				}
				else{
					if (parenthesisStack.isEmpty()){
						currentLength=0;
					}
					else{
						Entry<Integer, Character> e=parenthesisStack.pop();
						int segmentLength=(i-e.getKey())+1;
						if ((e.getKey()-lastClosedSegment)==1){
							segmentLength+=currentLength;
						}
						if (segmentLength>maxLength){
							maxLength=segmentLength;
						}
						currentLength=segmentLength;
						lastClosedSegment=i;	
					}
					
				}
			}
			return maxLength;
		}
	}
	public static boolean isValidString(String string){
		for(int i=0;i<string.length();i++){
			char c =string.charAt(i);
			if ((c=='(') || (c==')')){
				continue;
			}
			else
				return false;
		}
		return true;
	}

}
