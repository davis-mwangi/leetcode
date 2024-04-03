package Neetcode_450_Questions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * https://leetcode.com/problems/find-the-difference-of-two-arrays/description/
 */
public class FindTheDifferenceOfTwoArrays_Easy_LC2215 {
    // Time Complexity : O(N)
    // Space Complexity : O(N)
    class Solution {
        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
            // Add items in aset
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();
            for (int num : nums1) {
                set1.add(num);
            }
            for (int num : nums2) {
                set2.add(num);
            }

            List<List<Integer>> res = new ArrayList<>();
            for (int num : nums1) {
                if (set2.contains(num)) {
                    set1.remove(num);
                    set2.remove(num);
                }
            }
            for (int num : nums2) {
                if (set1.contains(num)) {
                    set2.remove(num);
                    set1.remove(num);
                }
            }
            res.add(new ArrayList<>(set1));
            res.add(new ArrayList<>(set2));

            return res;
        }
    }
}
