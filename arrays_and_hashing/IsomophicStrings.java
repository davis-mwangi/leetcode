package arrays_and_hashing;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/isomorphic-strings/
 * 
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * 
 * egg / add => true
 * paper/title= true
 * 
 * Time Complexity: O(n)
 * Space Complexity O(2.n) ~ O(n)
 */
public class IsomophicStrings {
    
    public boolean isIsomorphic(String s, String t){
        HashMap<Character,Character>stMap = new HashMap<>();
        HashMap<Character,Character>tsMap = new HashMap<>();

        if(s.length() != t.length()){
            return false;
        }

        for(int i = 0;  i < s.length(); i++){
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            if ( (stMap.containsKey(charS) && stMap.get(charS) != charT) ||
                  (tsMap.containsKey(charT) && tsMap.get(charT) != charS) ){
                      return false;
            }

             stMap.put(charS, charT);
             tsMap.put(charT, charS);
        }
        return true;
    }
}
