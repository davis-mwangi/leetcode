package backtracking;
/*
 * https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/
 
 Approach:

 We perform backtracking where at each call we check we have duplicates
 we can either consider  the string at i or not
 We maintain a global value that maitains the max length of the 
 unique subsequesnce

 */
import java.util.*;
public class MaxLength1239 {
    public int maxLength(List<String>arr){
        Set<Character>charSet = new HashSet<>();
        return backtrack(arr, 0, charSet );
    }
    private int backtrack(List<String>arr, int i,Set<Character>charSet){
        if(i == arr.size()){
         return charSet.size();
        }
        int res = 0;
        //Conside the string
        if(!overlap(charSet, arr.get(i))){
            res = backtrack(arr, i + 1, charSet);
            //undo the chars added
            for(char ch: arr.get(i).toCharArray()){
                charSet.remove(ch);
            }
        }        //Not considering the string
        return Math.max(res, backtrack(arr, i + 1, charSet));
    }

    private boolean overlap(Set<Character>charSet, String str){
        System.out.println(charSet);
         for (int i = 0; i < str.length(); i++ ){
            if( charSet.contains(str.charAt(i)) ){
                for(int j = 0; j < i; j++){
                    charSet.remove(str.charAt(j));
                }
                return true;
            }else {
            charSet.add(str.charAt(i));
            }
         }
         return false;
    }  
    
}
