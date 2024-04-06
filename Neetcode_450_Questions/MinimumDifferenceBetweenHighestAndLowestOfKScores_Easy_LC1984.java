package Neetcode_450_Questions;

/*

https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/description/

*/
import java.util.*;
public class MinimumDifferenceBetweenHighestAndLowestOfKScores_Easy_LC1984 {
    class Solution {
        /*
         * sort array [1, 4, 7, 9]
         * <-2->
         */
        public int minimumDifference(int[] nums, int k) {
            Arrays.sort(nums);
            int l = 0;
            int r = k - 1;
            int min = Integer.MAX_VALUE;
            int n = nums.length;
            while (r < n) {
                int diff = nums[r] - nums[l];
                min = Math.min(min, diff);
                l++;
                r++;
            }
            return min;
        }
    }
}
