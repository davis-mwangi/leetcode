package Neetcode_450_Questions;

/*

https://leetcode.com/problems/concatenation-of-array/description/

*/

public class ConcatenationOfArray_Easy_LC1929 {
    class Solution {
        /*
        [1,2,1]
        [0      n    ]
         
        Time Complexity : O(n)
        Space Complexity : O(2n) ~ O(n)
        */
        public int[] getConcatenation(int[] nums) {
            int n = nums.length;
            int [] ans = new int[2*n];
            int l = 0;
            int r = n;
            while(l < n){
                ans[l] = ans[r] = nums[l];
                l++;
                r++;
            }
            return ans;
        }
    }
}
