package Neetcode_450_Questions;
/*
https://leetcode.com/problems/isomorphic-strings/description/
*/
import java.util.*;
public class IsomorphicStrings_Easy_205 {
    class Solution {
        /*
         e -> a
         g -> d
         g -> d
        true
        
         f -> b b -> f
         o -> a a -> o
         o -> r r -> o
         false
        
         p -> t t-> p
         a -> i i -> a
         p -> t  
         e -> l
         r -> e

         Space Complexity:  2 * O(N)  ~ O(N)
         Time Complexity : O(N)
        */
            public boolean isIsomorphic(String s, String t) {
                Map<Character, Character>stMap= new HashMap<>();   
                Map<Character, Character>tsMap= new HashMap<>();
                int sN = s.length();
                int tN = t.length();
                int n = Math.min(sN, tN);
               
                for(int  i = 0; i< n; i++){
                     char chs = s.charAt(i);
                     char cht = t.charAt(i);
        
                     System.out.println(stMap+ " | "+tsMap);
        
        
                     if( (stMap.containsKey(chs) && stMap.get(chs) != cht) || (tsMap.containsKey(cht) && tsMap.get(cht) != chs) ){
                        return false;
                     }
                     stMap.put(chs, cht);
                     tsMap.put(cht, chs);
                }
                return true;
            }
        }
}
