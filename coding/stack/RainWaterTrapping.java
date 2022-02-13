package coding.stack;

import java.util.Arrays;
import java.util.Stack;

public class RainWaterTrapping {
	
	public static void rwt(int[] arr) {
		int n = arr.length;
		int [] maxL = new int[n];
		int [] maxR = new int[n];
		Stack<Integer> st = new Stack<>();
		
		for(int i=0; i< n; i++) {
			if(!st.isEmpty() && st.peek() > arr[i]) {
				maxL[i] = st.peek();
			}
			if(st.isEmpty()) {
				maxL[i] = arr[i];
				st.push(arr[i]);
			}else if(st.peek() <= arr[i]) {
				maxL[i] = arr[i];
				st.pop();
				st.push(arr[i]);
			}
		}
		st.clear();
		for(int i=n-1; i>=0; i--) {
			if(!st.isEmpty() && st.peek() > arr[i]) {
				maxR[i] = st.peek();
			}
			
			if(st.isEmpty()) {
				st.push(arr[i]);
				maxR[i] = arr[i];
		
			}else if(st.peek() <= arr[i]) {
				maxR[i] = arr[i];
				st.pop();
				st.push(arr[i]);
			}
		}
		
		
		System.out.println(Arrays.toString(maxL));
		System.out.println(Arrays.toString(maxR));
		
		int ans = 0;
		
		for(int i=0 ; i<n ; i++) {
			ans += Math.min(maxL[i], maxR[i]) - arr[i];
		}
		
		System.out.println(ans);
		
		
	}
	
	
	public static void rwtgood(int[] arr) {
		int n = arr.length;
		int [] maxL = new int[n];
		int [] maxR = new int[n];
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {
			if(arr[i] > max) {
				maxL[i] = arr[i];
				max = arr[i];
			}else {
				maxL[i] = max;
			}
		}
		
		max = Integer.MIN_VALUE;
		
		for(int i=n-1; i>=0; i--) {
			if(arr[i] > max) {
				maxR[i] = arr[i];
				max = arr[i];
			}else {
				maxR[i] = max;
			}
		}
		
		System.out.println(Arrays.toString(maxL));
		System.out.println(Arrays.toString(maxR));
		
		int ans = 0;
		
		for(int i=0 ; i<n ; i++) {
			ans += Math.min(maxL[i], maxR[i]) - arr[i];
		}
		
		System.out.println(ans);
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		rwt(new int [] {3,0,0,2,0,4});
		rwtgood(new int [] {3,0,0,2,0,4});
		
	}


}
