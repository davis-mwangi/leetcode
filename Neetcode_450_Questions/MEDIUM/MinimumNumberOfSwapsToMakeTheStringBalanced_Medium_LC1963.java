package Neetcode_450_Questions.MEDIUM;

/*

https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/description/

*/
import java.util.*;

public class MinimumNumberOfSwapsToMakeTheStringBalanced_Medium_LC1963 {
    class Solution {
        /*
         * "][][" n =
         * n / 2 = '[' open = -ve
         * n / 2 = ']'. closed +ve
         * 
         * "] ] ] [ [ ["
         * ^
         * stack => [[[
         * closing => 3+1 / 2
         * 
         */
        public int minSwaps(String s) {
            Stack<Character> stack = new Stack<>();
            int closingBrackets = 0;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '[') {
                    stack.push(ch);
                } else {
                    if (!stack.isEmpty() && ch == ']') {
                        stack.pop();
                    } else {
                        closingBrackets += 1;
                    }
                }
            }
            return (closingBrackets + 1) / 2;
        }
    }
}
