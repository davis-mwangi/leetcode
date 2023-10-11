package dynamic_programming_2.dp_on_grid;

import java.util.Arrays;

/*
https://www.codingninjas.com/studio/problems/triangle_1229398?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

1
2, 3
3, 6, 7
8, 9, 6, 10

We first solve this using recusion and to determine recurrence relation
Since we dont have a fixed end we will start with the first row first and move
either downwards or diagnal untill we get to the end low, each time we will find the
minimun path sum from either "down" or "diagonal"

For recusrion at no point will run out of bounds since at any given position,
we are adding either 1 to row or col, and time we get to last row will stop.
*/
public class Triangle {
    // Time Complexity: O(2 ^ n * m)
    // Space Complexity: (m * n)
    public class Solution {
        public static int minimumPathSum(int[][] triangle, int n) {
            // Write your code here.
            return dfs(0, 0, triangle, n);
        }

        private static int dfs(int r, int c, int[][] t, int n) {
            // Base Case
            if (r == (n - 1)) {
                return t[r][c];
            }

            int down = t[r][c] + dfs(r + 1, c, t, n);
            int diagonal = t[r][c] + dfs(r + 1, c + 1, t, n);

            return Math.min(down, diagonal);
        }

    }

    // Memoized Solution
    // Space Complexity: O(M * N)
    // Time Complexity: O(M * N)
    public class Solution2 {
        public static int minimumPathSum(int[][] triangle, int n) {
            // Write your code here.
            int[][] dp = new int[n][n];
            fill(dp, -1);
            return dfs(0, 0, triangle, n, dp);
        }

        private static int dfs(int r, int c, int[][] t, int n, int[][] dp) {
            // Base Case
            if (r == (n - 1)) {
                return t[r][c];
            }
            if (dp[r][c] != -1) {
                return dp[r][c];
            }

            int down = t[r][c] + dfs(r + 1, c, t, n, dp);
            int diagonal = t[r][c] + dfs(r + 1, c + 1, t, n, dp);

            return dp[r][c] = Math.min(down, diagonal);
        }

        private static void fill(int[][] arr, int val) {
            for (int[] a : arr) {
                Arrays.fill(a, val);
            }
        }

    }

    // Tabulation
    // Time Complexity: O(N)
    // Space Complexity: O(N * N)
    public static class Solution3 {
        public static int minimumPathSum(int[][] triangle, int n) {
            // Write your code here.
            int[][] dp = new int[n][n];

            // Populate base case, starting from the last column
            for (int c = 0; c < triangle[n - 1].length; c++) {
                dp[n - 1][c] = triangle[n - 1][c];
            }

            // Iterate through the triangle
            for (int r = n - 2; r >= 0; r--) {
                for (int c = r; c >= 0; c--) {
                    int up = triangle[r][c] + dp[r + 1][c];
                    int diagonal = triangle[r][c] + dp[r + 1][c + 1];

                    int min = Math.min(up, diagonal);
                    dp[r][c] = min;
                }

            }
            return dp[0][0];

        }
    }

    public class Solution4 {

        public static int minimumPathSum(int[][] triangle, int n) {
            // Write your code here.
            int[] prev = new int [n];
    
           // Populate base case, starting from the last column
            for(int c = 0; c < triangle[n-1].length;c++){
                prev[c] = triangle[n-1][c];
            }
    
            //Iterate through the triangle
            for(int r = n -2; r >= 0; r--){
                int[] curr =  new int[n];
                for(int c = r; c >= 0; c--){
                  int up = triangle[r][c] + prev[c];
                  int diagonal = triangle[r][c] + prev[c + 1];
    
                  int min = Math.min(up, diagonal);
                  curr[c] = min;
                }
                prev =  curr;
    
            }
            return prev[0];
            
        }
    }


}
