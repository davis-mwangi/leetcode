package Top_Leetcode_150.Arrays_and_Strings;
/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/

*/
public class RemoveDuplicatesFromSortedArrayII_LC80 {
    class Solution {
        //[0,0,1,1,1,1,2,3,3]
        public int removeDuplicates(int[] nums) {
            int left  = 0;
            int right = 0;
       
            int n = nums.length;
            while(right < n){
                if( left == 0 ||  //Ensures the first element is always inclused in the modified array
                    left == 1 ||  //Ensure the second element is always included in the modified array
                    nums[left -2] != nums[right]){ //Check if the current element is not name as the element 2 positions before current position
                                                   //This ensures that only 2 occurences of any element are included in the modified array
                        nums[left] = nums[right];
                        left++;                           
                    } 
                    right += 1;
            }
            //Return left (length of modified array with only duplicates)
            return left;
        }
    }
}
