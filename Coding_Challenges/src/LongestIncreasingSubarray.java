import java.util.ArrayList;
import java.util.Collection;
import java.util.Stack;

public class LongestIncreasingSubarray {
	public static void main(String args[]){
		int[] nums1 = {3,4,5};
		int[] nums2={3,2,6};
		int[] nums3={2,2,1};
		int[][]board = {nums1,nums2,nums3};
		System.out.println(longestIncreasingPathInMatrix(board));
	}
	public static int longestIncreasingSubArray(int[] nums){
		int curLength=0;
		int currentValue=nums[0];
		int maxLength=0;
		for(int i=0;i<nums.length;i++){
			if (nums[i]>=currentValue)
				curLength++;
			else{
				curLength=1;
			}
			currentValue=nums[i];
			if (curLength>maxLength){
				maxLength=curLength;
			}
		}
		return maxLength;
	}
	public static int longestIncreasingPathInMatrix(int [][]matrix){
		if (matrix==null || matrix.length<1 || matrix[0].length<1){
			return 0;
		}
		int maxLength=0;
		int width=matrix.length;
		int height = matrix[0].length;
		int[][] lengthDP = new int[width][height];
		for(int i=0;i<width;i++){
			for(int j=0;j<matrix[i].length;j++){
				int dfsResult = dfs(matrix, Integer.MIN_VALUE,i,j,lengthDP);
				if (dfsResult>maxLength)
					maxLength=dfsResult;
			}
		}
		System.out.println(printPossibleBoard(matrix));
		System.out.println(printPossibleBoard(lengthDP));
		return maxLength;
	}
	private static int dfs(int[][] matrix,int currentValue, int x, int y, int[][] lengthDP) {
		if (x<0 || x>=matrix.length || y<0 || y>=matrix[x].length){
			return 0;
		}
		if (matrix[x][y]<=currentValue)
			return 0;
		if (lengthDP[x][y]!=0)
			return lengthDP[x][y];
		
		currentValue = matrix[x][y];
		int left = dfs(matrix, currentValue, x - 1, y, lengthDP) + 1;
		int right = dfs(matrix, currentValue, x + 1, y, lengthDP) + 1;
		int down = dfs(matrix, currentValue, x, y - 1,  lengthDP) + 1;
		int up = dfs(matrix, currentValue, x, y + 1,  lengthDP) + 1;
		int max = Math.max(left, Math.max(right, Math.max(up, down)));
		lengthDP[x][y]=max;
		return max;
	}
	public static String printPossibleBoard(int[][] board){
		StringBuilder s = new StringBuilder();
		for(int i=0;i<board.length;i++){
			String line = "";
			for(int j=0;j<board[i].length;j++){
				if (j==board[i].length-1){
						line+=" "+board[i][j]+" ";
				}
				else{
					line+=" "+board[i][j]+" ,";
				}
			}
			line+="\n";
			s.append(line);
		}
		return s.toString();
	}
}
