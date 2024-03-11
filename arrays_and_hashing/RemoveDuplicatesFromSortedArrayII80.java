package arrays_and_hashing;

/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150
 * 
 */
public class RemoveDuplicatesFromSortedArrayII80 {
    class Solution {
        /*
         * [0,0,1,1,1,1,2,3,3]
         * ^
         * ^
         * 
         */
        public int removeDuplicates(int[] nums) {
            int left = 0;
            for (int i = 0; i < nums.length; i++) {
                int element = nums[i];
                if (left == 0 || left == 1 || nums[left - 2] != element) {
                    nums[left] = element;
                    left++;
                }
            }
            return left;
        }
    }
}
