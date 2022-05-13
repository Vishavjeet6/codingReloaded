package coding.dynamicProgramming;

public class A26Minimumnumberofinsertioninastringtomakeitapalindrome32 {
	
	public static void main(String[] args) {
		String a = new String("aebebda");
		lcs(a, a.length());
	}

	private static void lcs(String a, int n) {
		int lcs = A21LongestPalindromicSubsequence26.lcs(a,n);
		System.out.println(n-lcs);
	}

}
