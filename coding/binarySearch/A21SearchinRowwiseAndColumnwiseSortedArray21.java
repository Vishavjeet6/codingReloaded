package coding.binarySearch;

public class A21SearchinRowwiseAndColumnwiseSortedArray21 {
	public static String binarySearch(int [][] arr, int x) {
		int n =arr.length;
		int m=arr[0].length;
		int i =0;
		int j=m-1;
		while(i>=0 && i<n && j>=0 && j<m) {
			if(arr[i][j] == x) return (i + " " + j);
			else if(arr[i][j] > x) {
				j--;
			}else if(arr[i][j] < x) {
				i++;
			}
		}
		return "-1";
	}
	
	public static void main(String[] args) {	
		int [][] arr = new int [][] {
			{10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}};
    		System.out.println(binarySearch(arr, 29));
    		System.out.println(binarySearch(arr, 30));
    		System.out.println(binarySearch(arr, 50));
    		System.out.println(binarySearch(arr, 44));
	}
}
