package Neetcode_450_Questions.MEDIUM;

/*

https://leetcode.com/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/description/

*/
public class MaximumProductOfTheLengthOfTwoPalindromicSubsequences_Medium_LC2002 {
    /*
     * We can use backtracking , to make disjoint subsequence we will use 2 strings,
     * At every character i in string s we can make 3 choices:
     * - include the char in str1
     * - include the char in str2
     * - not include the char in any of the strings(str1 and str2)
     * we use backtracking to generate all disjoint subsquences
     * We consider only those that are palindromic and ignore the rest
     * We can calculate the product each time for the palindromic subsequence and
     * compare if the product
     * is greater than current product.
     * 
     * 
     * Time Complexity : O(3^n) since we making 3 choices
     * Space Complexity :O(N) because of auxiliary stack space
     */
    class Solution {
        long maxProduct = 0;

        public int maxProduct(String str) {
            // Solution
            backtrack(0, str, new StringBuilder(), new StringBuilder());
            return (int) maxProduct;
        }

        private void backtrack(int i, String str, StringBuilder sb1, StringBuilder sb2) {
            // Base case
            if (i >= str.length()) {
                // Check if both palindrome
                if (isPalindrome(sb1.toString()) && isPalindrome(sb2.toString())) {
                    long product = (long) sb1.length() * (long) sb2.length();
                    maxProduct = Math.max(maxProduct, product);
                }
                return;
            }

            // Case 1: add to str1
            sb1.append(str.charAt(i));
            backtrack(i + 1, str, sb1, sb2);
            sb1.deleteCharAt(sb1.length() - 1);

            // Case 2 : Add to str2
            sb2.append(str.charAt(i));
            backtrack(i + 1, str, sb1, sb2);
            sb2.deleteCharAt(sb2.length() - 1);

            // Case 3: Not add to any of the string(Ignore the character and move on)
            backtrack(i + 1, str, sb1, sb2);
        }

        private boolean isPalindrome(String s) {
            int left = 0;
            int right = s.length() - 1;
            while (left <= right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}
