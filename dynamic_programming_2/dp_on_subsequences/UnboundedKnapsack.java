package dynamic_programming_2.dp_on_subsequences;
/*
1) Express int terms of indexes, (weight, index)
2) explore the stuffs (Take /dont take)
   - if the weight is infinite, we remain in the same position till we exxhaust the weight
   - On base case if we remaining with one only one option, we pick how many times the weight can match the rem weight
    E.g w = 10  and w[0] = 3 and profit[0] == 4, we can take (10 / 3) = 3 * 4 = 12
 3) We pick the max of take and dont take   


*/
import java.util.*;
public class UnboundedKnapsack {
    
    //Memoized Top-down
    //SC: O(W * n) + O(w)Auxiliary stack space
    //TC: O(W * n)
    public class Solution1 {
        public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
            // Write your code here.
            int[][]dp = new int[n][w + 1];
            fill(dp, -1);
            return dfs(n -1, w, profit, weight, dp);
        }
        private static int  dfs(int i, int w, int[]profit, int [] weight, int[][]dp){
          //Base Case
          if(i == 0){
              return (w/ weight[i]) * profit[i];
          }
          if(dp[i][w] != -1){
              return dp[i][w];
          }
          int dontTake = 0 + dfs(i -1, w, profit, weight, dp);
          int take = 0;
          if(weight[i] <= w){
              take =  profit[i] + dfs(i, w - weight[i], profit, weight, dp);
          }
          return dp[i][w] = Math.max(dontTake, take);
        }
        private static void fill(int[][]arr, int val){
            for(int[] a: arr){
                Arrays.fill(a, val);
            }
        }
    }

    //Tabulation (Bottom-up)
    //SC: O(W * n)
    //TC: O(W * n) + O(W)
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        // Write your code here.
        int[][]dp = new int[n][w + 1];
        for(int wt = 0; wt <= w; wt++){
            dp[0][wt] = (wt / weight[0])* profit[0];
        }
        for(int  i = 1; i < n; i++){
            for(int wt = 1; wt <= w; wt++){
                int dontTake = 0 + dp[i -1][wt];
                int take = 0;
                if(weight[i] <= wt){
                    take =  profit[i] + dp[i][wt - weight[i]];
                }
                dp[i][wt] = Math.max(dontTake, take);
            }
        }
        return dp[n-1][w];
    }
}
