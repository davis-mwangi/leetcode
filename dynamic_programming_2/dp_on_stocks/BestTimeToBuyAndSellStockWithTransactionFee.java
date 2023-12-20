package dynamic_programming_2.dp_on_stocks;
/*
Leetcode : 

  Algorithm:
      A little twist , we add the transaction fee when selling since a complete transaction  has both buy and sell

      NB: We could as well add transaction fee on buy, that is we pay upfront

*/
public class BestTimeToBuyAndSellStockWithTransactionFee {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
             // Your code goes here.
                int n = prices.length;
                int[] prev = new int[2];
                int[] curr = new int[2];
    
                curr[0] = curr[1] = 0;
    
                for (int index = n - 1; index >= 0; index--) {
    
                    for (int buy = 0; buy <= 1; buy++) {
                        int profit = 0;
                       
                        if (buy == 1) {//Buy
                            profit = Math.max( -prices[index]  + prev[0], 0+ prev[1]);
    
                        } else {// Sell
                            profit = Math.max( prices[index] + prev[1] - fee , 0 + prev[0]);
                        }
    
                        curr[buy] = profit;
                    }
    
                    prev = curr;
                }
                return prev[1];
        }
    }
}
