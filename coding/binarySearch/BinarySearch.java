package coding.binarySearch;

public class BinarySearch {
//	O(logn)
	public static int binarySearch(int [] arr, int x) {
		int start = 0;
		int end = arr.length-1;
		while(start <= end) {
//			int mid = (start+end)/2;
//			to prevent overflow
			int mid = start + (end-start)/2;
			if(arr[mid] == x) return mid;
			else if(arr[mid] > x) {
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int [] arr = new int [] {1,3,4,6,11,23,44,50};
		System.out.println(binarySearch(arr, 1));
		System.out.println(binarySearch(arr, 44));
		System.out.println(binarySearch(arr, 50));
		System.out.println(binarySearch(arr, 0));
	}
}
