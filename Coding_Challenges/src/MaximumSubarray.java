
public class MaximumSubarray {
	public static void main(String args[]){
		int nums[] = {3,-1,5,2,-6,4,2,-1,3};
		System.out.println(maximumSubArray(nums));
	}
	public static int maximumSubArray(int nums[]){
		int maxHere = nums[0];
		int maxSum=nums[0];
		for (int i=1;i<nums.length;i++){
			if (nums[i]>(maxHere +nums[i])){
				maxHere=nums[i];
			}
			else{
				maxHere=maxHere+nums[i];
			}
			if  (maxSum<maxHere){
				maxSum=maxHere;
			}
		}
		return maxSum;
	}
}
