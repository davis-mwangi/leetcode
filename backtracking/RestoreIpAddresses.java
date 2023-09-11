package backtracking;
/*
 * https://leetcode.com/problems/restore-ip-addresses/description/
 * 
 * Approach:
 * We do back tracking since we can only have 4 dots in an ip,
 * so we keep track till we get 4 dots and no more characters to consider
 * we add th result,
 * W also need to take note that characters that starts with zero and have more 
 * than one digit we need to terminate th iteration.
 */

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
    List<String>res = new ArrayList<>();
   
    public List<String> restoreIpAddresses(String s) {
        if(s.length() > 12){
            return res;
        }
        backtrack(s, 0, new ArrayList<>() ,0);
        return res;
    }

    private void backtrack(String s, int dots, List<String> currIp, int i){
        //Base case 
        if( i == s.length() && dots == 4 ){
              res.add(getIP(currIp));
              return;
        }

        if(i > s.length() || dots > 4){
            return;
        }

        for(int j = i; j < s.length(); j++){
            String str = s.substring(i, j + 1); 
            long val = Long.parseLong(str);

            if( str.charAt(0) == '0' && str.length() > 1 ) continue;
            if(val < 256L ){
                currIp.add(str);
                backtrack(s, dots + 1, currIp, j + 1 );
                currIp.remove( currIp.size() - 1);

            }
        }
    }
    private String getIP(List<String>lst){
        StringBuilder sb = new StringBuilder();
        for(String str: lst){
            sb.append(str).append(".");
        }
        sb.deleteCharAt(sb.length() -1);
        return sb.toString();
    }
}
