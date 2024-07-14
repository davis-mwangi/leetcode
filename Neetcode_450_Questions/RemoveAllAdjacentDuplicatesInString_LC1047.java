package Neetcode_450_Questions;

import java.util.Stack;

/*
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/
 * 
 * 
 */
import java.util.*;

public class RemoveAllAdjacentDuplicatesInString_LC1047 {
    class Solution {
        //TC: O(N) where N is the length of the string
        //SC: O(N- D) where D is the total length of all duplicates ~ O(N)
        public String removeDuplicates(String s) {
            Stack<Character> stack = new Stack<>();
            int n = s.length();
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (stack.isEmpty()) {
                    stack.add(ch);
                    continue;
                }
                if (stack.peek() == ch) {
                    stack.pop();
                } else {
                    stack.add(ch);
                }

            }

            StringBuilder ans = new StringBuilder();
            while (!stack.isEmpty()) {
                ans.append(stack.pop());
            }
            ans.reverse();
            return ans.toString();
        }
    }
}
