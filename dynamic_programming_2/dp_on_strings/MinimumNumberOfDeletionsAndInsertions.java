package dynamic_programming_2.dp_on_strings;
/*
https://www.codingninjas.com/studio/problems/can-you-make_4244510?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

To approach this problem,
s1 = "abcd"  s2 = "anc"

One naive way is delete everything in String s1 and  insert s2 into s2
This will take n + m time, where n =  deletions and m insertions

To  minimize this (n +m), we can retain chars common in two strings 
Delete the rest in string  s1 and insert the remaining chars in s2 to s1
 
in short Deletions   =  n - longest_common_subsequence(lcs)
         Insertions  =  m - lonngest_common_subsequence(lcs)
         total = n - lcm + m - lcm
               = n + m  -   2 * lcm



*/
public class MinimumNumberOfDeletionsAndInsertions {
    public class Solution {
       
        public static int canYouMake(String s1, String s2) {
            // Write your code here.
            int n = s1.length();
            int m =  s2.length();
    
            int total =  (n + m) -  2 * lcs(s1, s2);
            return total;
        }
        
         public static int lcs(String s, String t) {
                // Your code goes here
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
                return dp[n][m];
            }
        
    }
}
