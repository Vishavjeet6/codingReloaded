package coding.heap;

import java.util.PriorityQueue;
import java.util.Vector;

public class SortaKSortedArraySortNearlySortedArray4 {
	
	public static void main(String[] args) {
		int arr[] = new int[] {6,5,3,2,8,10,9};
		int k = 3;		
		heap(arr, k);
	}

	private static void heap(int[] arr, int k) {
		Vector<Integer> ans = new Vector<>(); 
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for(int x : arr) {
			minHeap.add(x);
			if(minHeap.size() > k) {
				ans.add(minHeap.poll());
			}
		}
		while(minHeap.size()>0) {
			ans.add(minHeap.poll());
		}
		System.out.println(ans);
	}
}
