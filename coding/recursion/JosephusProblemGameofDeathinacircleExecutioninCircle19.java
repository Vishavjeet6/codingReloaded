package coding.recursion;

import java.util.Vector;

public class JosephusProblemGameofDeathinacircleExecutioninCircle19 {
	
	public static void main(String[] args) {
		int n = 40;
		int k = 7;
		Vector<Integer> arr = new Vector<>();
		for(int i=0; i<n; i++) {
			arr.add(i+1);
		}
		
		System.out.println(recursive(arr, 0, k-1));
	}

	private static int recursive(Vector<Integer> arr, int i, int k) {
		if(arr.size() == 1) return arr.get(0);
		i = (i+k)%arr.size();
		arr.remove(i);
		return recursive(arr, i, k);
	}

}
