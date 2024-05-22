package Neetcode_450_Questions.MEDIUM;

public class StringToIntegerAtoi_Medium_LC8 {
    // Approach 1:
    class Solution {
        // Space Complexity : (0)
        // time Complexity: O(N)
        public int myAtoi(String s) {
            int n = s.length();
            int i = 0;
            int sign = 1;

            int result = 0;

            // 1.Discard all white spaces from the beginning of the inpurt string
            while (i < n && Character.isWhitespace(s.charAt(i))) {
                i += 1;
            }

            // Set the right sign
            if (i < n && s.charAt(i) == '+') {
                sign = 1;
                i += 1;
            } else if (i < n && s.charAt(i) == '-') {
                sign = -1;
                i += 1;
            }

            // Exit if non-digit is found
            while (i < n && Character.isDigit(s.charAt(i))) {
                int digit = s.charAt(i) - '0';
                // Check overflow and underflow conditions
                if (result > Integer.MAX_VALUE / 10 ||
                        result == Integer.MAX_VALUE / 10 &&
                                digit > Integer.MAX_VALUE % 10) {
                    // If integer overflowed return 2^31-1, else if underflowed return -2^31
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }

                // Append current digit to the result
                result = 10 * result + digit;
                i++;
            }
            // We have formed a valid number without any overflow/underflow.
            // Return it after multiplying it with its sign.
            return sign * result;
        }
    }
}
