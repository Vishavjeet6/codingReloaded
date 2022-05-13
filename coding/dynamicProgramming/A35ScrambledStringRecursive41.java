package coding.dynamicProgramming;

public class A35ScrambledStringRecursive41 {

/*
	Scramble String using Recursion
	Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
	Below is one possible representation of A = “great”:
	 great
	   /    \
	  gr    eat
	 / \    /  \
	g   r  e   at
	           / \
	          a   t
	To scramble the string, we may choose any non-leaf node and swap its two children.
*/
	public static void main(String[] args) {
		String a = "great";
		String b = "rgeat";
		System.out.println(isScrambled(a, b));
	}

	private static boolean isScrambled(String a, String b) {
		// TODO Auto-generated method stub
		if(a.length() != b.length()) return false;
		if(a == "" && b == "") return true;
		if(a.length() == 0) return false;
		if(a.equals(b)) return true;
		boolean ans = false;
		int n = a.length();
		for(int i=0; i<=n-1; i++) {
			if(
					(isScrambled(a.substring(0, i), b.substring(0, i)) && 
							isScrambled(a.substring(i+1, n), b.substring(i+1, n))) 
					||
					(isScrambled(a.substring(0, i), b.substring(i+1, n)) && 
							isScrambled(a.substring(i+1, n), b.substring(0, i))) 
					) {
				ans = true;
				break;
			}
		}
		return ans;
	}
}
