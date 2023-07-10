package arrays_and_hashing;

import java.util.*;

/**
 * https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/description/
 * 
 * Formulae result = (count + 1 ) / 2
 * 
 * 
 */
public class MinSwapsToBalanceString {

    //Space Complexity: O(n)
    //Time Complexity: O(n)
    //Helpful Videos: https://www.youtube.com/watch?v=17hUpx4GdEA
    public int minSwaps2(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() && ch == ']') {
                    stack.pop();
                } else {
                    count++;
                }
            }
        }
        return (count + 1) / 2;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    //Guide:  https://www.youtube.com/watch?v=3YDBT9ZrfaU
    public int minSwaps(String s) {
        int extraClosingbrackets = 0, max = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i)== ']') {
                extraClosingbrackets++;
                max = Math.max(extraClosingbrackets, max);
            }
            else 
                extraClosingbrackets--;
        }

        return (max + 1) / 2;
    }

}
