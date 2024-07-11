package Neetcode_450_Questions;

/*
You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are within the inclusive range.

A number x is considered missing if x is in the range [lower, upper] and x is not in nums.

Return the shortest sorted list of ranges that exactly covers all the missing numbers. That is, no element of nums is included in any of the ranges, and each missing number is covered by one of the ranges.

 

 

Example 1:

Input: nums = [0,1,3,50,75], lower = 0, upper = 99
Output: [[2,2],[4,49],[51,74],[76,99]]
Explanation: The ranges are:
[2,2]
[4,49]
[51,74]
[76,99]
Example 2:

Input: nums = [-1], lower = -1, upper = -1
Output: []
Explanation: There are no missing ranges since there are no missing numbers.
 

Constraints:

-109 <= lower <= upper <= 109
0 <= nums.length <= 100
lower <= nums[i] <= upper
All the values of nums are unique.


Solution:

As the input array nums is sorted ascending and all the elements in it are within the given [lower, upper] bounds, we can simply check consecutive elements to see if they differ by one or not. If they don't, then we have found a missing range.

When nums[i + 1] - nums[i] <= 1, we know that there are no missing elements between nums[i + 1] and nums[i].
When nums[i + 1] - nums[i] > 1, we know that the range of elements, [nums[i] + 1, nums[i + 1] - 1], is missing.
However, there are two edge cases:

If we don't start with lower as the first element of the array, we will need to include [lower, num[0] - 1] as a missing range as well.
Similarly, if we don't end with upper as the last element of the array, we will need to include [nums[n - 1] + 1, upper] as a missing range as well where n is the length of nums.

*/
import java.util.*;

public class MissingRanges_Easy_LC163 {
    class Solution {
        /*
         * Input: nums = [1,3,50,75], lower = 0, upper = 99
         * Output: [[2,2],[4,49],[51,74],[76,99]]
         * Explanation: The ranges are:
         * [2,2]
         * [4,49]
         * [51,74]
         * [76,99]
         * 
         * 
         */
        public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
            int n = nums.length;
            List<List<Integer>> missingRanges = new ArrayList<>();
            // If nums is empty then the missing is between lower and upper bound
            if (n == 0) {
                missingRanges.add(Arrays.asList(lower, upper));
                return missingRanges;
            }

            // Check for any missing range between the lower bound and nums[0]
            if (lower < nums[0]) {
                missingRanges.add(Arrays.asList(lower, nums[0] - 1));
            }

            // Check for Missing numbers between successive elements of nums
            for (int i = 0; i < n - 1; i++) {
                if (nums[i + 1] - nums[i] <= 1) { // No Missing range
                    continue;
                }
                missingRanges.add(Arrays.asList(nums[i] + 1, nums[i + 1] - 1));
            }

            // Check for any missing numbers between the last element and upper bound
            if (upper > nums[n - 1]) {
                missingRanges.add(Arrays.asList(nums[n - 1] + 1, upper));
            }
            return missingRanges;

        }
    }
}
