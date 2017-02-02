
public class QuickSort {
	public static void main(String args[]){
		int nums[]= {5,2,4,1,0,3,-1};
		quickSort(nums);
		printNums(nums);
	}
	public static void quickSort(int nums[]){
		quickSortHelper(nums, 0, nums.length-1);
	}
	private static int partition(int nums[], int start, int end){
		int pivot=(start+end)/2;
		int leftCursor=start;
		int rightCursor=end;
		int value=nums[pivot];
		while(leftCursor<rightCursor){
			while(nums[leftCursor]<value)
				leftCursor++;
			while(nums[rightCursor]>value)
				rightCursor--;
			if (leftCursor>=rightCursor)
				break;
			else
				swap(nums, leftCursor, rightCursor);
		}
		return leftCursor;
	}
	private static void quickSortHelper(int nums[], int i, int j){
		if (i>=j)
			return;
		int partition = partition(nums, i, j);
		quickSortHelper(nums, i, partition-1);
		quickSortHelper(nums, partition+1, j);
	}
	private static void swap(int nums[], int i, int j){
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
	public static void printNums(int nums[]){
		if (nums!=null){
			System.out.print(nums[0]);
			for(int i=1;i<nums.length;i++){
				System.out.print(" "+nums[i]);
			}
			System.out.println();
		}		
	}
}
