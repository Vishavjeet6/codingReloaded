package coding.heap;

import java.util.PriorityQueue;

public class SumofElementsbetweenk1smallestandk2smallestnumbers10 {
	public static void main(String[] args) {
		int arr[] = new int[] {1,3,12,5,15,11};
		int k1=3;
		int k2=6;
		heap(arr, k1, k2);
	}

	private static void heap(int[] arr, int k1, int k2) {
		// TODO Auto-generated method stub
		int maxK = Math.max(k1,  k2);
		int minK = Math.min(k1, k2);
		
		int sum = 0;
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> b-a);
		for(int x : arr) {
			maxHeap.add(x);
			if(maxHeap.size() == maxK) break;
		}
		maxHeap.poll();
		while(maxHeap.size()>minK) {
			sum += maxHeap.poll();
		}
		
		System.out.println(sum);
		
	}

}
