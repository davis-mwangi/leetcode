package dynamic_programming_2.dp_on_strings;
/*
Longest common subsequence will give the max length of subsequence
E.g   will be 3 where s = "adebc" and t = "dcadb"
 
0 0 0 0 0 0
0 0 0 1 1 1
0 1 1 1 2 2
0 1 1 1 2 2
0 1 1 1 2 3
0 1 2 2 2 3

to print the actual string we use the same logic we use to arrive at a value dp[i][j]



*/


class PrintLongestCommonSubsequence{
    

    public static String  lcs(String s, String t) {
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

        //length of the longest subsequence
        int len = dp[n][m];
        StringBuilder sb= new StringBuilder();
        int i = n;
        int j = m;
        while(i > 0 && j> 0){

                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    sb.append(s.charAt(i - 1));
                    i --;
                    j --;
                }else {
                    if( dp[i][j -1] > dp[i-1][j]){
                        j --;
                    }else{
                        i--;
                    }
                }
            }
            return sb.toString();
        }

    


}