package coding.recursion;

public class A12PrintSubsetsPrintPowerSetsPrintallSubsequences12 {
	
	public static void main(String[] args) {
		String s = "ab";
		subset(s);
	}

	private static void subset(String s) {
		recursive(s, 0, "");
	}

	private static void recursive(String s, int i, String ans) {
		if(i == s.length()) {
			System.out.println("-> " + ans);
			return;
		}
		recursive(s, i+1, ans+s.charAt(i));
		recursive(s, i+1, ans);
	}

}
