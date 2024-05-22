package Neetcode_450_Questions.MEDIUM;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/continuous-subarray-sum/
 */
public class ContinousSubarraySum_Medium_LC523 {
    class Solution {
        /*
         * [5,0,0,0]
         * {5: }
         */
        public boolean checkSubarraySum(int[] nums, int k) {
            Map<Integer, Integer> remIdxMap = new HashMap<>();
            remIdxMap.put(0, -1);
            int n = nums.length;
            int currSum = 0;
            for (int i = 0; i < n; i++) {
                currSum += nums[i];
                int rem = currSum % k;
                // Check if a remainder exists i.e a repition of the a multiple of k
                if (!remIdxMap.containsKey(rem)) {
                    remIdxMap.put(rem, i);
                } else if ((i - remIdxMap.get(rem)) >= 2) { // the last same reminder check the diff is greater than 1
                    return true;
                }
            }
            return false;

        }

    }
}
