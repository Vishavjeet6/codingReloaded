package coding.stack;

import java.util.Stack;

public class A10MinStackSpace10 {
	
	Stack<Integer> s;
	Stack<Integer> ss;
	
	A10MinStackSpace10(){
		s = new Stack<Integer>();
		ss = new Stack<Integer>();
	}
	
	void push(int a) {
		s.push(a);
		if(ss.isEmpty() || ss.peek() >= a) {
			ss.push(a);
		}
	}
	
	int pop() {
		if(ss.peek().equals(s.peek())) {
			ss.pop();
		}
		return s.pop();
	}
	
	int minElement() {
		return ss.peek();
		
	}
	
	public static void main(String[] args) {
		A10MinStackSpace10 o = new A10MinStackSpace10();
		o.push(18);
		o.push(19);
		o.push(15);
		System.out.println(o.minElement());
		o.pop();
		System.out.println(o.minElement());	
	}

}
