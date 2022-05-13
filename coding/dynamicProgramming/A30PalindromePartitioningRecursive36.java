package coding.dynamicProgramming;

public class A30PalindromePartitioningRecursive36 {

//	Given a string, a partitioning of the string is a palindrome partitioning if 
//	every substring of the partition is a palindrome. 
//	Example:
//	  “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”.
	
//	minimum partitions
	public static void main(String[] args) {
		String s = "asdivids";
		System.out.println(mcm(s, 0, s.length()-1));
	}
	
	public static int mcm(String s, int i, int j) {
		if(i>=j) return 0;
		if(isPalindrome(s,i,j)) return 0;
		int ans = Integer.MAX_VALUE;
		for(int k=i; k<=j-1; k++) {
			int temp = 1 + mcm(s, i, k) + mcm(s, k+1, j);
			ans = Math.min(ans, temp);
		}
		
		return ans;
	}

	private static boolean isPalindrome(String s, int i, int j) {
		while(i<=j) {
			if(s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
				continue;
			}else {
				return false;
			}
		}
		return true;
	}
}
