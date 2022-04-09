package coding.binarySearch;

public class SearchAnElementinBitonicArray19 {
	
	public static int ascbinarySearch(int [] arr, int x, int start, int end) {
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
	
	public static int dscbinarySearch(int [] arr, int x, int start, int end) {
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
		int [] arr = new int [] {1,3,8,12,4,2};
		int peak = PeakElement17.binarySearch(arr);
		System.out.println("asc " + ascbinarySearch(arr, 1, 0, peak) + " ,dsc " + dscbinarySearch(arr, 1, peak+1, arr.length-1));
		System.out.println("asc " + ascbinarySearch(arr, 12, 0, peak) + " ,dsc " + dscbinarySearch(arr, 12, peak+1, arr.length-1));
		System.out.println("asc " + ascbinarySearch(arr, 4, 0, peak) + " ,dsc " + dscbinarySearch(arr, 4, peak+1, arr.length-1));
		System.out.println("asc " + ascbinarySearch(arr, 6, 0, peak) + " ,dsc " + dscbinarySearch(arr, 6, peak+1, arr.length-1));

	}
}
