
public class MinimumCoinsDp {
	public static void main (String args[]){
		int coins[] = {1,3,5};
		int sum=11;
		System.out.println(minimumCoinsDp(coins, sum));
	}
	public static int minimumCoinsDp(int[] coins, int sum){
		int[] minCoins = new int[sum+1];
		for (int i=0;i<sum+1;i++){ //initialize all values as the max integer
			minCoins[i]=Integer.MAX_VALUE;
		}
		minCoins[0]=0;
		for (int i=1;i<sum+1;i++){
			int j=0;
			while(j<coins.length && coins[j]<=i){
				int currentMin=minCoins[i];
				int sumMinusCoin=i-coins[j];
				if (sumMinusCoin<0)
					currentMin=Integer.MAX_VALUE;
				else{
					if (minCoins[i-coins[j]]==Integer.MAX_VALUE)
						return -1;
					else
						currentMin=1+minCoins[i-coins[j]];
				}
					
				if (currentMin<minCoins[i])
					minCoins[i]=currentMin;
				j++;
			}
		}
		if (minCoins[sum]==Integer.MAX_VALUE)
			return -1;
		else{
			return minCoins[sum];
		}
	}
}
