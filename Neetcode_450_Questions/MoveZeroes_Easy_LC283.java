package Neetcode_450_Questions;

/*
https://leetcode.com/problems/move-zeroes/description/


*/
public class MoveZeroes_Easy_LC283 {
    class Solution {
        /*
         * [0,1,0,3,12] => [1,3,12,0,0] => []
         * ^ ^ ^
         * ^
         * 
         * [1, 0, 1]
         * l r
         * 
         * Time Complexity : O(N)
         * Space Complexity : O(1)
         */
        public void moveZeroes(int[] nums) {
            int l = 0;
            int r = 0;
            int n = nums.length;
            while (r < n) {
                if (nums[l] == 0 && nums[r] != 0) {
                    int temp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = temp;
                    l++;
                    r++;
                } else if (nums[l] != 0 && nums[r] == 0) {
                    l++;
                } else {
                    r++;
                }
            }
        }
    }
}
