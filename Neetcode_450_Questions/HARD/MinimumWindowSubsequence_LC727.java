package Neetcode_450_Questions.HARD;
/*
Given strings s1 and s2, return the minimum contiguous substring part of s1, so that s2 is a subsequence of the part.

If there is no such window in s1 that covers all characters in s2, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.

 

Example 1:

Input: s1 = "abcdebdde", s2 = "bde"
Output: "bcde"
Explanation: 
"bcde" is the answer because it occurs before "bdde" which has the same length.
"deb" is not a smaller window because the elements of s2 in the window must occur in order.
Example 2:

Input: s1 = "jmeqksfrsdcmsiwvaovztaqenprpvnbstl", s2 = "u"
Output: ""
 

Constraints:

1 <= s1.length <= 2 * 104
1 <= s2.length <= 100
s1 and s2 consist of lowercase English letters.

Question :  https://leetcode.com/problems/minimum-window-subsequence/

Solution Guide: https://leetcode.com/problems/minimum-window-subsequence/solutions/512645/easy-to-understand-sliding-window-2-pointer-find-then-improve/

*/

//SC: O(N) + O(N) ~O(N)
//TC : O(1)
public class MinimumWindowSubsequence_LC727 {
    class Solution {
        /*
         * 1. Find a subsequence in s1 that contains s2, and return the ending index in
         * s2
         * 2.Improve that subsquence by search backwards from right to left to find the
         * starting
         * index in s1
         */
        public String minWindow(String s1, String s2) {
            int i = 0; // Iterating pointer of s1
            int minLen = Integer.MAX_VALUE;
            String minWindow = "";

            while (i < s1.length()) {
                // Find the end-point of subsequence
                int end = findEndIdxOfSubsequence(i, s1, s2);
                if (end == -1) {
                    break;
                }
                // Improve start-point of subsequence
                int start = improveSubseq(end, s1, s2);

                // Track min length
                if ((end - start + 1) < minLen) {
                    minLen = (end - start + 1);
                    minWindow = s1.substring(start, end + 1);
                }
                i = start + 1;
            }
            return minWindow;

        }

        private int improveSubseq(int end, String s, String sub) {
            int j = sub.length() - 1;
            while (j >= 0) {
                if (s.charAt(end) == sub.charAt(j)) {
                    j--;
                }
                end--;
            }
            return end + 1;
        }

        private int findEndIdxOfSubsequence(int start, String s, String sub) {
            int j = 0;
            int i = start;
            while (i < s.length()) {
                if (s.charAt(i) == sub.charAt(j)) {
                    j++;
                    if (j == sub.length()) {
                        break;
                    }
                }
                i += 1;
            }
            // Ensure the last character of s2 was found before loop ended
            return j == sub.length() ? i : -1;
        }

    }
}
