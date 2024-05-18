package Neetcode_450_Questions.MEDIUM;
/*
https://leetcode.com/problems/longest-consecutive-sequence/description/

*/
import java.util.*;

public class LongestConsecutiveSequence_Medium_LC128 {
    class Solution {
        /*
        )
         [100,4,200,1,3,2]
         ->  use Set
         1. sort 1, 2, 3,  4,100, 200  Time Complexity : n log n  + O(N) ~  O(N log N) 
               Space Complexity: O(1);
    
         2. TC: O(N) SC: O(N)
             set(100, 4,1,3,2)
            [100,4,200,1,3,2]
                 ^ 
          1, 2, 3, 4, => 4
    
          (100, 4,200,1,3,2  )


          Time Complexity:  O(N)
          Space Complexity : O(N)
        */
        public int longestConsecutive(int[] nums) {
            Set<Integer>set = new HashSet<>();
            int maxLen  = 0;
             //Add all nums in a set
            for(int num : nums){
                set.add(num);
            }
            for(int i = 0; i < nums.length; i++){
           
                //Check previous element exists
                if(!set.contains(nums[i] -1 )){
                    int len = 0;
                    int num = nums[i];
                    while(set.contains(num)){
                        len += 1;
                        num += 1;
                    }
                    maxLen = Math.max(maxLen, len);
                }
            }
            return maxLen;
        }
    }
}
