package Neetcode_450_Questions.MEDIUM;
/*
https://leetcode.com/problems/product-of-array-except-self/description/
*/
public class ProductOfArrayExceptSelf_Medium_LC238 {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] prefix = new int [nums.length];
            int [] postfix = new int [nums.length];
            
            int pre = 1;
            for(int i = 0; i < nums.length; i++){
                pre = nums[i] * pre;
                prefix[i] = pre; 
            }
            
            int pos = 1;
            for(int i = nums.length - 1; i >= 0; i--){
                pos = pos * nums[i];
                postfix[i] = pos;
            }
     
            
            //Multiply pre and pos of a give position
            for(int i = 0; i < nums.length; i++){
                pre = (i - 1) >= 0 ? prefix[i - 1] : 1;
                pos = (i + 1) < nums.length ? postfix[i+1] : 1;
         
                nums[i] = pre * pos;
            }
            return nums;
            
        }
    }
}
