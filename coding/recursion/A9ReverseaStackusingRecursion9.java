package coding.recursion;

import java.util.Stack;

public class A9ReverseaStackusingRecursion9 {
	
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(1);
		st.push(11);
		st.push(22);
		st.push(33);
		st.push(44);
		reverse(st);
		st.forEach(System.out::println);
	}

	private static void reverse(Stack<Integer> st) {
		if(st.size() == 1) return;
		int temp = st.pop();
		reverse(st);
		insertAtStart(st, temp);
	}

	private static void insertAtStart(Stack<Integer> st, int temp) {
		if(st.isEmpty()) {
			st.push(temp);
			return;
		}
		int val = st.pop();
		insertAtStart(st, temp);
		st.push(val);
		return;
	}

}
