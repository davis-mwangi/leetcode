package dynamic_programming_2.dp_on_grid;

/*
https://www.codingninjas.com/studio/problems/total-unique-paths_1081470?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

Rules to  determine recurrence relation:
!) Express  array interms of i and j  i.e i => rows and j => columns
2)Explore/ Do all stuffs
3) Sum up all ways | (max | min) 

Tabulation Rules:
1) Declare abse case
2) Express all states in function loop
3) Copy the recurrence relation
*/
import java.util.*;
import java.io.*;

public class UniquePaths {

    // Top-Down
    // Time Complexity: O(N * M)
    // Space Complexity: O(n-1 + m -1) + O(N * M)
    public class Solution {
        // Recursive solution :
        // Tc: O(2 ^ n +m)
        // SC: O(n * m)
        public static int uniquePaths(int m, int n) {
            // Write your code here.
            return dfs(m - 1, n - 1);
        }

        private static int dfs(int r, int c) {
            if (r == 0 && c == 0) {
                return 1;
            }
            if (r < 0 || c < 0) {
                return 0;
            }
            int left = dfs(r, c - 1);
            int up = dfs(r - 1, c);

            return left + up;
        }

        // Memoized Solution
        public static int uniquePaths2(int m, int n) {
            // Write your code here.
            int[][] dp = new int[m][n];
            fill(dp, -1);
            return dfs(m - 1, n - 1, dp);
        }

        private static int dfs(int r, int c, int[][] dp) {
            if (r == 0 && c == 0) {
                return 1;
            }
            if (r < 0 || c < 0) {
                return 0;
            }
            if (dp[r][c] != -1) {
                return dp[r][c];
            }
            int left = dfs(r, c - 1, dp);
            int up = dfs(r - 1, c, dp);

            return dp[r][c] = left + up;
        }

        private static void fill(int[][] arr, int val) {
            for (int[] r : arr) {
                Arrays.fill(r, val);
            }
        }
    }

    // Bottom-Up
    public class Solution2 {
        //Tabulation : 
        //Time Complexity:  O(N * M)
        //Space Complexity: O(N * M)
        public static int uniquePaths(int m, int n) {
            // Write your code here.
            int[][] dp = new int[m][n];
            dp[0][0] = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == 0 && i == 0) {
                        continue;
                    }
                    int left = (j - 1) >= 0 ? dp[i][j - 1] : 0;
                    int up = (i - 1) >= 0 ? dp[i - 1][j] : 0;
                    dp[i][j] = left + up;
                }
            }
            return dp[m - 1][n - 1];
        }
        //Space Optimization
        //Time Complexity: O(N * M)
        //Space Complexity: O(N)
        public static int uniquePaths2(int m, int n) {
            // Write your code here.
            int[] prev = new int [n];
        
            for(int i = 0; i < m; i++){
                int[]curr = new int[n];
                for(int j = 0; j < n; j++){
                    if(j == 0 && i==0){
                        curr[j] = 1;
                        continue;
                    }
                    int left = 0;
                    int up   = 0;
                    if(j > 0){
                        left = curr [j -1];
                    }
                    if(i > 0){
                        up = prev[j];
                    }				
                    curr[j] = left + up;
                }
                prev = curr;
            }
            return prev[n-1];
        }
    }

}
