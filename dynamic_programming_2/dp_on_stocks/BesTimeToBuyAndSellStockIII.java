package dynamic_programming_2.dp_on_stocks;
/*

Coding Ninjas:  https://www.codingninjas.com/studio/problems/buy-and-sell-stock_1071012
Leetcode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/


*/
import java.util.*;

public class BesTimeToBuyAndSellStockIII {
    //Memoized Top-Down Solotion
    class Solution1 {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int tranCap = 2;
    
            int[][][]dp = new int[n+1][3][3];
            fill(dp, -1);
    
            return dfs(0, 1, tranCap, prices, dp);
        }
    
        private int dfs(int index, int buy, int tranCap, int [] prices, int[][][]dp){
            //Base Case
            if(tranCap == 0){
                return 0;
            }
            if(index == prices.length){
                return 0;
            }
            if(dp[index][buy][tranCap] != -1){
                return dp[index][buy][tranCap];
            }
    
            int profit = 0;
            if(buy == 1){
                profit = Math.max(
                   -prices[index] + dfs(index + 1, 0, tranCap, prices, dp),
                    0 + dfs(index + 1, 1, tranCap, prices, dp)
                );
            }else{
                profit = Math.max(
                    prices[index] +  dfs(index +1, 1, tranCap -1, prices, dp),
                    0 +  dfs(index + 1, 0, tranCap, prices, dp)
                );
            }
            return dp[index][buy][tranCap] = profit;
        }
        private static void fill(int[][][] arr, int val){
            for(int[][] arr2: arr){
                for(int[]a : arr2){
                    Arrays.fill(a, val);
                }
            }
        }
    
    }

    //Tabulation(Bottom-Up)

    class Solution2 {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int capping = 2;
    
            int[][][]dp = new int[n+1][2][3];
            // for(int i = 0; i<= n; i++){
            //     for(int buy = 0; buy<= 1; buy++){
            //         dp[i][buy][0] = 0;
            //     }
            // }
            // for(int buy=0; buy<= 1; buy++){
            //     for (int tranCap=0; tranCap <= 2; tranCap++){
            //         dp[n][buy][tranCap]=0;
            //     }
            // }
    
            for(int index  = n -1; index >= 0; index--){
                for(int buy= 0; buy <= 1; buy++){
                    for(int tranCap = 1; tranCap <= capping; tranCap++){
    
                       int profit = 0;
                        if(buy == 1){
                            profit = Math.max(
                            -prices[index] + dp[index + 1][0][tranCap],
                                0 + dp[index + 1][1][tranCap]
                            );
                        }else{
                            profit = Math.max(
                                prices[index] +  dp[index +1][1][tranCap -1],
                                0 +  dp[index + 1][0][tranCap]
                            );
                        }
                        dp[index][buy][tranCap] = profit;
                    }
                }
            }
    
            return dp[0][1][capping];
        }
    
       
    }

    // Space Optimized
    // TC: O(N * 2 * 3)
    //SC: O(2 * 3)  ~ O(1)
    class Solution3 {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int capping = 2;
    
            int[][] after = new int[2][3];
            int[][] curr = new int[2][3];
    
            for(int index  = n -1; index >= 0; index--){
                for(int buy= 0; buy <= 1; buy++){
                    for(int tranCap = 1; tranCap <= capping; tranCap++){
    
                       int profit = 0;
                        if(buy == 1){
                            profit = Math.max(
                            -prices[index] + after[0][tranCap],
                                0  +  after[1][tranCap]
                            );
                        }else{
                            profit = Math.max(
                                prices[index] +  after[1][tranCap -1],
                                0 +  after[0][tranCap]
                            );
                        }
                        curr[buy][tranCap] = profit;
                    }
                }
                after = curr;
            }
    
            return after[1][capping];
        }
     
    }
}
