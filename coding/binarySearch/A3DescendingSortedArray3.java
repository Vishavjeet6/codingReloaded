package coding.binarySearch;

public class A3DescendingSortedArray3 {
	
	public static int binarySearch(int [] arr, int x) {
		int start = 0;
		int end = arr.length-1;
		while(start <= end) {
			int mid = start + (end-start)/2;
			if(arr[mid] == x) return mid;
			else if(arr[mid] < x) {
				end = mid-1;
			}else {
				start = mid+1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int [] arr = new int [] {50,44,23,11,6,4,3,1};
		System.out.println(binarySearch(arr, 1));
		System.out.println(binarySearch(arr, 44));
		System.out.println(binarySearch(arr, 50));
		System.out.println(binarySearch(arr, 0));
	}

}
