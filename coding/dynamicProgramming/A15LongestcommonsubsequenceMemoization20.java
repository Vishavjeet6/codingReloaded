package coding.dynamicProgramming;

import java.util.Arrays;

public class A15LongestcommonsubsequenceMemoization20 {
	
	public static void main(String[] args) {
		String x = "abcdgh";
		String y = "abedfhr";
		int n = x.length();
		int m = y.length();
		int t[][] = new int[n+1][m+1];
		for(int[] arr1 : t) 
			  Arrays.fill(arr1, -1);
		System.out.println(lcs(x,y, n, m, t));
	}

	private static int lcs(String x, String y, int n, int m, int[][]t) {
		// TODO Auto-generated method stub
		if(n==0 || m==0) {
			return 0;
		}
		if(t[n][m] != -1) return t[n][m];
		if(x.charAt(n-1) == y.charAt(m-1)) {
			return t[n][m] = 1+lcs(x, y, n-1, m-1, t);
		}else {
			return t[n][m] = Math.max(lcs(x,y, n, m-1, t), lcs(x, y, n-1, m, t));
		}
	}

}