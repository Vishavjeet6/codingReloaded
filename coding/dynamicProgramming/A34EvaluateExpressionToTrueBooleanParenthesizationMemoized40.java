package coding.dynamicProgramming;

import java.util.Arrays;

public class A34EvaluateExpressionToTrueBooleanParenthesizationMemoized40 {
	
	static int[][][]t = new int[205][205][2];

	public static void main(String[] args) {
//		String s = "T^F&T";
		String s = "T|F^F&T|F^F^F^T|T&T^T|F^T^F&F^T|T^F";
		for(int [][]w: t) {
			for(int [] r : w) {
				Arrays.fill(r, -1);
			}
		}
		System.out.println(mcm(s, 0, s.length()-1, true));	
	}

	private static int mcm(String s, int i, int j, boolean isTrue) {
		if(i>j) return 0;

		if(i==j) {
			if(isTrue) return s.charAt(i) == 'T'?1:0;
			else return s.charAt(i) == 'F'?1:0;
		}
		if(t[i][j][isTrue?1:0] != -1) return t[i][j][isTrue?1:0];
		int ans = 0;
		for(int k=i+1; k<=j-1; k=k+2) {
			int lt = t[i][k-1][1]!=-1?t[i][k-1][1]:mcm(s, i, k-1, true);
			int lf = t[i][k-1][0]	!=-1?t[i][k-1][0]:mcm(s, i, k-1, false);
			int rt = t[k+1][j][1]!=-1?t[k+1][j][1]:mcm(s, k+1, j, true);
			int rf = t[k+1][j][0]!=-1?t[k+1][j][0]:mcm(s, k+1, j, false);
			if(s.charAt(k) == '^') {
				if(isTrue) {
					ans += lt*rf + lf*rt;
				}else {
					ans += lt*rt + lf*rf;
				}
			}else if(s.charAt(k) == '|') {
				if(isTrue) {
					ans += lt*rf + lt*rt + lf*rt;
				}else {
					ans += lf*rf;
				}
			}else {
				if(isTrue) {
					ans += lt*rt;
				}else {
					ans += lf*rf + lf*rt + lt*rf;
				}	
			}
		}
		return t[i][j][isTrue?1:0] = ans;
	}

}
