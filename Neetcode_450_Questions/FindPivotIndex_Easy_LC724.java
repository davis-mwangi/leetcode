package Neetcode_450_Questions;
/*

https://leetcode.com/problems/find-pivot-index/description/
*/ 
public class FindPivotIndex_Easy_LC724 {

    //Time Complexity : O(n^2)
    //Space Complexity : O(1)
    class Solution {
        public int pivotIndex(int[] nums) {
            int n = nums.length;
            
            for (int i = 0; i < n; i++){
                int right = 0;
                
                int r = i + 1;
                while(r < n){
                    right += nums[r];  
                    r++;   
                }
                int left = 0;
                int l = i -1;
                while(l >= 0){
                    left += nums[l];
                    l--;
                }
    
                if(left == right){
                    return i;
                }
            }
            return -1;
        }
    }

    class Solution2 {
        /*
          [1,7,3,6,5,6]
           ^
        Time Complexity : O(n)
        Space Complexity : O(1)
        */
        public int pivotIndex(int[] nums) {
            int n = nums.length;
            int sum =  sum(nums);
            int l = 0;
            int r = sum;
            for(int i = 0; i < n; i++){
               int left = (i == 0)  ? 0: (l += nums[i-1]);
               int right =  (i == n-1) ? 0 : (r -= nums[i]);
    
               if(left == right){
                  return i;
               } 
            }
            return -1;
    
        }
        private int sum(int [] nums){
           int sum =  0;
           for(int num :  nums){
              sum += num;
           }
           return sum;
        }
    }
}
