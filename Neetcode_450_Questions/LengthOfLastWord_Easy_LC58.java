package Neetcode_450_Questions;
/*
https://leetcode.com/problems/length-of-last-word/description/

*/
public class LengthOfLastWord_Easy_LC58 {
    class Solution {
        /*
        "   fly me   to   the moon  "
        "Hello World"
               ^
        Time Complexity : O(N)
        Space Complexity : O(1)       
        */
        public int lengthOfLastWord(String s) {
            int n = s.length();
            int i = n - 1;
            int len = 0;
            while(i >= 0){
                while(i>=0 && !Character.isWhitespace(s.charAt(i))){
                    len++;
                    i--;
                }
                if(len > 0){
                    return len;
                }
                i--;
    
            }
            return -1;  
        }
    }
}
