package dynamic_programming_1;

/*
 * https://leetcode.com/problems/decode-ways/
 * 
 * Approach:
 * [1, 4, 2, 3]
 * ways: 
 *     1, 4, 2, 3
 *     14, 2, 3
 *     14, 23
 *     1, 4, 23
 * We can use fibonacci concept,
 * At every given point we consider the current value if it is betwwen 1 and 9
 * Else we consider the previous value and increment count of ways if and only if the pair
 *  is greater or equal to 10 and is less or equal to 26.
 *  
 * We maintain a count to determine the count if we do consider 1 digit or the two digits if valid.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
import java.util.*;

public class DecodeWays {
    public int numDecodings(String s) {

        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int count1 = 1;
        int count2 = 1;

        for (int i = 1; i < s.length(); ++i) {
            int d = s.charAt(i) - '0';
            int dd = (s.charAt(i - 1) - '0') * 10 + d;

            int count = 0;
            if (d > 0) {
                count += count2;
            }
            if (dd >= 10 && dd <= 26) {
                count += count1;
            }
            count1 = count2;
            count2 = count;
        }
        return count2;
    }
}