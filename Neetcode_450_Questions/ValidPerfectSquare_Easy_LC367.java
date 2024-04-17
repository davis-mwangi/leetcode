package Neetcode_450_Questions;
/*
 * https://leetcode.com/problems/valid-perfect-square/description/
 */
public class ValidPerfectSquare_Easy_LC367 {
    class Solution {
        /*
        1 ..8...16
    
        Binary Search Problem

        Time Complexity: O(log N)
        Space Complexity: O(1)
        */
        public boolean isPerfectSquare(int num) {
             long l = 1L; 
             long r = (long)num;
             while(l <= r){
                long mid = l + (r-l)/2;
                long sqr = mid * mid;
                if(sqr > num){
                    r = mid - 1;
                }else if(sqr < num){
                    l = mid + 1;
                }else{
                    return true;
                }
             }
             return false;
        }
    }
}
