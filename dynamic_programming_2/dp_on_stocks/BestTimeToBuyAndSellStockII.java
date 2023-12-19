package dynamic_programming_2.dp_on_stocks;

/*
https://www.codingninjas.com/studio/problems/selling-stock_630282

We consider two cases, either to buy or sell stock snd since we can buy and sell as many times as possible
Algorithm: 
   We express or function in terms of index and buy , where buy = 1, we can buy and buy=0, we cannot buy

   Explore all  possible ways:
      if we can buy then we have two options:
                                either we consider profit in which its -ve or we dont but at all and move on
      if we cannot but we two options:
             either we  sell and get the profit or we move on and wait another day to sell
   Base case
      If run out of bounds, the max profit we can get is zero.                                    


*/
import java.util.*;
import java.math.BigInteger;

public class BestTimeToBuyAndSellStockII {

    // Recursive Solution
    // TC: O(2 ^ n)
    // SC: O(n) Auxiliary stack space
    public class Solution {
        public static long getMaximumProfit(int n, long[] values) {
            // Your code goes here.
            return dfs(0, true, n, values);
        }

        private static long dfs(int index, boolean buy, int n, long[] values) {
            // Base Case
            if (index == n) {
                return 0;
            }

            long profit = 0L;
            if (buy) {
                profit = Math.max(-values[index] + dfs(index + 1, false, n, values),
                        0L + dfs(index + 1, true, n, values));
            } else {// Sell
                profit = Math.max(values[index] + dfs(index + 1, true, n, values),
                        0L + dfs(index + 1, false, n, values));
            }
            return profit;
        }
    }

    // Botton-Up(Tabulation)
    // SC: O(N * M)
    // TC: O(N * M)
    public class Solution2 {
        public static long getMaximumProfit(int n, long[] values) {
            // Your code goes here.
            long[][] dp = new long[n + 1][2];
            dp[n][0] = dp[n][1] = 0;

            for (int index = n - 1; index >= 0; index--) {

                for (int buy = 0; buy <= 1; buy++) {
                    long profit = 0L;
                    if (buy == 1) {
                        BigInteger buy1 = BigInteger.valueOf(-values[index]).add(BigInteger.valueOf(dp[index + 1][0]));

                        profit = Math.max(buy1.longValue(), 0L + dp[index + 1][1]);
                    } else {// Sell
                        BigInteger sell = BigInteger.valueOf(values[index]).add(BigInteger.valueOf(dp[index + 1][1]));
                        profit = Math.max(sell.longValue(), 0L + dp[index + 1][0]);
                    }

                    dp[index][buy] = profit;
                }
            }
            return dp[0][1];
        }
    }

    // Space Optimized Solution
    // TC: O(N * M)
    // SC: : O(1)
    public class Solution3 {
        public static long getMaximumProfit(int n, long[] values) {
            // Your code goes here.
            long[] prev = new long[2];
            long[] curr = new long[2];

            curr[0] = curr[1] = 0;

            for (int index = n - 1; index >= 0; index--) {

                for (int buy = 0; buy <= 1; buy++) {
                    long profit = 0L;
                    if (buy == 1) {
                        BigInteger buy1 = BigInteger.valueOf(-values[index]).add(BigInteger.valueOf(prev[0]));

                        profit = Math.max(buy1.longValue(), 0L + prev[1]);
                    } else {// Sell
                        BigInteger sell = BigInteger.valueOf(values[index]).add(BigInteger.valueOf(prev[1]));
                        profit = Math.max(sell.longValue(), 0L + prev[0]);
                    }

                    curr[buy] = profit;
                }
                prev = curr;
            }
            return prev[1];
        }
    }
}
