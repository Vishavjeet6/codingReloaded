package datastructure;

public class Stack {
	
	static int MAX = 1000;
	int top;
	int[] arr = new int[MAX];
	
	
	Stack() {
		top = -1;
	}
	
	boolean isEmpty() {
		return (top<0);
	}
	
	void push(int x){
		if(top >= MAX-1) {
            System.out.println("Stack Overflow");
		}else {
			arr[++top] = x;
			System.out.println(x + " pushed into stack");
		}
	}
	
	int pop() {
		if(top < 0) {
            System.out.println("Stack Underflow");
            return 0;
		}
		int x = arr[top--];
		return x;
	}
	
	
	int peek() {
		if(top < 0) {
            System.out.println("Stack Underflow");
            return 0;
		}
		int x = arr[top];
		return x;		
	}

	void print() {
		for(int i=top; i>=0; i--) {
			System.out.print(arr[i] + " " );
		}
	}
}
