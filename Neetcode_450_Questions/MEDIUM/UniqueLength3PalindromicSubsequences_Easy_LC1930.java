package Neetcode_450_Questions.MEDIUM;

/*
https://leetcode.com/problems/unique-length-3-palindromic-subsequences/description/
*/
import java.util.*;

public class UniqueLength3PalindromicSubsequences_Easy_LC1930 {


    //Time Complexity : O(n * 26 )
    // Space Complexity : O(x) where x is number palindromic strings
    class Solution {
        /*
        "aabca"  since its just three characters left<-mid->right
        We maintain left and right array given we have 3 characters only
        */
        public int countPalindromicSubsequence(String s) {
            char[] right = new char[26];
            char[] left = new char[26];
    
            Set<String>res = new HashSet<>();
    
            //Get Frequency of  all characters in the string
            for(char ch : s.toCharArray() ){
                right[ch - 'a']++;
            }
    
            for(int i = 0; i < s.length(); i++ ){
                char middleChar = s.charAt(i);
                //Remove middle character from right 
                right[middleChar - 'a']--;
    
                //Check if exists a character in both right and left
                for(char c = 'a'; c <= 'z'; c++){
                    int leftAndRightChar = c  - 'a';
                    if( left[leftAndRightChar] > 0  && right[leftAndRightChar] > 0 ){
                        StringBuilder str = new StringBuilder();
                        str.append(c);
                        str.append(middleChar);
                        str.append(c);
                        
                        res.add(str.toString());
                    }
                }
                //Add increase frequency of left by middle character
                left[middleChar - 'a']++;
            }
        
            return res.size();
        }
    }

    // Solution using backtracking
    // Time complexity : O(2^n)
    // Space Complexity : O(n)
    class Solution2 {
        /*
         * "aabca" - > subsequence (take or not take)
         * - stream becomes of size 3 check if its palindrome and add to the result
         * 
         */
        Set<String> palindromeStr = new HashSet<>();

        public int countPalindromicSubsequence(String s) {
            int strSize = 3;
            backtrack(0, s, new StringBuilder(), strSize);
            return palindromeStr.size();

        }

        private void backtrack(int i, String s, StringBuilder subseqStr, int strSize) {

            // Base Case
            if (palindromeStr.contains(subseqStr.toString())) {
                return;
            }
            if (subseqStr.length() == strSize) {
                // Check if palindrome
                if (isPalindrome(subseqStr.toString())) {
                    palindromeStr.add(subseqStr.toString());
                }
                return;
            }

            if (i >= s.length()) {
                return;
            }

            // Dont Take
            backtrack(i + 1, s, subseqStr, strSize);

            // Take
            subseqStr.append(s.charAt(i));
            backtrack(i + 1, s, subseqStr, strSize);
            // Backtrack
            subseqStr.deleteCharAt(subseqStr.length() - 1);// Remove the last character added.
        }

        private boolean isPalindrome(String str) {
            int left = 0;
            int right = str.length() - 1;
            while (left <= right) {
                if (str.charAt(left) != str.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}
