package coding.recursion;

import java.util.Arrays;
import java.util.Vector;

public class SortAnarrayusingRecursion6 {
	
	public static void main(String[] args) {
		Vector<Integer> arr = new Vector<>(Arrays.asList(4,1,0,22,11,33,12,9,6,10));
		sort(arr);
		System.out.println(arr.toString());
	}

	private static void sort(Vector<Integer> arr) {
//		System.out.println(arr.toString());
		if(arr.size() == 1) return;		
		int temp = arr.remove(arr.size()-1);
		sort(arr);
		insert(arr, temp);
	}

	private static void insert(Vector<Integer> arr, int temp) {
//		System.out.println(arr.toString());
		if(arr.size()==0 || arr.lastElement() <= temp) {
			arr.add(temp);
			return;
		}
		int val = arr.remove(arr.size()-1);
		insert(arr, temp);
		arr.add(val);
		return;
	}
}
