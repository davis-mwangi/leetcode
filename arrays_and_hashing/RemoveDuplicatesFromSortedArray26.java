package arrays_and_hashing;
/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150

Algorithm:
  Maintain a left index to keep track of last updated swap
  We iterate i checking if the previous is not same, If we find that they are different
   then we update to the left index with current value to the right.
 */

public class RemoveDuplicatesFromSortedArray26 {
    class Solution {
        /*
         * [0,1,2,3,4,2,2,3,3,4]
         * ^
         * ^
         * 
         */
        public int removeDuplicates(int[] nums) {

            int left = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1]) {
                    nums[left] = nums[i];
                    left++;
                }
            }
            return left;
        }

    }

}
