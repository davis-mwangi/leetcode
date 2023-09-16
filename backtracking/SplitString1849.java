package backtracking;

import java.util.*;

/*
 * https://leetcode.com/problems/splitting-a-string-into-descending-consecutive-values/
 */
public class SplitString1849 {

    public boolean splitString(String s) {
        for(int i = 0; i < s.length() -1; i++){
            String subStr = s.substring(0, i +1);
            Long val = Long.parseLong(subStr);
            if( dfs(s, i + 1, val) ){
                return true;
            }
        }
        return false;
    }

    private boolean dfs(String s, int i, long prev){
          if(i == s.length()){
            return true;
          }
          for(int j = i; s.length(); j++){
            String subStr = s.substring(0, i +1);
            Long val =

    Long.parseLong(subStr);
            if( (val + 1L) &&  dfs(s, i + 1, val) ){
                return true;
            }
          }
          
}
}
