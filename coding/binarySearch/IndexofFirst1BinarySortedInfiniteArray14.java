package coding.binarySearch;

public class IndexofFirst1BinarySortedInfiniteArray14 {
	public static int binarySearch(int [] arr, int x) {
		int start = 0;
		int end = 1;
		while(arr[end] != x) {
			start = end;
			end *= 2;
		}
		int res = -1;
		while(start <= end) {
			int mid = start + (end-start)/2;
			if(arr[mid] == x) {
				res=mid;
				end=mid-1;
			}else {
				start=mid+1;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
//		int [] arr = new int [] {0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1.................};
		int [] arr = new int [] {0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1};
		System.out.println(binarySearch(arr, 1));
	}
}
