package Neetcode_450_Questions.MEDIUM;

/*

https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

*/

import java.util.*;

public class FindAllAnagramsInAString_Medium_LC438 {
    class Solution {
        /*
         * 
         * return first index of all anagram
         * p [a.b.c] 25 chars
         * s = "cbaebabacd"
         * [cba]
         * 
         * Time Complexity: O(len(p)) + O(N)
         * Space Complexity : O(26) ~ O(1)
         */
        public List<Integer> findAnagrams(String s, String p) {

            char[] pHash = new char[26];
            char[] sHash = new char[26];

            int right = 0;
            int left = 0;

            for (int i = 0; i < p.length(); i++) {
                pHash[p.charAt(i) - 'a']++;
                sHash[s.charAt(i) - 'a']++;
                right++;
            }
            List<Integer> ans = new ArrayList<>();
            while (right <= s.length()) {
                // Compare if anagrams

                if (Arrays.equals(pHash, sHash)) {
                    ans.add(left);
                }
                if (right == s.length()) {
                    return ans;
                }
                sHash[s.charAt(left) - 'a']--;
                sHash[s.charAt(right) - 'a']++;

                right++;
                left++;
            }
            return ans;
        }
    }
}
