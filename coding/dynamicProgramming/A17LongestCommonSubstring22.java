package coding.dynamicProgramming;

import java.util.Arrays;

public class A17LongestCommonSubstring22 {
	public static void main(String[] args) {
		String x = "abcdgh";
		String y = "abedfhr";
		int n = x.length();
		int m = y.length();
		System.out.println(lcs(x,y, n, m));
	}

	static int lcs(String x, String y, int n, int m) {
		// TODO Auto-generated method stub
		if(n==0 || m==0) {
			return 0;
		}
		int max = 0;
		int [][] t = new int[n+1][m+1];
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<m+1; j++) {
				if(x.charAt(i-1) == y.charAt(j-1)) {
					t[i][j] = 1 + t[i-1][j-1];
				}else {
//					t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
					t[i][j] = 0;
				}
				max = Math.max(max,  t[i][j]);
			}
		}
		for(int[] w: t) {
			System.out.println(Arrays.toString(w));
		}
		return max;
	}

}