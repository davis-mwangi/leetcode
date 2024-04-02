package Neetcode_450_Questions;
/*
https://leetcode.com/problems/word-pattern/

*/
import java.util.*;
public class WordPattern_Easy_LC290 {
    class Solution {
        /*
         a - > dog
         b - > cat
         b - > cat
         a - > dog
         [dog,cat,cat,dog]
         {a:dog, b: cat}
    
         a - > dog
         b - > cat
         b - > cat
         a - > fish
    
    
        Space Complexity : O(N)
        Time Complexity O(N)
        */
        public boolean wordPattern(String pattern, String s) {
            Map<Character, String>map1 = new HashMap<>();
            Map<String, Character>map2 = new HashMap<>();
            String [] sArr = s.split(" ");
             int n = pattern.length();
            if(sArr.length != n){
                return false;
            }
           
            for(int i = 0; i < n; i++ ){
                if( map1.containsKey(pattern.charAt(i)) && !map1.get(pattern.charAt(i)).equals(sArr[i].trim()) || 
                   map2.containsKey(sArr[i].trim()) && map2.get(sArr[i].trim()) != pattern.charAt(i)){
                   return false;
                }
                map1.put(pattern.charAt(i), sArr[i]);
                map2.put(sArr[i], pattern.charAt(i));
            }
            return true;
            
        }
    }
}
