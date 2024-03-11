package arrays_and_hashing;

/*
https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150


Algorithm:
  Since nums1 has a space to place values from nums2
  We iterate from the end and start comparing values in nums1 and nums2
  Since we might exhaust values from one array, the we check if there are remaining values and add
  it to the nums1 array.

  Time Complexity: O(n)
  Space Complexity : O(1)

  

*/
public class MergeSortedArray88 {
    class Solution {
        /*
         * [1,2,3,0,0,0]
         * ^
         * [2,5,6]
         * ^
         * 
         */
        public void merge(int[] nums1, int m, int[] nums2, int n) {

            int i = m - 1;
            int j = n - 1;
            int k = nums1.length - 1;

            while (i >= 0 && j >= 0) {

                if (nums1[i] > nums2[j]) {
                    nums1[k] = nums1[i];
                    i--;
                } else {
                    nums1[k] = nums2[j];
                    j--;
                }
                k--;
            }

            // Case when nums1 if not exhausted and nums2 is exhaust
            while (i >= 0) {
                nums1[k] = nums1[i];
                k--;
                i--;
            }

            while (j >= 0) {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
    }
}
