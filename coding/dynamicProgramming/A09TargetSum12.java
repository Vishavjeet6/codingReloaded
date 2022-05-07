package coding.dynamicProgramming;

import java.util.Arrays;

public class A09TargetSum12 {
	
	public static void main(String[] args) {
		int [] arr = new int[] {1,1,2,3};
		int sum = 1;
//		+1-1-2+3
		knapSackDP(arr, sum);
	}

	private static void knapSackDP(int[] arr, int diff) {
//		s1+s2 = s
//		s1-s2 = d
//		s1 = (s+d)/2
		int n = arr.length;
		int sum = Arrays.stream(arr).sum();
		int targetSum = (sum + diff)/2;
		int[][] t = new int[n+1][targetSum+1];
		
		for(int i=0; i<n+1; i++) {
			t[i][0] = 1;
		}
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<targetSum+1; j++) {
				if(arr[i-1] <= j) {
					t[i][j] = t[i-1][j] + t[i-1][j-arr[i-1]];
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		System.out.println(t[n][targetSum]);
		
	}
}