package two_pointers;

/**
 * (HARD)
 * https://leetcode.com/problems/trapping-rain-water/description/
 * 
 * Solution Guide: Code With Arisha : https://www.youtube.com/watch?v=Lrp9v-NQPXw
 *                 Neetode: https://www.youtube.com/watch?v=ZI2z5pq0TqA
 */
public class TrappingRainWallet {


    // [0,1,0,2,1,0,1,3,2,1,2,1]
    // trapped_water = min(left, right) - h[i]
    //create max height left & max  height right 
    // get min of left n right
    // then calculate the trapped water
    // sum trapped water
    
    // Time Complexity O(n) * 4 ~ O(4n) ~ O(n)
    //Space Complexity O(n) * 3 ~ O(3n) ~ O(n)
    public int trap(int[] height) {
        int n = height.length;
        int[] minLeft  = new int[n];
        int[] maxRight = new int[n];

        int left = 0;
        for(int i = 0; i < n; i++){
            minLeft[i] = left;
            left = Math.max(left, height[i]);
        }
        int right =0;
        for(int i = n-1; i >= 0; i--){
            maxRight[i] = right;
            right = Math.max(height[i], right);
        }

        //Min of right and left
        int [] min = new int[n];
        for(int i =0; i< n; i++){
            min[i] = Math.min(minLeft[i], maxRight[i]);
        }
        //get trapped water
        int sum = 0;
        for(int i =0; i < n; i++){
           if( (min[i] - height[i]) >= 0){
            sum += (min[i] - height[i]);
           }
        }
        return sum;
    }

    // Time complexity: O(n)
    // Space Complexity: O(1)
    public int trap2(int[] height) {
        int n = height.length;
        int l = 0;
        int r =  n -1;

        int maxLeft = height[l];
        int maxRight = height[r];

        int res = 0;

        while(l < r ){
            if(maxLeft < maxRight){//move left pointer
                l += 1;
                maxLeft = Math.max(maxLeft, height[l]);
                res +=  maxLeft - height[l];

            }else{// move right pointer
                r -= 1;
                maxRight = Math.max(maxRight, height[r]);
                res += maxRight - height[r];
            }

        }
        return res;

    }
    
}
