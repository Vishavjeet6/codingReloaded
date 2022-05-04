package coding.dynamicProgramming;

public class A06CountofSubsetsSumwithaGivenSum9 {
	
	public static void main(String[] args) {
		int arr[] = new int[] {2,3,5,6,8,10};
		int sum = 10;
		int n = arr.length;
		
		
		int t[][] = new int[n+1][sum+1];
		for(int i=0; i<n+1; i++) {
			t[i][0] = 1;
		}
		System.out.println(knapSackDP(arr, sum, n, t));		
		}

		public static int knapSackDP(int[] arr, int sum, int n, int[][] t) {
			// TODO Auto-generated method stub
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=sum; j++) {
					if(arr[i-1] <= j) {
						t[i][j] = t[i-1][j] + t[i-1][j-arr[i-1]];
					}else {
						t[i][j] = t[i-1][j];
					}
				}
			}
			return t[n][sum];
		}
}
