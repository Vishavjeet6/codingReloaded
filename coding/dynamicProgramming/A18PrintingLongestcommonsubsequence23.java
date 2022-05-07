package coding.dynamicProgramming;

public class A18PrintingLongestcommonsubsequence23 {
	
	public static void main(String[] args) {
		String x = "acbcf";
		String y = "abcdaf";
		int n = x.length();
		int m = y.length();
		System.out.println(lcs(x,y, n, m));
	}

	static StringBuilder lcs(String x, String y, int n, int m) {
		// TODO Auto-generated method stub
		if(n==0 || m==0) {
			return new StringBuilder("NOTHING");
		}
		StringBuilder s = new StringBuilder("");
		int [][] t = new int[n+1][m+1];
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<m+1; j++) {
				if(x.charAt(i-1) == y.charAt(j-1)) {
					t[i][j] = 1 + t[i-1][j-1];
				}else {
					t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
				}
			}
		}
		int i=n; int j=m;
		while(i>0 && j>0) {
			if(x.charAt(i-1) == y.charAt(j-1)) {
				s.append(x.charAt(i-1));
				i--;
				j--;
			}else {
				if(t[i-1][j] > t[i][j-1]) {
					i--;
				}else {
					j--;
				}
			}
		}
		return s.reverse();
	}
}