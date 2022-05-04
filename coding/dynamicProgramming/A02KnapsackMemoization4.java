package coding.dynamicProgramming;

import java.util.Arrays;

public class A02KnapsackMemoization4 {
//	n+1 size
	static int[][] t = new int[101][101];
	
	public static void main(String[] args) {
		int[] wt = new int [] {1,3,4,5};
		int[] val = new int[] {1,4,5,7};
		int w = 7;
		for(int[] arr1 : t) 
			  Arrays.fill(arr1, -1);
		System.out.println(knapSack(wt, val, w, wt.length));
	}
	
	public static int knapSack(int[] wt, int[] val, int w, int n) {
		if(n == 0 || w==0) return 0;
		if(t[n][w] != -1) return t[n][w];
		if(wt[n-1] <= w) {
			return t[n][w]=Math.max(val[n-1] + knapSack(wt, val, w-wt[n-1], n-1), knapSack(wt, val, w, n-1));
		}else {
			return t[n][w]=knapSack(wt, val, w, n-1);	
		}
	}

}
