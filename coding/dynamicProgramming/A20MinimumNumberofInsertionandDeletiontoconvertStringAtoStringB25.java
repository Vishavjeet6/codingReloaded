package coding.dynamicProgramming;

public class A20MinimumNumberofInsertionandDeletiontoconvertStringAtoStringB25 {
	
	public static void main(String[] args) {
		String a = "heap";
		String b = "pea";
		int n = a.length();
		int m = b.length();
		lcs(a,b, n, m);	
	}

	private static void lcs(String a, String b, int n, int m) {
		int lcs = A16LongestcommonsubsequenceTopdownDP21.lcs(a,b,n,m);
		int ins = 0;
		int del = 0;
		del = a.length() - lcs;
		ins = b.length() - lcs;
		System.out.println("Insertion " + ins);
		System.out.println("Deletion " + del);
	}

}
