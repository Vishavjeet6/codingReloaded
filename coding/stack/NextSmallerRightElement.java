package coding.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerRightElement {

	public static void nsr(int[] arr) {
		int n = arr.length;
		Stack<Integer> st = new Stack<Integer>();
		int [] ans = new int[n];
		for(int i=n-1; i>=0; i--) {
			while(!st.isEmpty() && st.peek() >= arr[i] ) {
				st.pop();
			}
			ans[i] = st.isEmpty() ? -1 : st.peek();
			st.push(arr[i]);
		}
		System.out.println(Arrays.toString(ans));
	}
	
	public static void main(String[] args) {
		nsr(new int[] {1,3,2,4});
		nsr(new int[] {1,2,3,4,4});
		nsr(new int[] {4,3,2,0,1});
	}

}
