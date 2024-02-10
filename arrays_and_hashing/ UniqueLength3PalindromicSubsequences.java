package arrays_and_hashing;
/*
https://leetcode.com/problems/unique-length-3-palindromic-subsequences/description/

*/
import java.util.*;

public class  UniqueLength3PalindromicSubsequences {
    

    class Solution {
        /*
        a a b c a
            ^
    
        */
        Set<String>res = new HashSet<>();
    
        public int countPalindromicSubsequence(String s) {
            recurse(0, s, new StringBuilder () );
        
            return res.size();
        }
    
        private void recurse(int i, String s, StringBuilder subSeq){
    
           //Base case
    
           if( res.contains(subSeq.toString() )){
               return;
           }
           if(subSeq.length() == 3){
               //check if palidrome
               if( isPalindrome( subSeq.toString() ) ){
                   res.add( subSeq.toString() );
               }
               return;
           }
    
            if(i >= s.length() ){
                return;
            }
    
           //dont take
           recurse(i+1, s, subSeq);
        
           // take
           subSeq.append(s.charAt(i));
           recurse(i+1, s, subSeq);
           subSeq.deleteCharAt( subSeq.length() -1);
            
        }
    
        private boolean isPalindrome(String str){
            int l = 0;
            int r = str.length() - 1;
            while(l <= r){
                if( str.charAt(l) != str.charAt(r ) ){
                    return false;
                }
                l++;
                r--;
            }
            return true;
        }
    
    
    }
}
