package Neetcode_450_Questions.MEDIUM;

/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
*/
import java.util.*;

public class BestTimeToBuyAndSellStockII_Medium_LC122 {
    class Solution {
        /*
         * [7,1,5,3,6,4]
         * Each day you can either buy or sell stock
         * buy : two case : invest -ve profit or not buy
         * sell : two caes : sell(+ve) or not sell and wait for another day
         * buy = 0, (sell) buy = 1
         * 
         * Test
         * -7 | - 6, -7
         * 0 |
         */
        public int maxProfit(int[] prices) {
            int[][] dp = new int[prices.length][2];
            fill(dp, -1);
            return recurse(0, prices, 1, dp);
        }

        private int recurse(int i, int[] prices, int buy, int[][] dp) {

            // Base case(not profit can be made)
            if (i >= prices.length) {
                return 0;
            }

            if (dp[i][buy] != -1) {
                return dp[i][buy];
            }

            int profit = 0;
            if (buy == 1) { // buy
                profit += Math.max(-prices[i] + recurse(i + 1, prices, 0, dp),
                        0 + recurse(i + 1, prices, 1, dp));
            } else {// sell
                profit += Math.max(prices[i] + recurse(i + 1, prices, 1, dp),
                        0 + recurse(i + 1, prices, 0, dp));
            }
            return dp[i][buy] = profit;

        }

        private void fill(int[][] arr, int val) {
            for (int[] a : arr) {
                Arrays.fill(a, val);
            }
        }
    }
}
