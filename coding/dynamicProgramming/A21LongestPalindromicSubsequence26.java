package coding.dynamicProgramming;

public class A21LongestPalindromicSubsequence26 {
	
	public static void main(String[] args) {
		String s = "agbcba";
		int n = s.length();
		lcs(s,n);	
	}

	private static void lcs(String s, int n) {
		String s2 = "";
		for(int i=s.length()-1; i>=0; i--) {
			s2 += s.charAt(i);
		}
		
		int lcs = A16LongestcommonsubsequenceTopdownDP21.lcs(s,s2,n,s2.length());
		System.out.println(lcs);
	}
}
