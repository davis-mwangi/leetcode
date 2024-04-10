package Neetcode_450_Questions;

/*

https://leetcode.com/problems/binary-search/description/

Time Complexity : O(log N)
Space Complexity : O(1)
*/
public class BinarySearch_Easy_LC704 {
    class Solution {
        public int search(int[] nums, int target) {
            int l = 0;
            int r = nums.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;

                if (nums[mid] == target) {
                    return mid;
                } else if (target > nums[mid]) {
                    l = mid + 1;
                } else if (target < nums[mid]) {
                    r = mid - 1;
                }
            }
            return -1;
        }
    }
}
