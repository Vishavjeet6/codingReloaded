package coding.dynamicProgramming;

public class A11RodCuttingProblem14 {
	
	public static void main(String[] args) {
		int length[] = new int[] {1,2,3,4,5,6,7,8};
		int price[] = new int[] {1,5,8,9,10,17,17,20};
		int n = 8;
//		maximize price but cutting road of length n;
		
		knapSack(length, price, n);
	}

	private static void knapSack(int[] length, int[] price, int n) {
		// TODO Auto-generated method stub
		int [][] t = new int[n+1][length.length+1];
		
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<length.length+1; j++) {
				if(length[i-1] <= j ) {
					t[i][j] = Math.max(price[i-1] + t[i][j-length[i-1]], t[i-1][j]);
				}else {
					t[i][j] = t[i-1][j]; 
				}
			}
		}
		System.out.println(t[n][length.length]);
		
		
		
	}

}
