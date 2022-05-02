package coding.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentNumbers6 {
	
	public static void main(String[] args) {
		int arr[] = new int[] {1,1,1,3,2,2,4};
		int k = 2;		
		heap(arr, k);
	}

	private static void heap(int[] arr, int k) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> map = new HashMap<>();
		for(int x : arr) {
			map.put(x, map.getOrDefault(x, 0)+1);
		}
//		System.out.println(map);
		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			minHeap.add(entry);
			if(minHeap.size()>k) {
				minHeap.poll();
			}
		}
		minHeap.stream().forEach(e-> System.out.println(e.getKey()));
	}

}
