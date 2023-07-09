package arrays_and_hashing;
import java.util.*;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 */
public class BestTimeToBuyAndSellStock {
    
    //Solution 1
    //Space Complexity: O(n)
    //Time Complexity: O(n)
    public int maxProfit(int[] prices) {
        Stack<Integer>stack = new Stack<>();
        int n =  prices.length;
        stack.add(prices[0]);
        int maxProfit = 0;
       
        for(int i =1; i < n; i++){
          if(prices[i] > stack.peek() ){
            maxProfit += ( prices[i] -  stack.peek() );   
          }
           stack.add(prices[i]);
        }
        return maxProfit;
    }

    //Space Complexity: O(1)
    //Time Complexity: O(n)
    public int maxProfit2(int[] prices) {

        int n =  prices.length;
        int maxProfit = 0;
       
        for(int i =1; i < n; i++){
          if(prices[i] > prices[i -1] ){
            maxProfit += ( prices[i] - prices[i-1] );   
          }
        }
        return maxProfit;
    }
    
}
