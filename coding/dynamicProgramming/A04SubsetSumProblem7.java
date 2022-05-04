package coding.dynamicProgramming;

public class A04SubsetSumProblem7 {
	
	public static void main(String[] args) {
		int arr[] = new int[] {2,3,7,8,10};
		int sum = 11;
		int n = arr.length;
		
//		approach 1
		System.out.println(knapSackRecursive(arr, sum, n));
		
		boolean t[][] = new boolean[n+1][sum+1];
//		1 row false, 1 col true, arr[0][0] true
		for(int i=0; i<n+1; i++) {
			t[i][0] = true;
		}
//		approach 2
		System.out.println(knapSackDP(arr, sum, n, t));
		
	}

	public static boolean knapSackDP(int[] arr, int sum, int n, boolean[][] t) {
		// TODO Auto-generated method stub
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=sum; j++) {
				if(arr[i-1] <= j) {
					t[i][j] = t[i-1][j] || t[i-1][j-arr[i-1]];
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][sum];
	}

	private static boolean knapSackRecursive(int[] arr, int sum, int n) {
		if(sum == 0) return true;
		if(n==0) return false;
		return knapSackRecursive(arr, sum-arr[n-1], n-1) || knapSackRecursive(arr, sum, n-1);		
	}

}
