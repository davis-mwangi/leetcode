package Neetcode_450_Questions;

/*
https://leetcode.com/problems/baseball-game/description/
*/

import java.util.*;
public class BaseballGame_Easy_LC682 {
    class Solution {
        /*
         * stack [5,5, ]
         * 
         * Time Complexity : O(N)
         * Space Complexity : O(N)
         */
        public int calPoints(String[] operations) {
            Stack<Integer> stack = new Stack<>();
            int n = operations.length;

            for (int i = 0; i < n; i++) {
                String o = operations[i];

                if (o.equals("C")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (o.equals("D")) {
                    int prev = stack.peek();
                    int dble = prev * 2;
                    stack.push(dble);

                } else if (o.equals("+")) {
                    if (stack.size() >= 2) {
                        int prev1 = stack.pop();
                        int prev2 = stack.peek();

                        int sum = prev1 + prev2;
                        stack.push(prev1);
                        stack.push(sum);
                    }
                } else {
                    int x = Integer.parseInt(o);
                    stack.push(x);
                }

            }
            int sum = 0;
            while (!stack.isEmpty()) {
                sum += stack.pop();
            }
            return sum;
        }
    }
}
