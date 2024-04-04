package Neetcode_450_Questions;

/*

https://leetcode.com/problems/valid-palindrome/description/

*/
public class ValidPalindrome_Easy_LC125 {
    class Solution {
        public boolean isPalindrome(String s) {
            int n = s.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);

                if (Character.isUpperCase(ch)) {
                    sb.append(Character.toLowerCase(ch));
                    continue;
                }
                if (Character.isWhitespace(ch)) {
                    continue;
                }
                if (Character.isLetter(ch) || Character.isDigit(ch)) {
                    sb.append(ch);
                } else {
                    continue;
                }

            }
            String str = sb.toString();

            int l = 0;
            int r = str.length() - 1;
            while (l <= r) {
                if (str.charAt(l) != str.charAt(r)) {
                    return false;
                }
                l++;
                r--;
            }
            return true;

        }

    }
}
