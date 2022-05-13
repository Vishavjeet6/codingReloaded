package coding.dynamicProgramming;

import java.util.Arrays;

public class A29MatrixchainmultiplicationMemoization35 {
	
	static int t[][] = new int[1001][1001];
	
	public static void main(String[] args) {
		int arr[] = new int[] {40,20,30,10,30};
		int n = arr.length;
		for(int w[] : t) {
			Arrays.fill(w, -1);
		}
		System.out.println(mcm(arr, 1, n-1));
	}

	public static int mcm(int[] arr, int i, int j) {
		if(i>=j) return 0;
		if(t[i][j] != -1) return t[i][j];
		int ans = Integer.MAX_VALUE;
		for(int k=i; k<=j-1; k++) {
			int tempAns = arr[i-1]*arr[k]*arr[j] + mcm(arr, i, k) + mcm(arr, k+1, j);
			ans = Math.min(ans, tempAns);
		}

		
		return t[i][j] = ans;
	}
}
