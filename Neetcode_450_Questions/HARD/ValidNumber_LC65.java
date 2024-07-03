package Neetcode_450_Questions.HARD;

/*
Question : https://leetcode.com/problems/valid-number/description/

Guide : https://www.youtube.com/watch?v=5c6MdetEfoA

Test Cases:

"0"
"e"
"."
"-1."
"005047e+6"
"+6e-1"
"4e+"
"+"

For example, all the following are valid numbers:
 "2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789",
 
 while the following are not valid numbers: "abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53".
*/
public class ValidNumber_LC65 {
    class Solution {
        public boolean isNumber(String s) {
            boolean numberSeen = false;
            boolean decimalSeen = false;
            int n = s.length();
            int i = 0;

            while (i < n) {

                // Check for start -ve or +ve sign
                if (i == 0 && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
                    // Move by one step
                    i += 1;
                }
                // "+"
                if (i >= n) {
                    return false;
                }

                char ch = s.charAt(i);
                // Validate letter
                if (Character.isLetter(ch)) {

                    if (!(ch == 'E' || ch == 'e')) {
                        return false;
                    }
                    // Must have seen number for it to be valid 10e
                    if (!numberSeen) {
                        return false;
                    }
                    // Must also be followed by number => e-78, E67, e+45
                    if (i + 1 < n) {

                        int j = i;
                        // Move by one step
                        if (s.charAt(j + 1) == '+' || s.charAt(j + 1) == '-') {
                            j += 2;
                        } else {
                            j += 1;
                        }
                        // "4e+"
                        if (j >= n) {
                            return false;
                        }

                        while (j < n) {
                            if (!Character.isDigit(s.charAt(j))) {
                                return false;
                            }
                            j++;
                        }

                        if (j == n) {
                            return true;
                        }

                    } else {
                        return false;
                    }

                } else if (ch == '.') {
                    // We cannot have two dots(.) to represent decimal

                    if (!decimalSeen) {

                        decimalSeen = true;

                    } else {
                        return false;
                    }
                } else if (ch == '+' || ch == '-') {
                    // Any -ve or +ve that comes in between
                    return false;
                } else if (Character.isDigit(ch)) {
                    numberSeen = true;
                }

                i += 1;
            }

            // No number seen, e.g -e
            return numberSeen;
        }
    }
}
