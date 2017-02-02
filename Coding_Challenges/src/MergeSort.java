
public class MergeSort {
	public static void main(String args[]){
		int[] list1={1,7,11};
		int[] list2={2,4,6};
		int[] list3={2,1,7,11,4,6};
		int[] sortedList=mergeSort(list3);
		printNums(sortedList);
	}
	public static int[] mergeSort(int[] list){
		return mergeSortHelper(list);
	}
	public static int[] mergeSortHelper(int[] list){
		if (list.length<=1)
			return list;
		else{
			int midPoint = list.length/2;
			int[] half1 = new int[midPoint];
			int[] half2 = new int[list.length-midPoint];
			System.arraycopy(list, 0, half1, 0, half1.length);
			System.arraycopy(list,midPoint, half2, 0, half2.length);
			mergeSortHelper(half1);
			mergeSortHelper(half2);
			merge(half1,half2,list);
			return list;
		}
		
	}
	public static void merge(int[] list1, int[] list2, int[] mergedList){
		int list1Index=0;
		int list2Index=0;
		int mergedIndex=0;
		while(list1Index<list1.length && list2Index<list2.length){
			while((list1Index<list1.length) && (list1[list1Index]<list2[list2Index])){
				mergedList[mergedIndex]=list1[list1Index];
				mergedIndex++;
				list1Index++;
			}
			mergedList[mergedIndex]=list2[list2Index];
			mergedIndex++;
			list2Index++;
		}
		if (list1Index<list1.length){
			while(list1Index<list1.length){
				mergedList[mergedIndex]=list1[list1Index];
				mergedIndex++;
				list1Index++;
			}
		}
		else{
			while(list2Index<list2.length){
				mergedList[mergedIndex]=list2[list2Index];
				mergedIndex++;
				list2Index++;
			}
		}
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
