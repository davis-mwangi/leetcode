package arrays_and_hashing;
/**
 * https://leetcode.com/problems/naming-a-company/
 * 
 * Algorithm:
 *     Brute Force is to have two nested loops then we flip each first charatcer  and determine if its uniques
 *        This will be O(N^2) *  len(word)
 * 
 *     Optimal Solution:
 *         - We can observe that if the first characters are same then we wont have change i.e time and toffee both start with "t"
 *         - Also the suffixes are same we wont have any change E.g toffee and coffee
 *      So to make sure we have uniques, we maintain a hashmap of   >> { first character :  hasmap of suffixes without first character);
 *      We do a nested loop conparing each suffixes in loop A and loop B, if we find both are same then thats an intersection,
 *         so unique names we can obtain from set A and Set B will be
 *            (size of set A -  intersection) *  (size of B  - intersection)
 *      we add to result;
 *   
 */
import java.util.*;

public class NamingACompany {
    class Solution {
        public long distinctNames(String[] ideas) {
            //We maintain map of first char and suffixes E.g  t : {ime, offee}
            Map<Character, Set<String>>map = new HashMap<>();
           
            for(String idea : ideas){
                char firstChar = idea.charAt(0);
                if(!map.containsKey(firstChar)){
                    map.put(firstChar, new HashSet<>() );
                }
                map.get(firstChar).add(idea.substring(1));
            }
    
            // {c=[offee], d=[onuts], t=[ime, offee]}
            long result = 0;
            for(Character ch1: map.keySet() ){
               
                //{c=[offee], d=[onuts], t=[ime, offee]}
                for (Character ch2 : map.keySet() ){
                      //we skip ideas starting with same chars since wont be unique
                      if(ch1 == ch2){
                          continue;
                      }
                      //Lets find suffixes that are common  in both sets e.g c[offee] and t:[ime, offee ]
                      int commonSuffixes = 0;
                      for(String suffix: map.get(ch1)){
                          if(map.get(ch2).contains(suffix)){
                              commonSuffixes += 1;
                          }
                      }
                      int uniqueSuffixes1 = map.get(ch1).size() - commonSuffixes;
                      int uniqueSuffixes2 = map.get(ch2).size() - commonSuffixes;
    
                    result += (long)(uniqueSuffixes1 * (long)uniqueSuffixes2); // unique combinations from both sets
                }
            }
    
    
            return result;
        }
    }
}
