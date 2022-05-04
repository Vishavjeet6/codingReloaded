package coding.dynamicProgramming;

import java.util.Arrays;

public class A07MinimumSubsetSumDifference10 {
	
	public static void main(String[] args) {
		int arr[] = new int[] {1,6,11,5};
		int n = arr.length;
		
//		abs(s1-s2)=> minimize
		int sum = Arrays.stream(arr).sum();
		int start = 0;
		int end = (sum)/2;
		boolean[][] t = new boolean[n+1][end+1];
		for(int i=0; i<n+1; i++) {
			t[i][0] = true;
		}
		System.out.println(knapSack(arr, n, end, t, sum));
		
		
		
	}

	private static int knapSack(int[] arr, int n, int sum, boolean[][] t, int totalSum) {
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<sum+1; j++) {
				if(arr[i-1] <= j) {
					t[i][j] = t[i-1][j] || t[i-1][j-arr[i-1]];
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		for(int j=sum; j>=0; j--) {
			if(t[n][j]) return Math.abs(totalSum-j-j);
		}
		return -1;
	}

}