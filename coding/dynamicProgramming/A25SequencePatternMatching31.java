package coding.dynamicProgramming;

public class A25SequencePatternMatching31 {

	public static void main(String[] args) {
		String a = "AXY";
		String b = "ADXCPY";
//		is a subsequence of b
		System.out.println(lcs(a,b));
	}

	private static boolean lcs(String a, String b) {
		// TODO Auto-generated method stub
		
//		one approach
		StringBuilder c = A18PrintingLongestcommonsubsequence23.lcs(a, b, a.length(), b.length());
		System.out.println(c.toString().equals(a));
		
//		other approach is to compare the length of lcs with len(a)
		return A16LongestcommonsubsequenceTopdownDP21.lcs(a,b,a.length(), b.length()) == a.length();
	}
}
