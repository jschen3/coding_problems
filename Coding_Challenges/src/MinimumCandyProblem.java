
public class MinimumCandyProblem {
	public static void main(String args[]){
		int[] ratings = {2,1,0};
		System.out.println(minimumCandyProblem(ratings));
	}
	public static int minimumCandyProblem(int [] ratings){
		int current;
		int next;
		int[] candy = new int[ratings.length];
		int i=1;
		candy[0]=1;
		int candyAmount=1;
		while(i<ratings.length){
			if (ratings[i]>ratings[i-1])
				candy[i]=candyAmount+1;
			else{
				candy[i]=1;
				current=i;
				while(current>0 && ratings[current-1]>ratings[current]){
					if (candy[current-1]<candy[current]){
						candy[current-1]++;
					}
					current--;
				}
			}
			i++;
		}
		int totalCandy =0;
		for(int j=0;j<candy.length;j++){
			totalCandy+=candy[j];
		}
		return totalCandy;
	}
}
