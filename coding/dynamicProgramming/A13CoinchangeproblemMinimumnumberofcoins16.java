package coding.dynamicProgramming;

import java.util.Arrays;

public class A13CoinchangeproblemMinimumnumberofcoins16 {
	
	public static void main(String[] args) {
		
//		minimize total number of coin used
		int coin [] = new int[] {9,6,5,1};
		int sum = 11;
		
		knapSack(coin, sum);
	}

	private static void knapSack(int[] coin, int sum) {
		// TODO Auto-generated method stub
		int n = coin.length;
		
		int t [][] = new int[n+1][sum+1];
		
		
		for(int i=0; i<sum+1; i++) {
			t[0][i] = Integer.MAX_VALUE-1;
		}
		
		for(int i=1; i<sum+1; i++) {
			if(i%coin[0] == 0) {
				t[1][i] = i/coin[0];
			}else {
				t[1][i]=Integer.MAX_VALUE-1;
			}
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<sum+1; j++) {
				if(coin[i-1] <= j) {
					t[i][j] = Math.min(t[i-1][j], 1+t[i][j-coin[i-1]]);
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		System.out.println(t[n][sum]);
		for(int [] x : t) {
			System.out.println(Arrays.toString(x));
		}
	}
}
