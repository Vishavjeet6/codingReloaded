package coding.recursion;

import java.util.Stack;

public class DeleteMiddleElementofaStack8 {
	
	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(10);
		st.push(1);
		st.push(100);
		st.push(99);
		st.push(4);
		int mid = st.size()/2 + 1;
		delete(st, mid);
		st.forEach(System.out::println);
		
	}

	private static void delete(Stack<Integer> st, int mid) {
		if(mid == 1) {
			st.pop();
			return;
		}
		int temp = st.pop();
		delete(st, mid-1);
		st.push(temp);
		return;
	}

}
