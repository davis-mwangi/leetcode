package arrays_and_hashing;

/*
https://leetcode.com/problems/remove-element/description/?envType=study-plan-v2&envId=top-interview-150

Algorithm: We iterate from right to  left ,
   we only swap if the value to left matches val and right is not val.
   If left and right value are equal just move left pointer since  right is its correct position.

   Time Complexity : O(n)
   Space Complexity : O(n)

*/
public class RemoveElement27 {
    class Solution {
        /*
         * [0,1,4,0,3,2,2,2]
         * ^ ^
         * [3,2,2,3], val = 3
         * ^ ^
         */
        public int removeElement(int[] nums, int val) {
            int r = nums.length - 1;
            int l = 0;

            while (l <= r) {

                if (nums[r] != val && nums[l] == val) {
                    // swap
                    int temp = nums[r];
                    nums[r] = nums[l];
                    nums[l] = temp;
                    r--;
                    l++;
                } else if (nums[r] == val && nums[l] == val) {
                    r--;
                } else {
                    l++;
                }

            }

            r = nums.length - 1;
            while (r >= 0) {
                if (nums[r] != val) {
                    return r + 1;
                }
                r--;
            }

            return 0;

        }
    }
}
