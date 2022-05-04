package coding.dynamicProgramming;

import java.util.Arrays;

public class A05EqualSumPartitionProblem8 {
	
	public static void main(String[] args) {
		int arr[] = new int[] {1,5,11,5};
		int n = arr.length;
		int lsum = Arrays.stream(arr).sum();
		int rsum = 0;
//		approach 1
		System.out.println(knapSackRecursive(arr, n, rsum, lsum ));
		
//		approach2
//		s+s = 2s (even count)

		if(lsum%2 != 0 ) System.out.println(false);
		else {
			int sum = lsum/2;
			boolean t1[][] = new boolean[n+1][sum+1];
			for(int i=0; i<n+1; i++) {
				t1[i][0] = true;
			}
			System.out.println(A04SubsetSumProblem7.knapSackDP(arr, sum, n, t1));
		}		
	}


	private static boolean knapSackRecursive(int[] arr, int n, int rsum, int lsum) {
		if(n == 0) return rsum==lsum;
		return knapSackRecursive(arr, n-1, rsum+arr[n-1], lsum-arr[n-1]) || knapSackRecursive(arr, n-1, rsum, lsum);
	}

}
