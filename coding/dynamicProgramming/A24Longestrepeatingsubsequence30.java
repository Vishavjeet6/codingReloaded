package coding.dynamicProgramming;


public class A24Longestrepeatingsubsequence30 {
	
	public static void main(String[] args) {
		String s = "aabebcdd";
//		ans -> 3(abd) abd-abd
		int n = s.length();
		lcs(s,n);
	}

	private static void lcs(String x, int n) {
		String y = new String(x);
		int m = y.length();
		// TODO Auto-generated method stub
		if(n==0 || m==0) {
			System.out.println("NOTHING");
			return;
		}
		StringBuilder s = new StringBuilder("");
		int [][] t = new int[n+1][m+1];
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<m+1; j++) {
				if(x.charAt(i-1) == y.charAt(j-1) && i != j) {
					t[i][j] = 1 + t[i-1][j-1];
				}else {
					t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
				}
			}
		}
		System.out.println(t[n][m]);
		int i=n; int j=m;
		while(i>0 && j>0) {
			if(x.charAt(i-1) == y.charAt(j-1) && i!=j) {
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
		System.out.println(s.reverse());
	}

}
