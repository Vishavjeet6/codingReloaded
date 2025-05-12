package coding.recursion;

public class A14Permutationwithspaces14 {

	public static void main(String[] args) {
		String s = "abc";
		recursive(s,0,"");
	}

	private static void recursive(String s,int i, String ans) {
		if(i==s.length()) {
			System.out.println("-> " + ans);
			return;
		}
		if(i==s.length()-1) {
			recursive(s, i+1, ans+s.charAt(i));
		}else {
			recursive(s, i+1, ans+s.charAt(i)+'-');
			recursive(s, i+1, ans+s.charAt(i));
		}
	}
}
