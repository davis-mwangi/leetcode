package Neetcode_450_Questions.MEDIUM;

/*
https://leetcode.com/problems/subarray-sum-equals-k/description/

We use prefix sum technique ,and keep track of subsarrays that add up to k in a map 
such that if prefix sum (x) and k , then we check have had  sub-aarays before that add up to x- k
if yes the we add the count.

NB:  Also add (0,1) to map to cater for case where we dont have other values in map E.g [3]

*/
import java.util.*;

public class SubarraySumEqualsK_Medium_LC560 {
    class Solution {
        // Brute force
        // Time complexity : O(N^2)
        // Space Complexity : O(1)
        // public int subarraySum(int[] nums, int k) {
        // int count = 0;
        // for(int i = 0; i < nums.length; i++){
        // int sum = 0;
        // for (int j = i; j < nums.length; j++){
        // sum += nums[j];
        // if(sum == k){
        // count += 1;
        // }
        // }
        // }
        // return count;

        // }

        // Using prefix sum technique
        // Time complexity : O(N^2)
        // Space Complexity : O(1)
        // [1,2,3, -1, 1].
        // [1] [2]
        public int subarraySum(int[] nums, int k) {
            int count = 0;
            int prefixSum = 0;
            Map<Integer, Integer> prefixSumCountMap = new HashMap<>();// [prefixSum : count]
            // We add (0, 1) since if we have 3 as first item there is only one way we can
            // exclude subarray to get sum
            // sum = prefix - k
            prefixSumCountMap.put(0, 1);

            for (int i = 0; i < nums.length; i++) {
                prefixSum += nums[i];
                int remove = prefixSum - k;
                // We check how many subarrays that can have a prefix sum of diff
                count += prefixSumCountMap.getOrDefault(remove, 0);
                prefixSumCountMap.put(prefixSum, prefixSumCountMap.getOrDefault(prefixSum, 0) + 1);
            }
            return count;

        }
    }
}
