package coding.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class A36ScrambledStringMemoized42 {
	
	static Map<String, Boolean> map = new HashMap<>();

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
		if(map.containsKey(a+"-"+b)) return map.get(a+"-"+b);
		boolean ans = false;
		int n = a.length();
		for(int i=1; i<=n-1; i++) {
			if(
					(isScrambled(a.substring(0, i), b.substring(0, i)) && 
							isScrambled(a.substring(i), b.substring(i))) 
					||
					(isScrambled(a.substring(0, i), b.substring(n-i)) && 
							isScrambled(a.substring(i), b.substring(0, n-i))) 
					) {
				ans = true;
				break;
			}
		}
		map.put(a+"-"+b, ans);
		return  ans;
	}
}