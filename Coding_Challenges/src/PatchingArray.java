
public class PatchingArray {
	public static void main(String args[]){
		int[] nums ={1,3}; 
		System.out.println(patchingArray(nums,6));
	}
	public static int patchingArray(int nums[], int goal){
		boolean[] solutionFound = new boolean[goal+1]; 
		solutionFound[0]=true;
		for(int i=0;i<nums.length;i++){
			solutionFound[nums[i]]=true;
		}
		int patches=0;
		while(checkSolved(solutionFound)!=-1){
			int solutionFoundUntil=checkSolved(solutionFound);
			for(int i=0;i<solutionFoundUntil;i++){
				int sum=0;
				for(int j=i;j<solutionFoundUntil;j++){
					sum+=j;
				}
				if (sum<solutionFound.length)
					solutionFound[sum]=true;
			}
			solutionFound[solutionFoundUntil]=true;
			patches++;
			
		}
		return patches;
	}
	public static int checkSolved(boolean[] solutionFound){
		for(int i=0;i<solutionFound.length;i++){
			if (solutionFound[i]==false)
				return i;
		}
		return -1;
	}
}
