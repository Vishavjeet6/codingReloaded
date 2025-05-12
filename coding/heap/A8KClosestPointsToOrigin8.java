package coding.heap;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;

public class A8KClosestPointsToOrigin8 {

	public static void main(String[] args) {
		int arr[][] = new int[][] {{1,3},{-2,2},{5,8},{0,1}};	
		int k = 2;
		heap(arr, k);
	}
	
	public static int distance(int x, int y) {
		return (x*x + y*y);
	}

	private static void heap(int[][] arr, int k) {
		// TODO Auto-generated method stub
//		index, distance
		PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
		
		for(int i=0; i<arr.length; i++) {
			maxHeap.add(new AbstractMap.SimpleEntry<>(i, distance(arr[i][0], arr[i][1])));
			if(maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		
		maxHeap.stream().forEach(x-> System.out.println(Arrays.toString(arr[x.getKey()])));
		
		
		
	}
}
