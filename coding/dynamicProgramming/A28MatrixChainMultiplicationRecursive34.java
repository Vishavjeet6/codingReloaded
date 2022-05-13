package coding.dynamicProgramming;

public class A28MatrixChainMultiplicationRecursive34 {
	
//	Given a sequence of matrices, find the most efficient way to multiply these matrices together. 
//	The problem is not actually to  perform the multiplications, but merely to decide in which order
//	to perform the multiplications. 
	
	public static void main(String[] args) {
		int arr[] = new int[] {40,20,30,10,30};
		int n = arr.length;
//		40*20, 20*30, 30*10, 10*30 matrix
		System.out.println(mcm(arr, 1, n-1));
	}

	public static int mcm(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		if(i>=j) return 0;
		int ans = Integer.MAX_VALUE;
//		k=i to k=j-1 for i to k and k+1 to j
//		k=i+1 to k=j for i to k-1 and k to j
		
		for(int k=i; k<=j-1; k++) {
			int tempAns = arr[i-1]*arr[k]*arr[j] + mcm(arr, i, k) + mcm(arr, k+1, j);
			ans = Math.min(ans, tempAns);
		}
		return ans;
	}
}
