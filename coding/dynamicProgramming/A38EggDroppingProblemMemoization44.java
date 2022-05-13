package coding.dynamicProgramming;

import java.util.Arrays;

public class A38EggDroppingProblemMemoization44 {
	
	static int [][]t = new int[101][101];

	public static void main(String[] args) {
		int eggs = 2;
		int floors = 6;
		for(int []w : t) {
			Arrays.fill(w, -1);
		}
		System.out.println(solve(eggs, floors));
	}

	private static int solve(int eggs, int floors) {
		if(eggs == 1) return floors;
		if(floors==1 || floors==0) return floors;
		if(t[eggs][floors] != -1) return t[eggs][floors];
		int ans = Integer.MAX_VALUE;
		for(int k=1; k<floors+1; k++) {
			int temp = 1 + Math.max(solve(eggs-1, k-1), solve(eggs, floors-k));
			ans = Math.min(ans, temp);
		}
		return t[eggs][floors] = ans;
	}
}
