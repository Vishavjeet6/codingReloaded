package coding.dynamicProgramming;

import java.util.Arrays;

public class A31PalindromePartitioningMemoization37 {
	
	static int [][] t = new int[1001][1001];

	public static void main(String[] args) {
		String s = "nitik";
		
		for(int [] w: t) {
			Arrays.fill(w, -1);
		}
		System.out.println(mcm(s, 0, s.length()-1));
	}
	
	public static int mcm(String s, int i, int j) {
		if(i>=j) return 0;
		if(isPalindrome(s,i,j)) return 0;
		if(t[i][j] != -1) return t[i][j];
		int ans = Integer.MAX_VALUE;
		for(int k=i; k<=j-1; k++) {
			int temp = 1 + mcm(s, i, k) + mcm(s, k+1, j);
			ans = Math.min(ans, temp);
		}
		
		return t[i][j] = ans;
	}

	private static boolean isPalindrome(String s, int i, int j) {
		while(i<=j) {
			if(s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
				continue;
			}else {
				return false;
			}
		}
		return true;
	}
}
