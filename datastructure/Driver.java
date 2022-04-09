package datastructure;

public class Driver {
	
	public static void main(String[] args) {
		stackds();
	}

	private static void stackds() {
		// TODO Auto-generated method stub
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Popped from stack");
        System.out.println("Top element is :" + s.peek());
        System.out.println("Elements present in stack :");
        s.print();
		
	}
}
