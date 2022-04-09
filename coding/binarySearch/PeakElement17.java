package coding.binarySearch;

public class PeakElement17 {
//	O(logn)
	public static int binarySearch(int [] arr) {
		int start = 0;
		int end = arr.length-1;
		while(start <= end) {
			int mid = start + (end-start)/2;
			if(mid > 0 && mid<arr.length-1) {
				if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) return mid;
				else if(arr[mid] < arr[mid+1]) {
					start = mid+1;
				}else {
					end = mid-1;
				}
			}else if(mid == 0) {
				if(arr[0] > arr[1]) return 0;
				return 1;
			}else if(mid == arr.length-1){
				if(arr[arr.length-1] > arr[arr.length-2]) return arr.length-1;
				return arr.length-2;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
//		unsorted array
		int [] arr = new int [] {5, 10, 20, 15};
		System.out.println(binarySearch(arr));
	}
}
