package coding.recursion;

public class Print1toN {
	
	public static void main(String[] args) {
		print(7);
	}

	private static void print(int x) {
		if(x==0) return;
		print(x-1);
		System.out.println(x);
		
	}
}
