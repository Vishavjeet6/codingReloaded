package coding.heap;

import java.util.PriorityQueue;

public class ConnectRopetoMinimisetheCost9 {
	public static void main(String[] args) {
		int arr[] = new int[] {4,3,2,6};
		heap(arr);
	}

	private static void heap(int[] arr) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for(int x: arr) {
			minHeap.add(x);
		}
		
		int ans = 0;
		int fMin= 0;
		int sMin=0;
		while(minHeap.size()>=2) {
			fMin = minHeap.poll();
			sMin = minHeap.poll();
			ans += (fMin+sMin);
			minHeap.add(fMin+sMin);
		}
		System.out.println(ans);
	}
	
}
