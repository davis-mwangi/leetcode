package dynamic_programming_1;
/*
https://leetcode.com/problems/house-robber-ii/

Approach:

Since almost similar to house robber 1, the only difference is the  houses are cyclic,
An easier way is to consider the   first house  to n -1   and the reverse case,  from the end to the second house.

an edge case to consider if no houses, then the max is zero,
if the house is one the max is just that single house, nums[0]

*/
public class HouseRobberII {
    public int rob(int[] nums) {

        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int rob1 = 0;
        int rob2 = 0;

        for(int i = 0; i < nums.length -1; i++){
            int temp = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        int first = rob2;
        rob1 = 0;
        rob2 = 0;
        for(int i = nums.length -1; i >= 1; i--){
            int temp = Math.max(nums[i]+ rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        int second = rob2;
        return Math.max(first, second);
    }
}
