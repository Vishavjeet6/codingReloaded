package coding.recursion;

public class A11TowerofHanoi11 {
	
	static int count = 0;
	
	public static void main(String[] args) {
		int n = 4;
		int source = 1;
		int helper = 2;
		int destination = 3;
		hanoi(n, source, destination, helper);
		System.out.println("Count " + count);
		
	}
	
	public static void hanoi(int n, int s, int d, int h) {
		 count++;
		 if(n==1) {
			 System.out.println("Moving Plate " + n + " from " + s +" to " + d);
			 return;
		 }
		 hanoi(n-1, s, h, d);
		 System.out.println("Moving Plate " + n + " from " + s +" to " + d);
		 hanoi(n-1, h, d, s);
		 return;
	} 

}
