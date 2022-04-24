package coding.recursion;

public class GenerateallBalancedParentheses17 {
	public static void main(String[] args) {
		int n = 3;
		recursive(n, 0, 0, "");
	}

	private static void recursive(int n,int l, int r, String ans) {
		if(ans.length() == 2*n) {
			System.out.println(ans);
			return;
		}
		if(l>r) {
			if(r<n) {
				recursive(n, l, r+1, ans+')');
			}
			if(l<n) {
				recursive(n, l+1, r, ans+'(');
			}		
		}else {
			if(l<n) {
				recursive(n, l+1, r, ans+'(');
			}
		}
	}
}
