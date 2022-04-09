package coding.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterLeftElement3 {
	
	public static void ngl(int[] arr) {
		int n = arr.length;
		Stack<Integer> st = new Stack<Integer>();
		int [] ans = new int[n];
		for(int i=0; i<n; i++) {
			while(!st.isEmpty() && st.peek() <= arr[i] ) {
				st.pop();
			}
			ans[i] = st.isEmpty() ? -1 : st.peek();
			st.push(arr[i]);
		}
		System.out.println(Arrays.toString(ans));
	}
	
	public static void main(String[] args) {
		ngl(new int[] {1,3,2,4});
		ngl(new int[] {1,2,3,4,4});
		ngl(new int[] {4,3,2,0,1});
	}

}
