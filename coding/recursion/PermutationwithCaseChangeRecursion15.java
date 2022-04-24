package coding.recursion;

public class PermutationwithCaseChangeRecursion15 {
	
	public static void main(String[] args) {
		String s = "ab";
		recursive(s,0,"");
	}

	private static void recursive(String s,int i, String ans) {
		if(i==s.length()) {
			System.out.println("-> " + ans);
			return;
		}
		recursive(s, i+1, ans+Character.toUpperCase(s.charAt(i)));
		recursive(s, i+1, ans+s.charAt(i));
	}
}
