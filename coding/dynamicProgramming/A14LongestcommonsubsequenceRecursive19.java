package coding.dynamicProgramming;

public class A14LongestcommonsubsequenceRecursive19 {
	
	public static void main(String[] args) {
		String x = "abcdgh";
		String y = "abedfhr";
		int n = x.length();
		int m = y.length();
		System.out.println(lcs(x,y, n, m));
	}

	private static int lcs(String x, String y, int n, int m) {
		// TODO Auto-generated method stub
		if(n==0 || m==0) {
			return 0;
		}
		if(x.charAt(n-1) == y.charAt(m-1)) {
			return 1+lcs(x, y, n-1, m-1);
		}else {
			return Math.max(lcs(x,y, n, m-1), lcs(x, y, n-1, m));
		}
	}

}
