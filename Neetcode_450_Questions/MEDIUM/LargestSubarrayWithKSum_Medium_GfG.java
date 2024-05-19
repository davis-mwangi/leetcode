package Neetcode_450_Questions.MEDIUM;

/*
https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1

Appraoch:

   Use a prefix sum technique
     -  Use a map to maintain a prefix sum to index
     {15,-2,2,-8,1,7,10,23}
     target(k) = 0;
     We need to get a prefixsum where  we check does there exist a sum  in map such that if we subtrack k 
     from current sum, if it exists then we get index and calculate the length
     between current index and index of when sum occurred.

     NB: we should not update the prefix sum  if find another sum later since we will have reduced the length
     E.g 15: 0, 15 :4, 15: 5 , if we happen to update prefix 15 will end up having 15:5 of which will have shoter 
     length from current index assuming index is 7

    
*/
import java.util.*;

public class LargestSubarrayWithKSum_Medium_GfG {
    class GfG {
        int maxLen(int arr[], int n) {
            // Your code here
            // Prefix Sum
            /*
             * 0. 1. 2 3. 4 5 6 7
             * {15, -2, 2, -8, 1, 7, 10, 23 } N =8
             * {15: 0, 13:1, 15:2, 7: 3, 8: 1,25:6, }
             * k = 0;
             * sum = 25
             * sum 15 - k = 0;
             * 5 - 0 = 5
             */

            Map<Integer, Integer> prefixSumIndexMap = new HashMap<>(); // { prefixSum : index }
            int maxLen = 0;
            int prefixSum = 0;
            int k = 0;
            for (int i = 0; i < n; i++) {
                prefixSum += arr[i];
                if (prefixSum == k) {
                    maxLen = Math.max(maxLen, i + 1);
                }
                int rem = prefixSum - k;

                if (prefixSumIndexMap.containsKey(prefixSum)) {
                    int len = i - prefixSumIndexMap.get(rem);
                    maxLen = Math.max(len, maxLen);
                } else {
                    prefixSumIndexMap.put(prefixSum, i);
                }

            }
            return maxLen;
        }
    }
}
