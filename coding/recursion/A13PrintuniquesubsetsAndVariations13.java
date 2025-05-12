package coding.recursion;

import java.util.HashSet;
import java.util.Set;

public class A13PrintuniquesubsetsAndVariations13 {
	
	private static Set<String> ss = new HashSet<>();

	public static void main(String[] args) {
		
		String s = "aab";
		subset(s);
		System.out.println(ss);
	}

	private static void subset(String s) {
		recursive(s, 0, "");
	}

	private static void recursive(String s, int i, String ans) {
		if(i == s.length()) {
			ss.add(ans);
			return;
		}
		recursive(s, i+1, ans+s.charAt(i));
		recursive(s, i+1, ans);
	}
}
