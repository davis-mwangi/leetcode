package Neetcode_450_Questions;
/*

https://leetcode.com/problems/reverse-string/description/

*/
public class ReverseString_Easy_LC344 {
    //Time Complexity :  O(N)
    //Space Complexity : O(1)
    class Solution {
        public void reverseString(char[] s) {
            int l = 0; 
            int r = s.length - 1;
    
            while(l <= r) {
                char temp = s[l];
                s[l] = s[r];
                s[r] =  temp;
    
                l++;
                r--;
            }
        }
    }
}
