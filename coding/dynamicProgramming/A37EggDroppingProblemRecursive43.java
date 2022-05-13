package coding.dynamicProgramming;

public class A37EggDroppingProblemRecursive43 {
	
	public static void main(String[] args) {
		int eggs = 3;
		int floors = 5;
		
		System.out.println(solve(eggs, floors));
	}

	private static int solve(int eggs, int floors) {
		if(eggs == 1) return floors;
		if(floors==1 || floors==0) return floors;
		int ans = Integer.MAX_VALUE;
		for(int k=1; k<floors+1; k++) {
			int temp = 1 + Math.max(solve(eggs-1, k-1), solve(eggs, floors-k));
			ans = Math.min(ans, temp);
		}
		return ans;
	}
}
