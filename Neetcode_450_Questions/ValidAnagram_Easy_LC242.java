package Neetcode_450_Questions;
/*

https://leetcode.com/problems/valid-anagram/description/

*/
public class ValidAnagram_Easy_LC242 {
    class Solution {
        /*
        anagram  => nagaram
        since we have only 25 chars, we can use ASCII reprensation.
        We subtract char 'a' to get ascii value E.g 'a' - 'a' = 0 (97 - 97 = 0), 'a'-'b'=1(97 -96=1)
        [0,0,0,0]
         0 1 2 3

        Space Complexity : O(26)
        Time Complexity :  O(26)
    
        */
        public boolean isAnagram(String s, String t) {
            
            int sLen = s.length();
            int tLen = t.length();
    
            //Not Equal, cannot form Palindrome
            if(sLen != tLen){
                return false;
            }
    
            int [] chars = new int[26];
            for(int i = 0;  i < sLen; i++ ){
                chars[s.charAt(i) - 'a']++;
                chars[t.charAt(i) - 'a']--;
            }
            //If anagram all values will be zero since will cancel out each other m else there is char not in both strings
            for(int i = 0; i < 26; i++){
                if(chars[i] > 0){
                    return false;
                }
            }
            return true;
        }
    }
}
