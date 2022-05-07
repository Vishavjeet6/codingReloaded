package coding.dynamicProgramming;

public class A23PrintshortestcommonSupersequence29 {

	public static void main(String[] args) {
		String x = "acbcf";
		String y = "acbcdaf";
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

		int i=n; int j=m;
		while(i>0 && j>0) {
			if(x.charAt(i-1) == y.charAt(j-1)) {
				ans.append(x.charAt(i-1));
				i--;
				j--;
			}else {
				if(t[i-1][j] > t[i][j-1]) {
					ans.append(x.charAt(i-1)); 
					i--;
				}else {
					ans.append(y.charAt(j-1));
					j--;
				}
			}
		}
		while(i>0) {
			ans.append(x.charAt(i-1));
			i--;
		}
		while(j>0) {
			ans.append(y.charAt(j-1));
			j--;
		}
		ans.reverse();
		System.out.println(ans);
	}
}
