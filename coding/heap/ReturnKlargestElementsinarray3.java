package coding.heap;

import java.util.PriorityQueue;

public class ReturnKlargestElementsinarray3 {
	
	public static void main(String[] args) {
		int arr[] = new int[] {7, 10, 4, 3, 20, 15};
		int k = 3;		
		heap(arr, k);
	}

	private static void heap(int[] arr, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for(int x : arr) {
			minHeap.add(x);
			if(minHeap.size() > k) {
				minHeap.poll();
			}
		}
		System.out.println(minHeap);
	}
}
