package arrays_and_hashing;
import java.util.*;
/**
 * https://leetcode.com/problems/word-pattern/
 */
//Time Complexity: O(n+m)
//Space Complexity : O(n+m))
public class WordPattern {
    
    // [dog, cat, cat, dog]
    // [a  , b  ,  b ,   a]
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String>charToWord = new HashMap<>();
        HashMap<String,Character>wordToChar = new HashMap<>();
       
        String[] words =  s.split(" ");

        if(pattern.length() != words.length){
            return false;
        }

        for( int i = 0; i < pattern.length(); i++){
            char ch = pattern.charAt(i);
            String word = words[i];

            if(charToWord.containsKey(ch) && !charToWord.get(ch).equals(word)){
                 return false;
            }

            if(wordToChar.containsKey(word) && !wordToChar.get(word).equals(ch)){
               return false;
            }
            
            charToWord.put(ch, word);
            wordToChar.put(word, ch);
        }
        
        return true;

    }

    }
}
