package leetcode;

import java.util.Arrays;

class Solution {
    public int maximumWealth(int[][] accounts) {
        int ans = Integer.MIN_VALUE;
        
        for(int[] account : accounts){
            ans = Math.max(ans, Arrays.stream(account).sum());
        }
        return ans;
    }
}

public class RichestCustomerWealth1672 {

}
