package coding.binarySearch;

public class NextAlphabeticElement12 {
	
	public static int binarySearch(int [] arr, int x) {
		int start = 0;
		int res=-1;
		int end = arr.length-1;
		while(start <= end) {
			int mid = start + (end-start)/2;
			if(arr[mid] == x) return mid+1;
			else if(arr[mid] > x) {
				end = mid-1;
				res=mid;
			}else {
				start = mid+1;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int [] arr = new int [] {'a','c','f','h'};
		System.out.println(binarySearch(arr, 'a'));
		System.out.println(binarySearch(arr, 'c'));
		System.out.println(binarySearch(arr, 'd'));
		System.out.println(binarySearch(arr, 'z'));
	}
}
