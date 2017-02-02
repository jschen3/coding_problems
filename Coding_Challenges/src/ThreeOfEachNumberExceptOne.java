import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ThreeOfEachNumberExceptOne {
	public static void main(String args[]){
		int[] nums = {1,2,3,1,1,2,2};
		System.out.println(findNotThree(nums));
	}
	public static int findNotThree(int nums[]){
		Set<Integer> singleNums = new HashSet<Integer>();
		Set<Integer> doubleNums = new HashSet<Integer>();
		for (int i=0;i<nums.length;i++){
			if (singleNums.contains(nums[i])){
				singleNums.remove(nums[i]);
				doubleNums.add(nums[i]);
			}
			else if (doubleNums.contains(nums[i])){
				doubleNums.remove(nums[i]);
			}
			else{
				singleNums.add(nums[i]);
			}
		}
		if (singleNums.size()>0){
			return singleNums.iterator().next();
		}
		else if (doubleNums.size()>0){
			return doubleNums.iterator().next();
		}
		return -1;
	}
}
