import java.util.AbstractMap;
import java.util.Map.Entry;
import java.util.Stack;

public class LargestLake {
	public static void main(String args[]){
		int[] walls={4,6,4,3,8,4,2,1,7};
		int[] distances={3,5,2,1,3,3,4,2};
		System.out.println(largestLake(walls, distances));
	}
	public static int largestLake(int[] walls, int[] distances){
		int maxArea=0;
		int start = 0;
		int end = 0;
		Stack<Entry<Integer, Integer>> wallStack = new Stack<Entry<Integer, Integer>>();
		for(int i=0;i<walls.length;i++){
			int currentWall=walls[i];
			while(wallStack.size()>0){
				Entry<Integer, Integer> stackEntry = wallStack.peek();
				if (stackEntry.getValue()>currentWall){
					int potentialArea=calculateArea(stackEntry.getKey(), i,walls, distances);
					if (potentialArea>maxArea){
						start=stackEntry.getKey();
						end=i;
						maxArea=potentialArea;
					}
					break;
				}
				else{
					Entry<Integer, Integer> lastEntry=wallStack.pop();
					int potentialArea=calculateArea(lastEntry.getKey(), i, walls,distances);
					if (potentialArea>maxArea){
						start=lastEntry.getKey();
						end=i;
						maxArea=potentialArea;
					}
				}	
			}
			Entry<Integer, Integer> wallEntry = new AbstractMap.SimpleEntry<Integer, Integer>(i, currentWall);
			wallStack.push(wallEntry);	
			
		}
		System.out.println("start of lake:" + start);
		System.out.println("end of lake:" + end);
		return maxArea;
		
	}
	public static int calculateArea(int start, int end, int[] walls, int[] distances){
		int height=Math.min(walls[start], walls[end]);
		int width=0;
		for(int i=start;i<end;i++){
			width+=distances[i];
		}
		int wallCount=0;
		int wallArea = 0;
		for(int i=start+1;i<end;i++){
			wallCount++;
			wallArea+=walls[i];
		}
		return ((width+wallCount)*height)-wallArea;
	}
	public static int isValidLake(int start, int end, int[] walls){
		int height=Math.min(walls[start], walls[end]);
		for(int i=start+1;i<end;i++){
			if (walls[i]>height)
				return i;
		}
		return -1;
	}
}
