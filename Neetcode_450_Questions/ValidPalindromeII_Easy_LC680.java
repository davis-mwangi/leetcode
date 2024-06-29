package Neetcode_450_Questions;
/*
https://leetcode.com/problems/valid-palindrome-ii/description/
*/
public class ValidPalindromeII_Easy_LC680 {
    class Solution {
        /*
         "abca"
         rightSkip =  abc 
         leftSkip =   bca
        check if palindrome
    
        */
        public boolean validPalindrome(String s) {
              int l = 0;
              int r =  s.length() - 1;
              while(l <= r){
               
                if(s.charAt(l) !=  s.charAt(r)){
                    //Check if palindrome by skipping either right or left character
                    String leftSkip = s.substring(l+1, r+1);
                    String rightSkip = s.substring(l, r);
    
                    return ( isPalindrome(leftSkip) || isPalindrome(rightSkip) );
                }
                l++;
                r--;
            }
            return true;
        }
        private  boolean isPalindrome(String s){
            int left = 0; 
            int right = s.length() -1;
            while(left <= right){
               if(s.charAt(left) != s.charAt(right)){
                return false;
               }
               left++;
               right--;
            }
            return true;
        }
    }


    class Solution2 {
        /*
         "abca"
         rightSkip =  abc 
         leftSkip =   bca
        check if palindrome
    
        */
        public boolean validPalindrome(String s) {
              int l = 0;
              int r =  s.length() - 1;
              while(l <= r){
               
                if(s.charAt(l) !=  s.charAt(r)){
                    //Check if palindrome by skipping either right or left character
                    return ( isPalindrome(s, l+1, r) || isPalindrome(s, l, r-1) );
                }
                l++;
                r--;
            }
            return true;
        }
        private  boolean isPalindrome(String s, int left, int right){
            while(left <= right){
               if(s.charAt(left) != s.charAt(right)){
                return false;
               }
               left++;
               right--;
            }
            return true;
        }
    }
}
