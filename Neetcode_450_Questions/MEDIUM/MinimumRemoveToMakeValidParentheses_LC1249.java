package Neetcode_450_Questions.MEDIUM;

/*
Question : https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/
Guide: 


Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
 

Constraints:

1 <= s.length <= 105
s[i] is either '(' , ')', or lowercase English letter.


*/
public class MinimumRemoveToMakeValidParentheses_LC1249 {
    class Solution {
        // TC: O(N)
        // SC : O(N)
        public String minRemoveToMakeValid(String s) {
            StringBuilder forward = new StringBuilder();
            int open = 0;
            int close = 0;

            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    forward.append(ch);
                    open += 1;

                } else if (ch == ')') {
                    // Take closing if less than open
                    if (close < open) {
                        forward.append(ch);
                        close += 1;
                    }
                } else {
                    forward.append(ch);
                }
            }
            if (open == close) {
                return forward.toString();
            }
            StringBuilder ans = new StringBuilder();
            // Move from end backwards
            for (int i = forward.length() - 1; i >= 0; i--) {
                char ch = forward.charAt(i);
                if (ch == '(' && open > close) {
                    // Ignore
                    open -= 1;
                    continue;
                }
                ans.append(ch);
            }
            // We reserve the final
            return ans.reverse().toString();
        }
    }
}
