package Top_Leetcode_150.Arrays_and_Strings;
/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150

*/
public class RemoveDuplicatesFromSortedArray_LC26 {
    class Solution {
        /*
    [0,0,0,0,1,1,1,2,2,3,3,4]
     ^ 
       ^
    
    
        */
        public int removeDuplicates(int[] nums) {
            int left = 1;
            for(int i = 1; i < nums.length; i++){
                if(nums[i - 1] != nums[i]){
                    //We swap value to the left with the new found value
                    nums[left] = nums[i];
                    left++;
                }
            }
            return left;
        }
    }
}
