package Neetcode_450_Questions;
/*
https://leetcode.com/problems/remove-element/description/

*/

public class RemoveElement_Easy_LC27 {
    class Solution {
        /*
        [3,2,2,3], val = 3
        Output : [2,2,_,_]
        
        1. Move numbers equal to val at the end
        2. Count numbers not equal to val
    
        */
        public int removeElement(int[] nums, int val) {
            int n = nums.length;
    
            //Edge cases
            if(n == 0){
                return 0;
            }
            if(n == 1){
                if(nums[0] == val) return 0;
                if(nums[0] != val) return 1;
            }
            int l = 0;
            int r = n - 1;
            while(l <= r){
                if(nums[l] == val && nums[r] != val){
                    int temp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = temp;
                    r--;
                    l++;
                }else if(nums[l]== nums[r] && nums[l] == val){
                    r--;
                }else {
                    l++;
                }
            }
            int k = 0;
            for(int i = 0; i < n; i++){
                if(nums[i] == val){
                   break;
                }
                k++;
            }
           return k;
        }
    }
}
