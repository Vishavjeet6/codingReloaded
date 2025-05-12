package coding.binarySearch;

public class A7NumberOfTimesSortedArrayIsRotated7 {
	public static int binarySearch(int [] arr) {

		int start = 0;
		int end = arr.length-1;
		int N = arr.length;
		while(start <= end) {
			int mid = start + (end-start)/2;
			int prev = (mid+N-1)%N;
			int next = (mid+1)%N;
//			System.out.println(start + " " +mid +" " +end);
			if(arr[mid]<=arr[prev] && arr[mid]<=arr[next]) return N - mid;
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
		System.out.println(binarySearch(arr));
	}
}
