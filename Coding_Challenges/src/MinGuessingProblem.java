
public class MinGuessingProblem {
	public static void main(String args[]){
		
	}
	public static int minGuessingProblem(int n){
		 int[][] dp = new int[n+1][n+1];
		    for(int len=1;len<n;len++){
		        for(int i=1;i+len<=n;i++){
		            int j=i+len;
		            int min = Integer.MAX_VALUE;
		            for(int k=i;k<j;k++){
		              int tmp = k+Math.max(dp[i][k-1],dp[k+1][j]);
		              min = Math.min(min,tmp);
		            }
		            dp[i][j] = min;
		        }
		    }
		    return dp[1][n];
	}
}	
