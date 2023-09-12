package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfPhoneNumber {
     public List<String> letterCombinations(String digits) {
        
        List<String>result = new ArrayList<>();
        
        HashMap<Character, String>digitMap = new HashMap<>();
        digitMap.put('2', "abc");
        digitMap.put('3', "def");
        digitMap.put('4', "ghi");
        digitMap.put('5', "jkl");
        digitMap.put('6', "mno");
        digitMap.put('7', "pqrs");
        digitMap.put('8', "tuv");
        digitMap.put('9', "wxyz");
        
        if(digits != null && !digits.trim().isEmpty()){
             backtrack(digits, result, digitMap,"",  0);
        }
         
        return result;
        
    }
    public void backtrack(String digits,  List<String>result,  HashMap<Character, String>digitMap,  String currStr,  int i){
        
        if(currStr.length() ==  digits.length()){
             result.add(currStr);
            return;
        }
        
        for(Character ch :  digitMap.get( digits.charAt(i) ).toCharArray() ){
            
            backtrack(digits, result, digitMap, currStr + ch , i + 1);
        }
    }
}
