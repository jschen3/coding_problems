package problem22;

import java.util.ArrayList;

public class Problem22 {
	public static void main(String args[]){
		int prices[] = {2,1,0,2,4,5,3,1,4};
		maxProfit(prices);
	}
	public static int maxProfit(int [] prices){
		ArrayList<Integer> trends=trends(prices);
		ArrayList<Integer> mins = mins(trends);
		ArrayList<Integer> maxs = maxs(trends);
		int profit=0;
		for (int start:mins){
			int current = prices[start];
			while(trends.get(start)!=-1){
				profit+=prices[start]-current;
				current=prices[start];
				start++;
			}
		}
		return profit;
	}
	public static ArrayList<Integer> trends(int[] prices){
		int current = prices[0];
		ArrayList<Integer> trends = new ArrayList<Integer>();
		for(int i=0;i<prices.length;i++){
			if (prices[i]>current){
				trends.add(1);
			}
			else{
				trends.add(-1);
			}
			current=prices[i];
		}
		return trends;
	}
	
	public static int firstDown(int start, ArrayList<Integer> trends){
		for (int i=start;i<trends.size();i++){
			if (trends.get(i)==-1)
				return i;
		}
		return start;	
	}
	public static ArrayList<Integer> mins(ArrayList<Integer> trends){
		ArrayList<Integer> mins = new ArrayList<Integer>();
		int start=0;
		while(start<trends.size()){
			start=firstDown(start, trends);
			int min=findMin(start,trends);
			mins.add(min-1);
			start=min+1;
		}
		return mins;
	}
	public static int findMin(int start, ArrayList<Integer> trends){
		for(int i=start;i<trends.size();i++){
			if(trends.get(i)!=-1)
				return i;
		}
		return trends.size()-1;
	}
	public static ArrayList<Integer> maxs(ArrayList<Integer> trends){
		ArrayList<Integer> maxs = new ArrayList<Integer>();
		int start=0;
		while(start<trends.size()){
			start=firstUp(start, trends);
			int max=findMax(start,trends);
			maxs.add(max-1);
			start=max+1;
		}
		return maxs;
	}
	public static int findMax(int start, ArrayList<Integer> trends){
		for(int i=start;i<trends.size();i++){
			if(trends.get(i)!=1)
				return i;
		}
		return trends.size()-1;
	}
	public static int firstUp(int start, ArrayList<Integer> trends){
		for (int i=start;i<trends.size();i++){
			if (trends.get(i)==1)
				return i;
		}
		return start;	
	}
}
