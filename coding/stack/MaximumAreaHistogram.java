package coding.stack;

import java.util.Arrays;
import java.util.Stack;

public class MaximumAreaHistogram {
	
	public static void mah(int[] arr) {
		int n = arr.length;
		int maxArea = 0;
		int currArea = 0;
		Stack<Integer> nsl = new Stack<>();
		Stack<Integer> nsr = new Stack<>();
		int [] nl = new int[n];
		int [] nr = new int[n]; 
		
		for(int i=0; i<n; i++) {
			while(!nsl.isEmpty() && arr[nsl.peek()] >= arr[i]) {
				nsl.pop();
			}
			nl[i] = nsl.isEmpty() ? -1 : nsl.peek();
			nsl.push(i);
		}
		System.out.println(Arrays.toString(nl));
		
		for(int i=n-1; i>=0; i--) {
			while(!nsr.isEmpty() && arr[nsr.peek()] >= arr[i]) {
				nsr.pop();
			}
			nr[i] = nsr.isEmpty() ? n : nsr.peek();
			nsr.push(i);
		}
		System.out.println(Arrays.toString(nr));
		
		for(int i=0 ;i<n; i++) {
			currArea = (nr[i]-nl[i]-1)*arr[i];
			maxArea= Math.max(maxArea, currArea);
		}
		
		System.out.println(maxArea);
	}
	
	public static void main(String[] args) {
		mah(new int[] {6,2,5,4,5,1,6});
	}

}
