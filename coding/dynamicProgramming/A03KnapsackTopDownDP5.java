package coding.dynamicProgramming;

public class A03KnapsackTopDownDP5 {

	
	public static void main(String[] args) {
		int[] wt = new int [] {1,3,4,5};
		int[] val = new int[] {1,4,5,7};
		int w = 7;
		int n = wt.length;
		int t[][] = new int[n+1][w+1]; 
		System.out.println(knapSack(wt, val, w, t, n));
	}
	
	public static int knapSack(int[] wt, int[] val, int w, int[][]t, int n) {		
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=w; j++) {
				if(wt[i-1] <= j) {
					t[i][j] = Math.max(val[i-1] + t[i-1][j-wt[i-1]], t[i-1][j]);
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][w];
	}
}