package Neetcode_450_Questions;
/*
https://leetcode.com/problems/merge-strings-alternately/description/
*/
public class MergeStringsAlternately_Easy_LC1768 {
    /*
 w1 = "abc"
 w2 = "pqr"
    a p b q c r 

    Time Complexity : O(n)
    Space Complexity : (1)
*/
class Solution {

    public String mergeAlternately(String word1, String word2) {
        int w1 = word1.length();
        int w2 = word2.length();
        int n  = Math.min(w1, w2);
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while( i  <  n ){
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
            i++;
        }
        if(w1 > w2){
            while( i < w1){
              sb.append(word1.charAt(i));
              i++;
            }     
        }
        if(w2 > w1){
            while(i < w2){
             sb.append(word2.charAt(i));
             i++;
            }
        }
        return sb.toString();
    }
}
}
