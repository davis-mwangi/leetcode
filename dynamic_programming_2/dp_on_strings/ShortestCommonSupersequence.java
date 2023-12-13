package dynamic_programming_2.dp_on_strings;
/*
https://www.codingninjas.com/studio/problems/shortest-supersequence_4244493?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

With longest common subsequence we can solve this by,

Working in reverse, when we find a match we only take the character,
else depending on wther the  longest is from i or j , 
in the case its greater we take the one we ignore before we proceed.

At the end  chars in  s1 or s2 might get exhausted, so we must consider taking the remaiing characters 
as well
*/
public class ShortestCommonSupersequence {
    public class Solution {
        public static String shortestSupersequence(String s, String t) {
                // Write your code here..
                int n = s.length();
                int m = t.length();
    
                int[][] dp = new int[n + 1][m + 1];
    
                // Base Case
                for (int i = 0; i <= n; i++) {
                    dp[i][0] = 0;
                }
                for (int j = 0; j <= m; j++) {
                    dp[0][j] = 0;
                }
    
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= m; j++) {
                        // Match - we reduce both indexes
                        if (s.charAt(i - 1) == t.charAt(j - 1)) {
                            dp[i][j] = 1 + dp[i - 1][j - 1];
                        } else { // Dont match, we either reduce i or j
                                 // since we might miss a comparison, and return max or the two
                            dp[i][j] = 0 + Math.max(dp[i - 1][j], dp[i][j - 1]);
                        }
                    }
                }
    
            int i = n; 
            int j = m;
    
            StringBuilder sb = new StringBuilder();
    
            while(i > 0 && j > 0){
                if(s.charAt(i - 1) == t.charAt(j -1)){
                  sb.append(s.charAt(i -1));
                  i--;
                  j--;
                }
                else if(dp[i -1][j] > dp[i][j -1]){
                    sb.append(s.charAt(i-1));
                    i--;
                }else{
                    sb.append(t.charAt(j-1));
                    j--;
                }
            }
            //Case of remaining chars
            while(i > 0){
                sb.append(s.charAt(i -1));
                i--;
                j--;
            }
            while(j > 0){
                sb.append(t.charAt(j -1));
                j--;
                i--;
            }
            //Since we moved from last index to 0,0 index lets reverse the string
            sb.reverse();
            return sb.toString();
        }
    
    }
}
