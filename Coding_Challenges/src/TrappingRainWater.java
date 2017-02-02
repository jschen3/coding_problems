import java.util.Stack;

public class TrappingRainWater {
	public static void main(String args[]){
		int[] heights= {4,2,0,3,2,5};
		System.out.println(findRainWater(heights));
	}
	public static int findRainWater(int[] heights){
		int currentWater=0;
		Stack<Integer> walls = new Stack<Integer>();
		Stack<Integer> waterAmount = new Stack<Integer>();
		for(int i=0;i<heights.length;i++){
			int current=heights[i];
			while(walls.size()>1){
				int stackHeight = heights[walls.peek()];
				if (stackHeight>=current){
					break;
				}
				else{
					walls.pop();
					waterAmount.pop();
					
				}
			}
			if (!waterAmount.isEmpty())
				currentWater = waterAmount.peek();
			if (!walls.isEmpty()){
				int newWaterAmount=calculateWater(heights, walls.peek(), i);
				currentWater = currentWater+newWaterAmount;
			}
			waterAmount.push(currentWater);
			walls.push(i);
		}
		return waterAmount.peek();
		
	}
	private static int calculateWater(int[] heights, int start, int end) {
		int width=end-start-1;
		int height=Math.min(heights[start], heights[end]);
		int total=width*height;
		for(int i=start+1;i<end;i++){
			total-=heights[i];
		}
		if (total<0)
			return 0;
		return total;
	}
}
