package leetcode;

import java.util.*;

class StockSpanner {
    Stack<int[]> st;

    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int count=1;
        while(!st.isEmpty() && st.peek()[0]<=price) {
            count += st.pop()[1];
        }
        st.push(new int[]{price, count});
        return count;

    }
} 		

public class OnlineStockSpan901 {
	
	public static void main(String[] args) {
		StockSpanner stockSpanner = new StockSpanner();
		System.out.println(stockSpanner.next(100)); // return 1
		System.out.println(stockSpanner.next(80));  // return 1
		System.out.println(stockSpanner.next(60));  // return 1
		System.out.println(stockSpanner.next(70));  // return 2
		System.out.println(stockSpanner.next(60));  // return 1
		System.out.println(stockSpanner.next(75));  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
		System.out.println(stockSpanner.next(85));  // return 6
	}

}
