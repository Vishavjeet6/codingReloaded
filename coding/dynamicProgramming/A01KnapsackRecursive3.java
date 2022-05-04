package coding.dynamicProgramming;

public class A01KnapsackRecursive3 {
	
	public static void main(String[] args) {
		int[] wt = new int [] {1,3,4,5};
		int[] val = new int[] {1,4,5,7};
		int w = 7;
		
		recursive(wt, val, w);
	}

	private static void recursive(int[] wt, int[] val, int w) {
		System.out.println(knapSack(wt, val, w, wt.length));
	}
	
	public static int knapSack(int[] wt, int[] val, int w, int n) {
		if(n == 0 || w==0) return 0;
		if(wt[n-1] <= w) {
			return Math.max(val[n-1] + knapSack(wt, val, w-wt[n-1], n-1), knapSack(wt, val, w, n-1));
		}else {
			return knapSack(wt, val, w, n-1);	
		}
	}

}
