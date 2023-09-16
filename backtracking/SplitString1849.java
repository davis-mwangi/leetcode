package backtracking;

import java.math.BigInteger;
/*
 * https://leetcode.com/problems/splitting-a-string-into-descending-consecutive-values/
 * 
 * Approach:
 * We need to iterate each time considerinth the length from zero to index,
 * We perform backtrack and stop whenever we find a value that is  prev == (current + 1)
 * if the gets out of bound , we return true 
 * If we  get a tru, we return immediatelu=y
 * Else we contine ad retuen false;
 */
public class SplitString1849 {

    public boolean splitString(String s) {

        for (int i = 0; i < s.length() - 1; i++) {
            String subStr = s.substring(0, i + 1);
            BigInteger bigIntValue = new BigInteger(subStr);
    
            if ( dfs(s, i + 1, bigIntValue) ) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(String s, int index, BigInteger prev) {
        if (index == s.length()) {
            return true;
        }
        for (int j = index; j < s.length(); j++) {
            String subStr = s.substring(index, j + 1);
            BigInteger val = new BigInteger(subStr);
            if ( val.add(BigInteger.valueOf(1)).equals(prev) && dfs(s, j + 1, val)) {
                return true;
            }
        }
        return false;

    }
}
