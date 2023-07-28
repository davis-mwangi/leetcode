package binary_search;

import java.util.Arrays;
import java.util.Collections;

/**
 * Leetcode: 1011
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 * 
 * YouTube: https://www.youtube.com/watch?v=ER_oLmdc-nw
 * 
 * Related: Koko eating bananas
 * 
 */
//Space Complexity: O()1
//Time Complexity: O(n * log m) where m is the diff between max value and sum of  all weights.
public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int days) {
        int left = max(weights);
        int right = sum(weights);

        int result = right;

        while(left <= right){
            int capacity = left + ((right - left) / 2);

            if(canFitDays(weights,capacity, days)){
                result = Math.min(result, capacity);
                right =  capacity - 1;
            }else{
                 left = capacity + 1;
            }
        }
        return result;
    }
    private int max(int [] arr){
        int max = Integer.MIN_VALUE;
        for(int num: arr){
             max = Math.max(max, num);
        }
        return max;
    }

    private int sum(int [] arr){
       int sum = 0;
       for(int num: arr){
           sum+= num;
       }
       return sum;
    }
    private boolean canFitDays(int[] weights, int capacity, int days){
        int ships  = 1;
        int currCap = capacity;
        for(int w: weights){

            //If no space on current ship, then we need to add a new ship
            //and reset back the capacity to the initial capacity
            if( (currCap - w) < 0){
                ships += 1;
                currCap = capacity;
            }
            currCap -= w;
        }
        return ships <= days;
    }

}
