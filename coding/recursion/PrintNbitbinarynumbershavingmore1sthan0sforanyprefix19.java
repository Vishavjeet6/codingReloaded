package coding.recursion;

public class PrintNbitbinarynumbershavingmore1sthan0sforanyprefix19 {
	
	public static void main(String[] args) {
		int n = 5;
		recursive(n, 0, 0, "");
	}

	private static void recursive(int n, int c1, int c0, String ans) {
		if(c1+c0 == n) {
			System.out.println(ans);
			return;
		}
		if(c1>c0) {
			recursive(n, c1, c0+1, ans+'0');
			recursive(n, c1+1, c0, ans+'1');
		}else {
			recursive(n, c1+1, c0, ans+'1');
		}
	}

}
