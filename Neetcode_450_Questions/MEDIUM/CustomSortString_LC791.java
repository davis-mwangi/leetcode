package Neetcode_450_Questions.MEDIUM;

/*
Question : https://leetcode.com/problems/custom-sort-string/description/

*/
import java.util.*;

public class CustomSortString_LC791 {
    class Solution {
        /*
         * "cba", s = "abcd"
         * cbad
         * maintain count od each character of s
         * iterate thorugh order picking equivalent chacter and forming the string
         */
        public String customSortString(String order, String s) {
            Map<Character, Integer> sFreq = new HashMap<>();
            for (char ch : s.toCharArray()) {
                sFreq.put(ch, sFreq.getOrDefault(ch, 0) + 1);
            }

            StringBuilder res = new StringBuilder();
            for (char ch : order.toCharArray()) {
                if (sFreq.containsKey(ch)) {
                    int charCount = sFreq.get(ch);// 3
                    while (charCount > 0) {
                        res.append(ch);
                        charCount -= 1;
                    }
                    sFreq.remove(ch);
                }
            }
            if (sFreq.isEmpty()) {
                return res.toString();
            }

            for (char ch : sFreq.keySet()) {
                int charCount = sFreq.get(ch);
                while (charCount > 0) {
                    res.append(ch);
                    charCount -= 1;
                }
                // Avoid removing item while still iterating as it will through concurrency
                // exception
            }
            return res.toString();
        }
    }
}
