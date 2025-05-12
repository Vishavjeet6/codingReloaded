package coding.stack;

import java.util.Stack;

public class A11MinStack11 {
	
	Stack<Integer> s;
	int minElement;
	
	A11MinStack11(){
		s = new Stack<Integer>();
	}
	
	void push(int a) {
		if(s.isEmpty()) {
			minElement = a;
			s.push(a);
		}else if(a<minElement) {
			s.push(2*a-minElement);
			minElement = a;
		}else {
			s.push(a);
		}
	}
	
	int pop() {
		if(s.isEmpty()) {
			return -1;
		}
		int temp = s.pop();
		if(temp < minElement) {
			minElement = 2*minElement - temp;
		}
		return temp;
	}
	
	int getMinElement() {
		return minElement;    
	}
	
	public static void main(String[] args) {
		A11MinStack11 o = new A11MinStack11();
		o.push(18);
		o.push(19);
		o.push(15);
		System.out.println(o.getMinElement());
		o.pop();
		System.out.println(o.getMinElement());	
	}

}
