
public class PalindromeChange {
	public static void main(String args[]){
		System.out.println(largestNumberPalindromeChange(2357,3));
	}
	public static int largestNumberPalindromeChange(int number, int changes){
		int nonPalindromeNumbers=0;
		String numberString = number+"";
		int[] palindromeNumber = new int[numberString.length()];
		for(int i=0;i<Math.ceil((double)numberString.length()/(double)2);i++){
			int start = Integer.parseInt(numberString.charAt(i)+"");
			int end = Integer.parseInt(numberString.charAt(numberString.length()-1-i)+"");
			if (start!=end){
				nonPalindromeNumbers++;
				if (start<end){
					palindromeNumber[i]=end;
					palindromeNumber[numberString.length()-1-i]=end;
				}
				else{
					palindromeNumber[i]=start;
					palindromeNumber[numberString.length()-1-i]=start;
				}
					
			}
		}
		if (changes<nonPalindromeNumbers)
			return -1;
		int palindromeMax = convertIntArray(palindromeNumber);
		return palindromeMax;
			
		
	}
	private static int convertIntArray(int[] palindromeNumber) {
		int number=0;
		int powerOf10=1;
		for(int i=palindromeNumber.length-1;i>-1;i--){
			number+=palindromeNumber[i]*powerOf10;
			powerOf10*=10;
		}
		return number;
	}
	
	
}
