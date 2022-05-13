package coding.dynamicProgramming;

public class A33EvaluateExpressiontoTrueBooleanParenthesizationRecursive39 {
	
	
//	Given a boolean expression with following symbols.
//	Symbols
//	    'T' --- true 
//	    'F' --- false 
//	And following operators filled between symbols
//	Operators
//	    &   ---boolean AND
//	    |   --- boolean OR
//	    ^   --- boolean XOR 
//	Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.
//	Example:
//	Input: symbol[]    = {T, F, T}
//	       operator[]  = {^, &}
//	Output: 2
//	The given expression is "T ^ F & T", it evaluates true
//	in two ways "((T ^ F) & T)" and "(T ^ (F & T))"
	
	public static void main(String[] args) {
		String s = "T^F&T";
		System.out.println(mcm(s, 0, s.length()-1, true));
		String s1 = "T|F^F&T|F^F^F^T|T&T^T|F^T^F&F^T|T^F";
		System.out.println(mcm(s1, 0, s1.length()-1, true));
		
	}

	private static int mcm(String s, int i, int j, boolean isTrue) {
		if(i>j) return 0;
		if(i==j) {
			if(isTrue == true) return s.charAt(i) == 'T'?1:0;
			else return s.charAt(i) == 'F'?1:0;
		}
		int ans = 0;
		for(int k=i+1; k<=j-1; k=k+2) {
			int lt = mcm(s, i, k-1, true);
			int lf = mcm(s, i, k-1, false);
			int rt = mcm(s, k+1, j, true);
			int rf = mcm(s, k+1, j, false);
			if(s.charAt(k) == '^') {
				if(isTrue) {
					ans += lt*rf + lf*rt;
				}else {
					ans += lt*rt + lf*rf;
				}
			}else if(s.charAt(k) == '|') {
				if(isTrue) {
					ans += lt*rf + lt*rt + lf*rt;
				}else {
					ans += lf*rf;
				}
			}else {
				if(isTrue) {
					ans += lt*rt;
				}else {
					ans += lf*rf + lf*rt + lt*rf;
				}
				
			}
		}
		return ans;
	}

}
