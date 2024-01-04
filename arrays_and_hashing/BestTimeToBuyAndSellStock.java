package arrays_and_hashing;
import java.util.*;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 * 
 * Solution 1 :
 *     Using stack, and comparing  the last item added is lesser than the current prices and calculate the profit and sum it up
 * 
 * Solutio 2: 
 *    Since we can buy and  sell as many times, but we can only sell if we have bought, and we cant buy before selling the current stock
 *     so we iterate through and compare if previous price was lesser than today, then we can sell and accumulate the profit
 * 
 * Solution 3: 
 *      Using dp, where  at a given day we can either buy or sell depending on whether we previously bought of sold
 *      So we maintain a flag to tell us whether to buy or sell
 *      In case we are eligible to buy , we have 2 options:
 *              either we buy  and reduce our profit and move on, OR
 *              decide not to buy anything and wait for the next day
 *          we take max of the 2  choices
 *      In case we are not eligible, the we can only sell, still we have 2 options:
 *              Either we sell and make profit  OR wait for the next day to sell
 *           we take max of the 2 cases
 * 
 *     At end we get accumulative profix
 *           
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
