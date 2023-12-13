package dynamic_programming_2.dp_on_strings;
/*
https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqa1V4TERJVWM2eUJCOU1Sem94Yy05QkNHNzZGZ3xBQ3Jtc0trNmIwa0xDdVlrTGdYaEx0STBRc3VHZ25kRWlvN0pzZU5RNHNCVzlvTTdHT0pOc25qT3pKMHNzYXZXT2dZWnh6TTNOeXRNZmVJSDJxRG9oTWtRRWhEUWJGcHVpV0JxemtSUU5VWUdEVmU0bWV3U2NzOA&q=https%3A%2F%2Fbit.ly%2F3H2ZtGP&v=xPBLEj41rFU

To determine min insertions we can just determine  the longest palindromic subsequence,
Once we have that we can then get the min by
 min =  n  - longest_palindromic_subsequence


 E.g str = "abca"


*/
public class MinimumInsertionsToMakeAStringPalindrome {
    public class Solution {
    public static int minInsertion(String str) {
        // Write your code here.
        int n =  str.length();
        return n- lcs(str);
    }
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
}
