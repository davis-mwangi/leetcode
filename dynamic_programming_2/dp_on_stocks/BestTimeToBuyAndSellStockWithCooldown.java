package dynamic_programming_2.dp_on_stocks;
/*
Leetcode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
Coding Ninjas: https://www.codingninjas.com/studio/problems/highway-billboards_3125969

Same as BestTimeToBuyAndSellStockII with a bit of twist to accomodate cool down,

Algorithm:
   When we sell since there is a cool down of 1 day we just skip the next data and move to index + 1 + 1
*/
import java.util.*;

public class BestTimeToBuyAndSellStockWithCooldown {
    //Memoized(Top-Down)
    class Solution {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int[][]dp = new int[n][2];
            fill(dp, -1);
            return dfs(0, 1, prices, dp);
            
        }
        private int  dfs(int i, int buy, int [] prices, int[][]dp){
            int coolDown = 1;
            if(i >= prices.length){
                return 0;
            }
    
            if(dp[i][buy] != -1){
                return dp[i][buy];
            }
    
            int profit = 0;
            if(buy == 1){
                profit = Math.max( 
                   -prices[i] + dfs(i + 1, 0, prices, dp),
                            0 + dfs(i + 1, 1, prices, dp)
                );
            }else{//Sell
                profit = Math.max(
                   prices[i] + dfs(i + 1 + coolDown, 1, prices, dp),
                           0 +  dfs(i +1, 0, prices, dp)
    
                );
            }
            return dp[i][buy] = profit;
        }
        private void fill(int[][] arr, int val){
            for(int [] a:  arr){
                Arrays.fill(a, val);
            }
        }
    }

    //Bottom-Up
    class Solution2 {
        public int maxProfit(int[] prices) {
            int n = prices.length;
            int coolDown = 1;
            int[][]dp = new int[n+1+coolDown][2];
    
            for(int i =  n - 1; i >=0; i--){
                for(int buy = 0; buy <=1; buy++){
                    int profit = 0;
                    if(buy == 1){
                        profit = Math.max( 
                        -prices[i] + dp[i + 1][0],
                                    0 + dp[i + 1][1]
                        );   
                    }else{//Sell
                        profit = Math.max(
                        prices[i] + dp[i + 1 + coolDown][1],
                                0 +  dp[i +1][0]
    
                        );
                    }
                    dp[i][buy]= profit;
                }
            }
            return dp[0][1];
            
        }
    }
}
