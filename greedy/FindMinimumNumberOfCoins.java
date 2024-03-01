package greedy;
/*
 * https://www.codingninjas.com/studio/problems/find-minimum-number-of-coins_975277
 */

import java.util.ArrayList;
import java.util.List;

public class FindMinimumNumberOfCoins {
    public class Solution {
    public static List<Integer> MinimumCoins(int n) {
        // Write your code here.
        int [] curr = new int[]{1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int N = curr.length;
        List<Integer>ans = new ArrayList<>();
        for(int i = N - 1; i >= 0; i--){
             //keep reducing provided value  is greater than denomination
             while(curr[i]  <= n){
                ans.add(curr[i]);
                n -= curr[i];
             }
        }
        return ans;
    }
}
}
