package Neetcode_450_Questions;

/*
https://leetcode.com/problems/contains-duplicate/description/
*/
import java.util.*;

public class ContainsDuplicate_Easy_LC217 {
    class Solution {
        /*
         * [1,2,3,1]
         */
        // Solution 1 using a set or HashMap
        // Space Complexity : O(n)
        // Time Complexity : O(n)
        public boolean containsDuplicate1(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (set.contains(num)) {
                    return true;
                }
                set.add(num);
            }
            return false;
        }

        //Using sorting
        //Space complexity: O(1)
        //Time Complexity : O(n log n) + O(n) ~ O(n log n)
        public boolean containsDuplicate2(int[] nums) {
            int n = nums.length;

            if (n == 0 || n == 1) {
                return false;
            }

            Arrays.sort(nums);

            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] == nums[i]) {
                    return true;
                }
            }
            return false;
        }

    }
}
