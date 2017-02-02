import java.util.ArrayList;
import java.util.List;

public class NQueens {
	public static class Coordinate{
		public int x;
		public int y;
		public Coordinate(int x, int y){
			this.x=x;
			this.y=y;
		}
		public String toString(){
			String s="( "+x+" , "+y+" )";
			return s;
		}
	}
	public static void main(String args[]){
		int[] row1={0,0,0,0};
		int[] row2={0,0,0,0};
		int[] row3={0,0,0,0};
		int[] row4={0,0,0,0};
		int[][]board = {row1,row2,row3,row4};
		markBoard(board,1,0);
		System.out.println(printPossibleBoard(board));
		List<Coordinate> cordinates = getAvailableCordinates(board, 1);
		System.out.println(cordinates);
	}
	public static List<int[][]> nQueens(int queens){
		return null;
		
		
	}
	public static String printBoard(int[][] board){
		StringBuilder s = new StringBuilder();
		for(int i=0;i<board.length;i++){
			String line = "";
			for(int j=0;j<board[i].length;j++){
				if (j==board[i].length-1){
					if (board[i][j]==0)
						line+="   ";
					else{
						line+=" Q ";
					}
				}
				else{
					if (board[i][j]==0)
						line+="   ,";
					else{
						line+=" Q ,";
					}
				}
			}
			line+="\n";
			s.append(line);
		}
		return s.toString();
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
	public static boolean markBoard(int[][] board, int y, int x){
		if (board[x][y]==1)
			return false;
		else{
			board[x][y]=1;
			for(int i=0;i<board[x].length;i++){
				board[x][i]=1;
			}
			for(int j=0;j<board.length;j++){
				board[j][y]=1;
			}
			markDiagonals(board,x,y);
			return true;
		}
	}
	private static void markDiagonals(int[][] board, int x, int y) {
		int tempX = x;
		int tempY= y;
		while(tempX >-1 && tempY>-1){
			board[tempX--][tempY--]=1;
		}
		tempX=x;
		tempY=y;
		while(tempX<board.length && tempY<board[tempX].length){
			board[tempX++][tempY++]=1;
		}
		tempX=x;
		tempY=y;
		while(tempX>-1 && tempY<board[tempX].length){
			board[tempX--][tempY++]=1;
		}
		tempX=x;
		tempY=y;
		while(tempY>-1 && tempX<board.length){
			board[tempX++][tempY--]=1;
		}
	}
	private static List<Coordinate> getAvailableCordinates(int[][]board, int y){
		List<Coordinate> possCordinates = new ArrayList<Coordinate>();
		for(int i=0;i<board[y].length;i++){
			if (board[y][i]==0){
				Coordinate n = new Coordinate(i,y);
				possCordinates.add(n);
			}
		}
		return possCordinates;
	}
}
