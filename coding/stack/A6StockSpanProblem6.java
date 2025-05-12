package coding.stack;

import java.util.Arrays;
import java.util.Stack;

public class A6StockSpanProblem6 {
	
	public static void ngl(int[] arr) {
		int n = arr.length;
		Stack<Integer> st = new Stack<>();
		int [] ans = new int[n];
		for(int i=0; i<n; i++) {
			while(!st.isEmpty() && arr[st.peek()] <= arr[i]) {
				st.pop();
			}
			
			ans[i] = st.isEmpty() ? i+1 : i-st.peek();
			st.push(i);
		}
		
		System.out.println(Arrays.toString(ans));
	}
	
	public static void main(String[] args) {
		ngl(new int[] {100, 80, 60, 70, 60, 75, 85});
		
	}

}
