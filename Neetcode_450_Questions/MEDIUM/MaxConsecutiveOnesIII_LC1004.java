package Neetcode_450_Questions.MEDIUM;
/*

https://leetcode.com/problems/max-consecutive-ones-iii/description/

Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

 

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

GUIDE:  https://www.youtube.com/watch?v=3E4JBHSLpYk

*/

public class MaxConsecutiveOnesIII_LC1004 {

    // TC : O(N) + O(N) ~ O(N)
    // SC : O(1)
    class Solution {
        /*
         * [1,1,1,0,0,0,1,1,1,1,0], k = 2
         * 
         * Sliding window
         * 
         * For each A[j], try to find the longest subarray.
         * If A[i] ~ A[j] has zeros <= K, we continue to increment j.
         * If A[i] ~ A[j] has zeros > K, we increment i (as well as j).
         */
        public int longestOnes(int[] nums, int k) {
            int l = 0;
            int r = 0;
            int n = nums.length;
            int zeros = 0;
            int maxLen = 0;
            while (r < n) {

                if (nums[r] == 0) {
                    zeros += 1;
                }

                while (zeros > k) {
                    if (nums[l] == 0) {
                        zeros -= 1;
                    }
                    l++;
                }

                maxLen = Math.max(maxLen, (r - l + 1));
                r++;
            }
            return maxLen;
        }

    }
}
