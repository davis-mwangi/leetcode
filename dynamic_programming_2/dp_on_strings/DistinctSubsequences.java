package dynamic_programming_2.dp_on_strings;
/*
https://www.codingninjas.com/studio/problems/subsequence-counting_3755256?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

str ="brootgroot" sub="brt"

Find number of subsequences of "str" which are equal to "syb"

Algo:
  1. Express in terms of i and j
  2 Explore possibilities, if char march we can either decide to take that char or ignore it
       else if doesnt match, we just one option to ignore it
  3. Write base case, if j becomes -ve , we have fully matched the string so we return 1
                     if  i becomes -ve then we have exhausted our options we return 0
  
*/
import java.util.*;

public class DistinctSubsequences {
    //Recursive solution
    //TC: Exponential 
    //Sc: O(m+n)
    public class Solution1 {
        public static int distinctSubsequences(String str, String sub) {
            // Write your code here.
            int i = str.length();
            int j = sub.length();
            return dfs(i -1 , j - 1, str, sub);
        }
        private static int dfs(int i, int j, String str, String sub){
            //Base case
            if(j < 0){
                return 1;
            }
            if (i < 0){
                return 0;
            }
    
            if( str.charAt(i) == sub.charAt(j) ){
                return dfs(i - 1,  j - 1, str, sub) + dfs(i-1, j, str, sub);
            }else{
                return dfs(i-1, j, str, sub);
            }
        }
    }

    //TC: O(N  * M)
    //SC: O(N * M) + O(M + N)
    public class Solution2 {
        public static int distinctSubsequences(String str, String sub) {
            // Write your code here.
            int i = str.length();
            int j = sub.length();
            int [][] dp = new int[i][j];
            fill(dp, -1);
            return dfs(i -1 , j - 1, str, sub, dp);
        }
        private static int dfs(int i, int j, String str, String sub,
          int[][]dp){
            //Base case
            if(j < 0){
                return 1;
            }
            if (i < 0){
                return 0;
            }
            if(dp[i][j] != -1){
                return dp[i][j];
            }
    
            if( str.charAt(i) == sub.charAt(j) ){
                return dp[i][j] = dfs(i - 1,  j - 1, str, sub,dp) + dfs(i-1, j, str, sub, dp);
            }else{
                return dp[i][j] = dfs(i-1, j, str, sub, dp);
            }
        }
        private static void fill (int[][]arr, int val){
            for(int[] a: arr){
                Arrays.fill(a, val);
            }
        }
    }

    public class Solution3 {
        public static int distinctSubsequences(String str, String sub) {
            // Write your code here.
            int n = str.length();
            int m = sub.length();
    
            long [][] dp = new long[n +1][m + 1];
           
           
            for(int i =0; i <= n; i++){
                dp[i][0] = 1;
            }
            for(int j = 1; j <= m; j++){
                dp[0][j] = 0;
            }
    
            for(int i = 1; i <=n; i++){
                for(int j = 1; j <= m; j++){
                    
                    if( str.charAt(i - 1) == sub.charAt(j - 1) ){
                        dp[i][j] = dp[i - 1][j - 1] + dp[i-1][j];
                    }else{
                        dp[i][j] = dp[i-1][j];
                    }
    
                }
            }
    
            return (int)dp[n][m];
        }
    }
}
