package arrays_and_hashing;
/*
https://leetcode.com/problems/maximum-number-of-balloons/description/

trick is to use get the minimun ratio of the characters in balloon
**/
import java.util.*;

public class MaxNumberOfBalloons {
    // "nlaebolko" => balloon {b:1, a:1, l:2, o:2, n:1}
    //  "loonbalxballpoon". => {l:4, o: 4, n :2, b:2, a:2, x: 1, p:1 }
    //Deque
    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer>textMap= createMapFromString(text);
        Map<Character, Integer>ballonMap = createMapFromString("balloon");

        Integer result = Integer.MAX_VALUE;

        for (Character ch : ballonMap.keySet() ){
            int ratio = (textMap.getOrDefault(ch, 0) / ballonMap.get(ch) );
            result = Math.min(result, ratio );
        }

        return result.intValue();
    }

    public Map<Character,Integer>createMapFromString(String str){
        Map<Character, Integer>map = new HashMap<>();
        for (int i=0; i< str.length(); i++){
          if(!map.containsKey(str.charAt(i))){
              map.put(str.charAt(i), 0);
          }
          map.put(str.charAt(i), map.get(str.charAt(i)) +1);
        }
        return map;
    }
}
