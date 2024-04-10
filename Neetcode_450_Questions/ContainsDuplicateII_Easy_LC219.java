package Neetcode_450_Questions;

/*
https://leetcode.com/problems/contains-duplicate-ii/description/

*/
import java.util.*;

public class ContainsDuplicateII_Easy_LC219 {
    class Solution {
        /*
         * [1,2,3,1], k = 3
         * l
         * r
         * set to check duplicates,
         * we use sliding window
         */
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            int l = 0;
            int r = 0;
            int n = nums.length;
            Set<Integer> set = new HashSet<>();
            while (r < n) {
                // Check if r and left are within k difference, else remove items to the left
                if (r - l > k) {
                    set.remove(nums[l]);
                    l++;
                }
                if (set.contains(nums[r])) {
                    return true;
                }
                set.add(nums[r]);
                r++;

            }
            return false;
        }
    }
}
