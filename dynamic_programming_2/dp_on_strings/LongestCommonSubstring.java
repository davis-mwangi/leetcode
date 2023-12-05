package dynamic_programming_2.dp_on_strings;
/*
Example:  
str1 = "abcjklp" str2 = "ackkp"

This questions uses the subsequence concept only that we dont consider any skips
When using the tabulation method, we take the previous and add one if the current characters
from both strings match

*/
public class LongestCommonSubstring {
   
    // TC: O(n * m)
    // TC: O(n * m)
    public class Solution {
        public static int lcs(String str1, String str2){
            // Write your code here.
            int n = str1.length();
            int m = str2.length();
    
            int [][] dp = new int[n + 1][m + 1];
    
            for(int i = 0;  i <= n; i++){
                dp[i][0] = 0;
            }
            for(int j = 0; j <= m; j++){
                dp[0][j] = 0;
            }
    
            int res = 0;
    
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= m; j++){
                    //Case where chars match
                    if(str1.charAt(i -1 ) ==  str2.charAt(j - 1)){
                       int longest = 1 + dp[i -1][j - 1];
                       dp[i][j]= longest;
                       res = Math.max( longest, res);
                    }else{
                       dp[i][j] = 0;
                    }
                }
            }
            return res;
        }
    }
    
}
