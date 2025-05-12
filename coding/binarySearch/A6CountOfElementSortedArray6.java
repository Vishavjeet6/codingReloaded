package coding.binarySearch;


public class A6CountOfElementSortedArray6 {

	public static int binarySearchFirstOccurence(int [] arr, int x) {
		int start = 0;
		int end = arr.length-1;
		int res = -1;
		while(start <= end) {
			int mid = start + (end-start)/2;
			if(arr[mid] == x) {
				res = mid;
				end = mid-1;
			}
			else if(arr[mid] > x) {
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		return res;
	}
	
	public static int binarySearchLastOccurence(int [] arr, int x) {
		int start = 0;
		int end = arr.length-1;
		int res = -100;
		while(start <= end) {
			int mid = start + (end-start)/2;
			if(arr[mid] == x) {
				res = mid;
				start = mid+1;
			}
			else if(arr[mid] > x) {
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		return res;
	}
	
	private static void binarySearch(int[] arr, int x) {
		System.out.println(binarySearchLastOccurence(arr,x) - binarySearchFirstOccurence(arr,x) + 1);
	}
	
	
	
	public static void main(String[] args) {
		int [] arr = new int [] {2,4,10,10,10,18,20};
		binarySearch(arr, 10);
		binarySearch(arr, 4);
		binarySearch(arr, 11);
	}


}
