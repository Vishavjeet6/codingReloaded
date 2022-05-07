package coding.dynamicProgramming;

public class A12CoinchangeproblemMaximumnumberofways15 {
	
	public static void main(String[] args) {
//		infinite supply of these coins
		int coin [] = new int[] {1,2,3};
		int sum = 5;
		
		knapSack(coin, sum);
	}

	private static void knapSack(int[] coin, int sum) {
		int n = coin.length;
		
		int t [][] = new int[n+1][sum+1];
		
		for(int i=0; i<n+1; i++) {
			t[i][0] = 1;
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<sum+1; j++) {
				if(coin[i-1] <= j) {
					t[i][j] = t[i-1][j] + t[i][j-coin[i-1]];
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		System.out.println(t[n][sum]);
	}

}
