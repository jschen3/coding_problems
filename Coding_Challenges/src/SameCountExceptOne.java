import java.util.Scanner;

public class SameCountExceptOne {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        if (validString(s))
        	System.out.println("YES");
        else
        	System.out.println("NO");
    }
    public static boolean validString(String s){
        int[] chars = new int[26];
        for(int i=0;i<s.length();i++){
            int index=(int)s.charAt(i)-((int)'a');
            chars[index]++;
        }
        int num1=0;
        int countOfNum1=0;
        int countOfNum2=0;
        int num2=0;
        for(int i=0;i<chars.length;i++){
        	if (chars[i]>0){
        		if (num1==0){
        			num1=chars[i];
        			countOfNum1=1;
        		}
        		if (chars[i]!=num1 && num2==0){
    				num2=chars[i];
    				countOfNum2=1;
    			}
        		else{
        			if (chars[i]==num1)
        				countOfNum1++;
        			else if (chars[i]==num2)
        				countOfNum2++;
        			else
        				return false;
        			if (countOfNum1>1 && countOfNum2>1)
        				return false;
        			if (countOfNum1>0 && countOfNum2>0){
	        			if (countOfNum1-countOfNum2>1 || countOfNum1-countOfNum2<-1)
	        				return false;
        			}
        			
        		}
        	}
        }
        return true;
        
    }
}
