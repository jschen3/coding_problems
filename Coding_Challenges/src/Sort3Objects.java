import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort3Objects {
	public static void main(String args[]){
		int nums[]={2,1,0,0,1,2,0,1,2,2};
		printNums(nums);
		sort3Objects(nums);
		printNums(nums);
	}
	public static int[] sort3Objects(int nums[]){
		int start=0;
		int end=nums.length-1;
	    for (int i=0;i<=end;i++){
				while(nums[i]==2 && i<end){
					int temp=nums[end];
					nums[end]=nums[i];
					nums[i]=temp;
					end--;
				}
				while(nums[i]==0 && i>start){
					int temp=nums[start];
					nums[start]=nums[i];
					nums[i]=temp;
					start++;
				}
			}
	    return nums;
	}
	public static void printNums(int nums[]){
		if (nums!=null){
			System.out.print(nums[0]);
			for(int i=1;i<nums.length;i++){
				System.out.print(", "+nums[i]);
			}
			System.out.println();
		}		
	}
}
