package coding.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElement2 {

	
	//nlogk
	public static void main(String[] args) {
		int arr[] = new int[] {7, 10, 4, 3, 20, 15};
		int k = 3;
		
		heap(arr, k);
	}

	private static void heap(int[] arr, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
		for(int x : arr) {
			maxHeap.add(x);
			if(maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		System.out.println(maxHeap.peek());
	}

}
