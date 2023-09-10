package backtracking;
import java.util.*;

/*
https://leetcode.com/problems/palindrome-partitioning/description/
              ["aab"]
       "a"     "aa"   "aab"
    "a"  "ab"   "b"
  "b" 
  
  ["a","b", "c"], ["b","aa"]

The time complexity of the algorithm for generating all possible palindromic partitioning is typically expressed as
 O(n * 2^n), where n is the length of the input string. This complexity arises because there can be 2^n possible partitions, 
 and for each partition, we need to check if each substring is a palindrome, which takes O(n) time in the worst case.
 */

public class PalindromePartitioning {
    List<List<String>>res = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        backtrack(s, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack(String s, List<String> curr, int i){
        //Base Case
        if(i >= s.length()){
            res.add( new ArrayList<>(curr) );
            return;
        }

        for(int j = i; j < s.length(); j++){
            //Check if palindrome //i => left boundary , j =>right boundary
            //We only continue if the current str is palindrome
            if(isPalindrome(s, i, j)){
                curr.add(s.substring(i, j + 1));
  
                backtrack(s, curr, j + 1);
                
                curr.remove( curr.size() - 1 );
            }

        }
    }

    private boolean isPalindrome(String s, int l, int r){
         while (l <= r){
             if( s.charAt(l) != s.charAt(r) ){
                 return false;
             }
             l++;
             r--;
         }
         return true;
    }
}
