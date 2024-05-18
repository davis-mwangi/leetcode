package Neetcode_450_Questions.MEDIUM;

import java.util.*;

public class EncodeAndDecodeStrings_Medium_LC659 {
    public class Solution {

        /*
         * @param strs: a list of strings
         * 
         * @return: encodes a list of strings to a single string.
         * 
         * ["lint","code","love","you"]
         * 
         * 4#lint4#code4#love3#you
         * 
         * 
         */
        public static String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            for (String str : strs) {
                sb.append(str.length());
                sb.append("#");
                sb.append(str);
            }
            return sb.toString();
        }

        /*
         * @param str: A string
         * 
         * @return: decodes a single string to a list of strings
         */
        public static List<String> decode(String str) {
            // write your code here
            List<String> ans = new ArrayList<>();
            int i = 0;
            while (i < str.length()) {
                if (str.charAt(i) == '#') {
                    // Get the length of the String
                    int k = i - 1;
                    StringBuilder lenStr = new StringBuilder();
                    while (k >= 0 && Character.isDigit(str.charAt(k))) {
                        lenStr.insert(0, str.charAt(k));
                        k--;
                    }
                    int len = Integer.parseInt(lenStr.toString());
                    StringBuilder sb = new StringBuilder();
                    int j = i + 1;
                    while (len > 0) {
                        sb.append(str.charAt(j));
                        len -= 1;
                        j += 1;
                    }
                    ans.add(sb.toString());
                    i = j - 1;
                }
                i++;
            }
            return ans;
        }
    }
}
