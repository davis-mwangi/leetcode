package Neetcode_450_Questions;

/*
https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/

*/
public class FindIndexOfFirstOccurrenceInAString_Easy_LC28 {
    class Solution {
        /*
         * haystack = "sadbutsad"
         * needle = "sad"
         * 
         * Space Complexity : O(1)
         * Time Complexity : O(N)
         */
        public int strStr(String haystack, String needle) {

            int hLen = haystack.length();
            int nLen = needle.length();
            int i = 0;
            while (i < hLen) {

                if (haystack.charAt(i) == needle.charAt(0)) {
                    int j = 0;
                    int k = i;
                    while (j < nLen && k < hLen && haystack.charAt(k) == needle.charAt(j)) {
                        j += 1;
                        k += 1;
                    }
                    if (j >= nLen) {
                        return i;
                    }
                }
                i++;
            }
            return -1;
        }
    }
}
