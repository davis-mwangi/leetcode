package Neetcode_450_Questions;

/*

https://leetcode.com/problems/merge-sorted-array/description/

*/
public class MergeSortedArray_Easy_LC88 {
    class Solution {

        /*
         * [1,2,3,0,0,0]
         * [2,5,6]
         * 
         * Time Complexity : O(m+n)
         * Space Complexity: O(1)
         */
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int k = (m + n) - 1;
            int i = m - 1; // nums1
            int j = n - 1; // nums2

            while (i >= 0 && j >= 0) {
                if (nums2[j] > nums1[i]) {
                    nums1[k] = nums2[j];
                    j--;
                } else {
                    nums1[k] = nums1[i];
                    i--;
                }
                k--;
            }

            // Some values maybe left if nums1 and nums2 are not equal
            while (i >= 0) {
                nums1[k] = nums1[i];
                i--;
                k--;
            }

            while (j >= 0) {
                nums1[k] = nums2[j];
                j--;
                k--;
            }

        }
    }
}
