package Neetcode_450_Questions;

/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

*/
public class BestTimeToBuyAndSellStock_Easy_LC121 {

    class Solution {
        /*
         * 
         * [7,1,5,3,6,4]
         * ^
         * min = 7 , 1
         * maxProfit = 0, 4, 2, 5, 3
         * 
         * 
         * Time Complexity :  O(N)
         * Space Complexity: O(1)
         */
        public int maxProfit(int[] prices) {
            int min = prices[0];
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                int profit = prices[i] - min;
                maxProfit = Math.max(maxProfit, profit);

                // Update min
                min = Math.min(min, prices[i]);
            }
            return maxProfit;

        }
    }
}
