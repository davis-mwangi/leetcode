package dynamic_programming_2.dp_on_strings;

/*
https://www.codingninjas.com/studio/problems/longest-common-subsequence_624879?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

Dp: 25
YT: https://www.youtube.com/watch?v=NPZn9jBrX8U&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=26

To solve subsequences you can use:
   - Power sets
   - Dp (recusrsion)

   Algorithm:
    1) Express in terms of indexes(str1Index, str2Index)
    2) Explore all possibilities
        - matches  =>  1 +  f(index 1, index 2)
        - not match, either move index 1 or index 2 => 0 +  max( f(index1 -1, index2), f(index1, index2 -1) )

*/
import java.util.*;

public class LongestCommonSubsequence {

    // Recursive Solution
    // TC: 2^m * 2^n where m and n are lengths of the strings
    // SC: m + n
    public class Solution1 {

        public static int lcs(String s, String t) {
            // Your code goes here
            int n = s.length();
            int m = t.length();

            return dfs(n - 1, m - 1, s, t);
        }

        private static int dfs(int i, int j, String s, String t) {
            // Base Case
            if (i < 0 || j < 0) {
                return 0;
            }
            // Match - we reduce both indexes
            if (s.charAt(i) == t.charAt(j)) {
                return 1 + dfs(i - 1, j - 1, s, t);
            } else { // Dont match, we either reduce i or j
                     // since we might miss a comparison, and return max or the two

                return 0 + Math.max(dfs(i - 1, j, s, t), dfs(i, j - 1, s, t));
            }
        }

    }

    // Memoization
    // TC : m * n + O(m+n)
    // SC: m * n + O(m+m)Auxiliary stack space
    public class Solution2 {

        public static int lcs(String s, String t) {
            // Your code goes here
            int n = s.length();
            int m = t.length();

            int[][] dp = new int[n][m];

            fill(dp, -1);

            return dfs(n - 1, m - 1, s, t, dp);
        }

        private static int dfs(int i, int j, String s, String t, int[][] dp) {
            // Base Case
            if (i < 0 || j < 0) {
                return 0;
            }
            if (dp[i][j] != -1) {
                return dp[i][j];
            }
            // Match - we reduce both indexes
            if (s.charAt(i) == t.charAt(j)) {
                int match = 1 + dfs(i - 1, j - 1, s, t, dp);
                dp[i][j] = match;
                return match;

            } else { // Dont match, we either reduce i or j
                     // since we might miss a comparison, and return max or the two
                int dontMatch = 0 + Math.max(dfs(i - 1, j, s, t, dp), dfs(i, j - 1, s, t, dp));
                dp[i][j] = dontMatch;
                return dontMatch;
            }
        }

        private static void fill(int[][] arr, int val) {
            for (int[] a : arr) {
                Arrays.fill(a, val);
            }
        }

    }

    // Tabulation \ Bottom-up
    // We do shifting of the index as in recusrive solution such that our indexes
    // run from 1 ---> n and 1 ---1 instead of 0 --> n-1 and i --> m-1
    // TC : O(m * n)
    // SC: O(m * n)
    public class Solution3 {

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
