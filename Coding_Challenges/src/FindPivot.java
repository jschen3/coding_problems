
public class FindPivot {
	public static void main(String args[]){
		int[] nums = {4,5,6,7,0,1,2,3};
		System.out.println(findPivot(nums, 0, nums.length));
	}
	public static int findPivot(int nums[], int start, int end){
		if (end<start)
			return -1;
		if (start==end)
			return start;
		else{
			int half = (start+end)/2;
			int startValue = nums[start];
			int halfValue = nums[half];
			if (half<end && nums[half] >nums[half+1])
				return half+1;
			if (half>start && nums[half]<nums[half-1])
				return half;
			if (startValue>halfValue)
				return findPivot(nums, start, half-1);
			else
				return findPivot(nums, half+1,end);
		}
		
	}
	
}
