package arrays_and_hashing;
/*
We can use backtracking , to make disjoint subsequence we will use 2 strings, 
At every character i in string s we can make 3 choices:
    -  include the char in str1
    -  include the char in str2
    -  not include the char in any of the strings(str1 and str2)
we use backtracking to generate all disjoint subsquences
We consider only those that are palindromic and ignore the rest
We can calculate the product each time  for the palindromic subsequence and compare if the product
  is greater than current product.

*/
public class MaxProductOfTheLengthOfTwoPalindromicSubsequences {
    
    //Time Complexity: O(3^n * n)
    //Space Complexity:  2 * O(n) ~ O(n)
    class Solution {
        long res = 0;
      
        public int maxProduct(String s) {
            backtrack(0, s, new StringBuilder(), new StringBuilder() );
            return (int)res;
        }
    
        private void backtrack(int i, String s, StringBuilder str1, StringBuilder str2){
            //Base Case
            if(i >= s.length()){
                //When we get out of bound, we check is the strings are palidromes
                //If they are we caluculate the product of the lengths
                if(isPalindrome(str1.toString()) &&  isPalindrome(str2.toString() )){
                      long product =  Math.max(res,  ((long)str1.length() *  (long)str2.length()) );
                      res = Math.max(res, product);
                }
                return;
            }
    
           //Case add  char to str1
           str1.append(s.charAt(i));
           backtrack(i + 1, s, str1, str2);
           str1.deleteCharAt(str1.length() - 1);
    
           //Case add char to str2
           str2.append(s.charAt(i));
           backtrack(i+1, s, str1, str2);
           str2.deleteCharAt(str2.length() -1 );
    
           //Case ignore 
           backtrack(i+1, s, str1, str2);
        }
    
        private boolean isPalindrome(String s){
           int l = 0;
           int r = s.length() - 1 ;
           while(l <= r){
               if(s.charAt(l) != s.charAt(r)){
                   return false;
               }
               l++;
               r--;
           }
           return true;
        }
    }
}
