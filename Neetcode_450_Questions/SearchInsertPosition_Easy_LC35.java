package Neetcode_450_Questions;

/*
 * https://leetcode.com/problems/search-insert-position/description/
 */
public class SearchInsertPosition_Easy_LC35 {
    class Solution {
        /*
         * [1,3,5,6] t=5
         * 0 1 2 3 ans = 2
         * 
         * [1,3,5,6] t= 2 [1,3]
         * 0 1 2 3
         * 
         * Time Complexity: O(log N)
         * Space Complexity : O(1)
         */
        public int searchInsert(int[] nums, int target) {
            int l = 0;
            int r = nums.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;

                if (nums[mid] == target) {
                    return mid;
                } else if (target > nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return l;
        }
    }
}
