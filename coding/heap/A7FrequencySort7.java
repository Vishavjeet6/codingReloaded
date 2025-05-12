package coding.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Vector;

public class A7FrequencySort7 {

	public static void main(String[] args) {
		int arr[] = new int[] {1,1,1,3,2,2,4};
		int k = 2;		
		heap(arr, k);
	}

	private static void heap(int[] arr, int k) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> map = new HashMap<>();
		Vector<Integer> ans = new Vector<>();
		for(int x : arr) {
			map.put(x, map.getOrDefault(x, 0)+1);
		}
//		System.out.println(map);
		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
//		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(Map.Entry.comparingByValue(Comparator.reverseOrder()));

		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			maxHeap.add(entry);
			if(maxHeap.size()>k) {
				Entry<Integer, Integer> x = maxHeap.poll();
				for(int i=0; i<x.getValue(); i++) {
					ans.add(x.getKey());
				}
			}
		}
		while(maxHeap.size()>0) {
			Entry<Integer, Integer> x = maxHeap.poll();
			for(int i=0; i<x.getValue(); i++) {
				ans.add(x.getKey());
			}
		}
		System.out.println(ans);
	}

}