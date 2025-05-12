package coding.heap;

import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;

public class A5KClosestNumbers5 {
//	key is difference
	public static void main(String[] args) {
		int arr[] = new int[] {5,6,7,8,9};
		int k = 3;		
		int x = 5;
		heap(arr, k, x);
	}
	
//	Using Java-8
//
//	PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(Map.Entry.comparingByValue(Comparator.reverseOrder()));
//	to add a new Entry
//
//	queue.offer(new AbstractMap.SimpleEntry<>("A", 10));
	
	private static void heap(int[] arr, int k, int x) {
		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(Map.Entry.comparingByValue(Comparator.reverseOrder()));
		for(int y: arr) {
			maxHeap.add(new AbstractMap.SimpleEntry<>(Math.abs(y-x), y));
			if(maxHeap.size()>k) {
				maxHeap.poll();
			}
		}
		maxHeap.stream().forEach(e-> System.out.println(e.getValue()));
		
	}

}
