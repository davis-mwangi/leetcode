package Neetcode_450_Questions;
/*

https://leetcode.com/problems/remove-duplicates-from-sorted-array/

*/
public class RemoveDuplicatesFromSortedArray_Easy_LC26 {
    class Solution {
        /*
    [0,0,1,1,1,2,2,3,3,4]
     l
     r
        */
        public int removeDuplicates(int[] nums) {
            int n = nums.length;
            int l = 0;
            int r = 0;
            while(r < n ){
                
                if( r == 0 || nums[r] != nums[r-1]){
                   int temp = nums[r];
                   nums[l] = nums[r];
                   nums[r] = temp;
                   l++;
                }
                r++;
            }
            return l;
        }
    }
}
