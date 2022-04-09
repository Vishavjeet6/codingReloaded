package coding.binarySearch;

public class SearchingInANeralySortedArray9 {
	
	public static int binarySearch(int [] arr, int x) {
		int start = 0;
		int end = arr.length-1;
		while(start <= end) {
			int mid = start + (end-start)/2;
			if(arr[mid] == x) return mid;
			else if(mid-1>=start && arr[mid-1]==x) return mid-1;
			else if(mid+1<=end && arr[mid+1]==x) return mid+1;
			else if(arr[mid] > x) {
				end = mid-2;
			}else {
				start = mid+2;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
//		element at index i can be at i-1, i+1
		int [] arr = new int [] {5,10,30,20,40};
		System.out.println(binarySearch(arr, 10));
		System.out.println(binarySearch(arr, 20));
		System.out.println(binarySearch(arr, 30));
		System.out.println(binarySearch(arr, 6));
	}
}
