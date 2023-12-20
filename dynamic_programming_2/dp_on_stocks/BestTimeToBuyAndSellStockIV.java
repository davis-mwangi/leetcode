package dynamic_programming_2.dp_on_stocks;
/*
Conding Ninjas: https://www.codingninjas.com/studio/problems/best-time-to-buy-and-sell-stock_1080698
Leetcode: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

this i variation of Best time to buy stock III, the value changes from 2 to any value.


*/
public class BestTimeToBuyAndSellStockIV {
    class Solution {
        public int maxProfit(int k, int[] prices) {
            int n = prices.length;
            int capping = k;
    
            int[][] after = new int[2][k+1];
            int[][] curr = new int[2][k+1];
    
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
