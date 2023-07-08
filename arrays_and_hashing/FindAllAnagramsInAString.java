package arrays_and_hashing;
import java.util.*;
/**
 * 
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 */

// Time Complexity:  O(m) + (n)
// Space Complexity: O(n)
public class FindAllAnagramsInAString {
    //s = cba ebabacd p = abc 
    //    deque [a,e,b]
    //           l r
    // [a,b,c]
    public List<Integer> findAnagrams(String s, String p){          
            Map<Character,Integer>sMap = new HashMap<>();
            Map<Character,Integer>pMap = new HashMap<>();
            
            List<Integer>result= new ArrayList<>();
    
            if(p.length() > s.length()){
              return result;
            }
         
            int l = 0;
            int r = 0;
            while(r < p.length()){
                sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r), 0) + 1);
                pMap.put(p.charAt(r), pMap.getOrDefault(p.charAt(r), 0) + 1);
                r++;
            }
            while(r <= s.length()){
              
              if(sMap.equals(pMap)){
                result.add(l);
              }
    
              if(r == s.length()){
                return result;
              }
    
              sMap.put(s.charAt(l), sMap.get(s.charAt(l)) -1 );
              
              if(sMap.get(s.charAt(l)) == 0){
                sMap.remove(s.charAt(l));
              }
    
              sMap.put(s.charAt(r), sMap.getOrDefault(s.charAt(r), 0) + 1 );
    
              l++;
              r++;
            }
            return result;
    }
}
