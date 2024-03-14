package Neetcode_450_Questions;

/*

https://leetcode.com/problems/is-subsequence/description/

*/
public class IsSubsequence_Easy_LC392 {
    class Solution {
        /*
         * abc ahbgdc
         * ^ ^
         * 
         */
        public boolean isSubsequence(String s, String t) {
            if (s.length() == 0) {
                return true;
            }

            if (s.length() > t.length()) {
                return false;
            }
            int k = 0;
            int i = 0;
            while (i < t.length() && k < s.length()) {
                if (s.charAt(k) == t.charAt(i)) {
                    k++;
                }
                i++;
            }
            return k == s.length();
        }

    }
}
