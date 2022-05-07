package coding.dynamicProgramming;

public class A19ShortestCommonSuperSequence24 {
	
	public static void main(String[] args) {
		String x = "geek";
		String y = "eke";
//		String x = "acbcf";
//		String y = "acbcdaf";
//		merge x, y
//		like geekeke or geeke return shortest
		int n = x.length();
		int m = y.length();
		lcs(x,y, n, m);
	}

	private static void lcs(String x, String y, int n, int m) {
		if(n==0 || m== 0) {
			System.out.println(-1);
			return;
		}
		int [][] t = new int[n+1][m+1];
		StringBuilder ans = new StringBuilder("");
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<m+1; j++) {
				if(x.charAt(i-1) == y.charAt(j-1)) {
					t[i][j] = 1+t[i-1][j-1];
				}else {
					t[i][j] = Math.max(t[i-1][j], t[i][j-1]); 
				}
			}
		}
		
		StringBuilder lcs = new StringBuilder("");
		int i=n; int j=m;
		while(i>0 && j>0) {
			if(x.charAt(i-1) == y.charAt(j-1)) {
				lcs.append(x.charAt(i-1));
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
		lcs.reverse();
		
//		if length is required than
		int l = x.length() + y.length() - lcs.length();
		System.out.println(l);
		
//		to print other approach
//		in A23
		
//		to print the string mine approach
		i=0;
		j=0;
		int k=0;
		while(i<n && j<m && k<lcs.length()) {
			if(x.charAt(i) == lcs.charAt(k) && y.charAt(j) == lcs.charAt(k)) {
				ans.append(lcs.charAt(k));
				i++;
				j++;
				k++;
			}else {
				if(x.charAt(i) == lcs.charAt(k)) {
					ans.append(y.charAt(j));
					j++;
				}else{
					ans.append(x.charAt(i));
					i++;
				}
			}
		}
		while(i<n) {
			ans.append(x.charAt(i));
			i++;
		}
		while(j<m) {
			ans.append(y.charAt(j));
			j++;
		}
		System.out.println(ans);
	}
}
