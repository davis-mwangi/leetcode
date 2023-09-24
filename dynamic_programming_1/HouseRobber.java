package dynamic_programming_1;
/*
https://leetcode.com/problems/house-robber/

Approach:
[1, 2, 3, 1]
nums[i] = Max(nums[i] + rob1. rob2 )
Since we can cannot choose two adjacent houses, our approach at each given house,
We can either decide to rob the current house or take the previous value
So in this case we take the maximum of the , if were to rob the current house or the adjacent house

max( (nums[i] + rob1) , rob2)

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class HouseRobber {

    public int rob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;

        for(int i = 0; i < nums.length; i++){
            int temp = Math.max(nums[i] + rob1, rob2);
            rob1 =  rob2;
            rob2 =  temp;
        }
        return rob2;
    }

}