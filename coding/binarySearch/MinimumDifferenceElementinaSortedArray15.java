package coding.binarySearch;

public class MinimumDifferenceElementinaSortedArray15 {
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
		int [] arr = new int [] {4,6,10};
		int x = FindCeilOfElementSortedArray11.binarySearch(arr, 7);
		int y = FindFloorOfElementSortedArray10.binarySearch(arr, 7);
		System.out.println(Math.min(arr[x]-7, 7-arr[y]));
	}
}
