package coding.binarySearch;

public class A10FindFloorOfElementSortedArray10 {
	
	public static int binarySearch(int [] arr, int x) {
		int start = 0;
		int res=-1;
		int end = arr.length-1;
		while(start <= end) {
			int mid = start + (end-start)/2;
			if(arr[mid] == x) return mid;
			else if(arr[mid] > x) {
				end = mid-1;
			}else {
				res=mid;
				start = mid+1;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int [] arr = new int [] {5, 10, 20, 30, 40};
		System.out.println(binarySearch(arr, 5));
		System.out.println(binarySearch(arr, 20));
		System.out.println(binarySearch(arr, 25));
		System.out.println(binarySearch(arr, 35));
	}
}
