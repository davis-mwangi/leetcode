package arrays_and_hashing;
import java.util.*;

/**
 * https://leetcode.com/problems/unique-length-3-palindromic-subsequences/
 */
public class UniqueLength3PalindromicSubsequences {
    //aabca
    public int countPalindromicSubsequence(String s) {
        Set<String>result = new HashSet<>(); //(mid, out) => 26^2
        Set<Character>left = new HashSet<>();
        Map<Character,Integer>right = new HashMap<>();

        //Create Count Map
        for(int i = 0; i < s.length(); i++){
            right.put(s.charAt(i), right.getOrDefault(s.charAt(i), 0) + 1);
        }
       

        for(int i = 0; i <  s.length(); i++){
            //Remove current from the right map
            right.put(s.charAt(i), right.get(s.charAt(i)) - 1 );
            
            if(right.get(s.charAt(i)) == 0){
                 right.remove(s.charAt(i));
            }
            //Check the right and left for the same outer character 
            for(int j = 0; j < 26 ; j++){
                char ch = (char)('a' + j);
                if(left.contains(ch) && right.containsKey(ch)){
                    result.add(s.charAt(i)+":"+ch);
                }
            }
            //Add to the left
            left.add(s.charAt(i));

        }
        
        return result.size();
        
    }
}
