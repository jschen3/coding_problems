
public class BreakIntoLargestProduct {
	public static void main(String args[]){
		System.out.println("largestProduct:" + largestProduct(8));
	}
	public static int largestProduct(int s){
		int[] largestProducts = new int[s+1];
		largestProducts[0]=1;
		largestProducts[1]=1;
		for(int i=2;i<s+1;i++){
			for(int j=1;j<i;j++){
				int possProduct=Math.max(i, Math.max(j, largestProducts[j])*Math.max(i-j, largestProducts[i-j]));
				if (possProduct>largestProducts[i])
					largestProducts[i]=possProduct;
			}
		}
		return largestProducts[s];
	}
}
