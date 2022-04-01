package coding.binarySearch;

public class FindElementInSortedRotatedArray8 {

	public static int binarySearch(int [] arr, int x, int start, int end) {
		while(start <= end) {
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
	
	public static int minimumElementIndex(int [] arr) {
		int start = 0;
		int end = arr.length-1;
		int N = arr.length;
		while(start <= end) {
			int mid = start + (end-start)/2;
			int prev = (mid+N-1)%N;
			int next = (mid+1)%N;
			if(arr[mid]<=arr[prev] && arr[mid]<=arr[next]) return mid;
			else if(arr[mid]>=arr[end]) {
				start=mid+1;
			}else if(arr[mid]>=arr[start]) {
				end=mid-1;
			}
		}
		return 0;
	}
	
	
	
	public static void main(String[] args) {
		int [] arr = new int [] {10, 11,12,15,18,2,5,6,8};
		int minElementIndex = minimumElementIndex(arr);
//		one of them will be answer
		System.out.println(binarySearch(arr, 6, 0, minElementIndex));
		System.out.println(binarySearch(arr, 6, minElementIndex+1, arr.length-1));
	}

}
