package Neetcode_450_Questions;

/*
https://leetcode.com/problems/valid-parentheses/description/
*/
import java.util.*;

public class ValidParenthenses_Easy_LC20 {
    class Solution {
        /*
         * "()[]{}"
         * 
         * Space Complexity: O(N)
         * Time Complexity : O(N)
         */
        public boolean isValid(String s) {
            Map<Character, Character> map = new HashMap<>();
            map.put(')', '(');
            map.put(']', '[');
            map.put('}', '{');

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    if (!stack.isEmpty() && stack.peek() == map.get(s.charAt(i))) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    stack.push(s.charAt(i));
                }

            }
            return stack.isEmpty();

        }
    }
}
