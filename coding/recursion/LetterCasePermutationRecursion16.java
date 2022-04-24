package coding.recursion;

public class LetterCasePermutationRecursion16 {

	public static void main(String[] args) {
//		small case, upper case, digit included
		String s = "a1B2";
		recursive(s,0,"");
	}

	private static void recursive(String s,int i, String ans) {
		if(i==s.length()) {
			System.out.println("-> " + ans);
			return;
		}
		if(Character.isAlphabetic(s.charAt(i))) {
			recursive(s, i+1, ans+Character.toUpperCase(s.charAt(i)));
			recursive(s, i+1, ans+Character.toLowerCase(s.charAt(i)));
		}else {
			recursive(s, i+1, ans+s.charAt(i));
		}

	}
}