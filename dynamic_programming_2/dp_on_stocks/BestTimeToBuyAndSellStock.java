package dynamic_programming_2.dp_on_stocks;
/*
https://www.codingninjas.com/studio/problems/stocks-are-profitable_893405?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTabValue=PROBLEM


*/
import java.util.*;

public class BestTimeToBuyAndSellStock {

    public class Solution{
        public static int maximumProfit(ArrayList<Integer> prices){
            // Write your code here.
            if(prices.isEmpty()){
                return 0;
            }
            int maxProfit = 0;
            int min = prices.get(0);
            for(int i = 1; i < prices.size(); i++){
                int profit =  prices.get(i) - min;
                maxProfit = Math.max(profit, maxProfit);
                min = Math.min(prices.get(i), min);
            }
            return maxProfit;
        }
    }
}
