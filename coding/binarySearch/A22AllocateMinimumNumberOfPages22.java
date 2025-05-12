package coding.binarySearch;

public class A22AllocateMinimumNumberOfPages22 {

	public static int binarySearch(int [] arr, int students) {
		int res = -1;
		if(students>arr.length) return -1;
		int start =  0;
		int end = 0;
		for(int x: arr) {
			end += x;
			start = Math.max(start, x);
		}
		while(start <= end) {
			int mid = start + (end-start)/2;
			if(isValid(arr, students, mid)) {
				res = mid;
				end = mid-1;
			}
			else {
				start = mid+1;
			}
		}
		return res;
	}
	
	private static boolean isValid(int[] arr, int students, int mid) {
		int n = arr.length;
		int student=1;
		int sum=0;
		for(int i=0; i<n; i++){
			if(sum+arr[i] > mid) {
				sum=arr[i];
				student++;
			}else {
				sum += arr[i];
			}
			if(student > students) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int [] arr = new int [] {10,20,30,40};
		System.out.println(binarySearch(arr, 2));
		int [] arr2 = new int [] {12, 34, 67, 90};
		System.out.println(binarySearch(arr2, 2));
	}
}
