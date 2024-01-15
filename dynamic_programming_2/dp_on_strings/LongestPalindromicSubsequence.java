package dynamic_programming_2.dp_on_strings;
/*
Leetcode: https://leetcode.com/problems/longest-palindromic-subsequence/description/
Coding Ninjas : https://www.codingninjas.com/studio/problems/longest-palindromic-subsequence_842787

We use Longest common subsequence, but since here we checking for palindromic subsequence,
we reverse the string and then use subsequence algorithm
to get the longest




*/


public class LongestPalindromicSubsequence {

     public static int lcs(String s) {

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        return lcs(s, sb.toString() );
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
