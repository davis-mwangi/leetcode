package dynamic_programming_2.dp_on_grid;
/*
https://www.codingninjas.com/studio/problems/minimum-path-sum_985349?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

We define recurrence relation ,
We start from grid[n-1][m-1] to grid[0,0]
We try out possible ways using recusrion 
Each time we take the minimum if we were to go either right or left untill we get to origin
If we go out of bounds, we return a very high value that it wont be considered.
*/
import java.util.*;
class MinimunPathSum {

     //Recursive solution
     //Time complexity: 2 ^ M * N
     //Space complexity: O(M * N)
    public class Solution {
        public static int minSumPath(int[][] grid) {
            // Write your code here.
            int rows =  grid.length;
            int cols =  grid[0].length;
            return dfs(rows -1, cols -1, grid);
        }
    
        private static int dfs(int r, int c, int[][]grid){
          if(r == 0 && c == 0){
              return grid[r][c];
          }
          if(r < 0 || c < 0){
              return (int)Math.pow(10,9);
          }
          int left = grid[r][c] +   dfs(r, c - 1, grid);
          int up =   grid[r][c]  +  dfs(r - 1, c, grid);
    
          return Math.min(left, up);
        }
    }

    //Memoized Solution
    //Time complexity: O(N * M) + O(M * N) ~ O(M * N)
    //Space Complexity: (M * N)
    public class Solution2 {
        public static int minSumPath(int[][] grid) {
            // Write your code here.
            int rows =  grid.length;
            int cols =  grid[0].length;
            int[][]dp = new int[rows][cols];
            fill(dp, -1);
            return dfs(rows -1, cols -1, grid, dp);
        }
    
        private static int dfs(int r, int c, int[][]grid, int[][]dp){
          if(r == 0 && c == 0){
              return grid[r][c];
          }
          if(r < 0 || c < 0){
              return (int)Math.pow(10,9);
          }
          if(dp[r][c] != -1){
              return dp[r][c];
          }
          int left = grid[r][c] +   dfs(r, c - 1, grid, dp);
          int up =   grid[r][c]  +  dfs(r - 1, c, grid, dp);
    
          return dp[r][c] = Math.min(left, up);
        }
    
        private static void fill(int[][] arr, int val){
            for(int[] a: arr){
                Arrays.fill(a, val);
            }
        }
    }
   //Tabulation
   //Time Complexity: O( N * M)
   //Space Complexity: O(M  * N)
    public class Solution3 {
        public static int minSumPath(int[][] grid) {
            // Write your code here.
            int rows =  grid.length;
            int cols =  grid[0].length;
    
            int[][] dp = new int[rows][cols];
    
            for(int i = 0; i < rows; i++){
               
                for(int j = 0; j < cols; j++){
                    if(i == 0 && j == 0){
                        dp[i][j] = grid[0][0];
                    }else {
                        int left = 0;
                        int up =   0; 
                       
                        if(j > 0){
                            left = grid[i][j] + dp[i][j-1];
                        }else{
                            left = (int) Math.pow(10,9);
                        }
                       
                        if(i > 0){
                            up = grid[i][j] + dp[i -1][j];
                        }else{
                            up  = (int) Math.pow(10, 9);
                        }
    
                        dp[i][j] = Math.min(left, up);
                    }
                }
            }
            return dp[rows -1][cols -1];
            
        }
    
    }
  //Space Optimized Solution
  //Space Complexity: O(M)
  //Time Complexity:  O(M * N)
    public class Solution4 {
        public static int minSumPath(int[][] grid) {
            // Write your code here.
            int rows =  grid.length;
            int cols =  grid[0].length;
    
            int[] prev = new int [cols];
    
            for(int i = 0; i < rows; i++){
                int [] curr = new int[cols];
                for(int j = 0; j < cols; j++){
                    if(i == 0 && j == 0){
                        curr[j] = grid[0][0];
                    }else {
                        int left = 0;
                        int up =   0; 
                       
                        if(j > 0){
                            left = grid[i][j] + curr [j-1];
                        }else{
                            left = (int) Math.pow(10,9);
                        }
                       
                        if(i > 0){
                            up = grid[i][j] + prev[j];
                        }else{
                            up  = (int) Math.pow(10, 9);
                        }
    
                        curr[j] = Math.min(left, up);
                    }
                }
                prev = curr;
            }
            return prev[cols -1];
            
        }
    
    }
}

