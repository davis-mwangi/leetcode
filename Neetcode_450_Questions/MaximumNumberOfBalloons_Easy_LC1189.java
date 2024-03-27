package Neetcode_450_Questions;
/*
https://leetcode.com/problems/maximum-number-of-balloons/description/

*/
import java.util.*;

public class MaximumNumberOfBalloons_Easy_LC1189 {
    //Space Complexity : O(N)
    //Space Complexity : 2 * O(N) ~  O(N)
    class Solution {
        /*
         {n:1, l: 2 ....}
    
        */
        public int maxNumberOfBalloons(String text) {
            String  word = "balloon";
            Map<Character, Integer>bMap= new HashMap<>();
            for( char ch :  word.toCharArray() ){
                bMap.put(ch, bMap.getOrDefault(ch, 0) +1);
            }
    
            //Text frequency
            Map<Character, Integer>textMap = new HashMap<>();
            for(char ch : text.toCharArray() ){
                textMap.put(ch, textMap.getOrDefault(ch, 0)+1);
            }
            
            int minCount = Integer.MAX_VALUE;;
            for( char ch :  word.toCharArray()){
                if(textMap.containsKey(ch)){
                   int count = textMap.get(ch) / bMap.get(ch);
                   minCount = Math.min(minCount, count);
                }else{
                    return 0;
                }
            }
            return minCount;
    
        }
    }
}
