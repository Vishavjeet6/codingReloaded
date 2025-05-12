package coding.recursion;

import java.util.Stack;

public class A7SortAStack7 {
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(10);
		st.push(1);
		st.push(100);
		st.push(99);
		st.push(4);
		sort(st);
		st.forEach(System.out::println);
		
	}

	private static void sort(Stack<Integer> st) {
		if(st.size() == 1) return;
		int temp = st.pop();
		sort(st);
		insert(st, temp);		
	}

	private static void insert(Stack<Integer> st, int temp) {
		if(st.isEmpty() || st.peek() <= temp) {
			st.push(temp);
			return;
		}
		int val = st.pop();
		insert(st, temp);
		st.push(val);
		return;
	}
}
