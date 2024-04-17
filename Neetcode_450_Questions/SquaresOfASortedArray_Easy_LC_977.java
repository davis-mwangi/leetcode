package Neetcode_450_Questions;

/**
 * SquaresOfASortedArray_Easy_LC_977
 */
import java.util.*;
public class SquaresOfASortedArray_Easy_LC_977 {

    class Solution1 {
        /*
        Calculare Squares
        Sort the array 
    
        Time Complexity : O( N log N) + O(n)
        Space Complexity : O(1)
        */
        public int[] sortedSquares(int[] nums) {
            int n =  nums.length;
            //Calculate squares
            for(int i = 0; i < n; i++){
                nums[i] = (nums[i] * nums[i]);
            }
            Arrays.sort(nums);
            return nums;
        }
    }

    class Solution {
        /*
        Key observations :  Sorted
        [-4,-1,0,3,10]
               ^
        Since after squaring, the negatives if will become +ve,
        The far left will be big and far right, then we can use two pointers and
        populate from right to left by comparing right and left after squaring
        
        Time Complexity : O(N)
        Space Complexity : O(1)
        */
        public int[] sortedSquares(int[] nums) {
           int n = nums.length;
           int l = 0; 
           int r = n -1;
           int[] ans = new int[n];
           int k = n -1;
           while(l <= r){
              if(Math.abs(nums[l]) > Math.abs(nums[r])){
                 ans[k] = (nums[l] * nums[l]);
                 l++;
              }else {
                 ans[k] = ( nums[r] *  nums[r] );
                 r--;
              }
              k--;
           }
           return ans;
        }
    }

}
