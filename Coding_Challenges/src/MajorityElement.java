package problem14;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MajorityElement {
	public static void main(String args[]){
		int[] a={ 2, 2, 3, 5, 2, 2, 6};
		int [] b= {3, 3, 4, 2, 4, 4, 2, 4, 4};
		System.out.println(majorityElementHashMap(a));
		System.out.println(majorityElementMooresVoting(a));
		System.out.println(majorityElementHashMap(b));
		System.out.println(majorityElementMooresVoting(b));
	}
	public static int majorityElementHashMap(int nums[]){
		Map<Integer, Integer> numToCountMap = new HashMap<Integer,Integer>();
		for (int i=0;i<nums.length;i++){
			if (numToCountMap.containsKey(nums[i])){
				numToCountMap.put(nums[i], numToCountMap.get(nums[i])+1);
			}
			else{
				numToCountMap.put(nums[i], 1);
			}
		}
		int max=0;
		int num = 0;
		for(Entry<Integer, Integer> entry:numToCountMap.entrySet()){
			if (entry.getValue() > max){
				max=entry.getValue();
				num=entry.getKey();
			}
		}
		return num;
	}
	public static int majorityElementMooresVoting(int nums[]){
		int num=nums[0];
		int count=1;
		for(int i=1;i<nums.length;i++){
			if (num==nums[i])
				count++;
			else
				count--;
			if (count==0){
				num=nums[i];
				count=1;
			}
		}
		return num;
	}
}
