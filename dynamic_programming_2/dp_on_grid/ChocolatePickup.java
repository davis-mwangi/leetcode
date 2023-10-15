package dynamic_programming_2.dp_on_grid;
/*
https://www.codingninjas.com/studio/problems/ninja-and-his-friends_3125885?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

We starting from fixed points and exploring all possible paths
At the end we return the  maximun sum


*/
import java.util.* ;
import java.io.*; 
public class ChocolatePickup {
    
    // Recursive Solution
    // TC: O(3^n * 3^ n)
    // SC: O(n)
    public class Solution {
        public static int maximumChocolates(int r, int c, int[][] grid) {
            // Write your code here.
    
            return dfs(0, 0, c - 1, grid, r, c);
    
        }
        private static int dfs(int r, int cA,int cB, int [][] grid, int rows, int cols){
            //Base cases
            //Out of bounds
            if(cA < 0 || cB < 0 || cA >= cols || cB >= cols){
                //Return a very large number that it will not be considered.
                return ( (int)Math.pow(10, 9) ) * -1;
            }
            //Both Alice and Bob gets to last row of the grid at same time
            if(r ==  rows -1 ){
                //Case where there end up in the same cell
                if(cA == cB){
                    return  grid[r][cA];
                }else{
                    return grid[r][cA] + grid[r][cB];
                }
            }
            //Explore all paths, at one give point we can explore 9 variations,
            //When Alice makes one move, bob can make 3 different moves, likewise,
            //If Bob makes one move, Alice can make 3 moves. thus a combination of 9 moves
            int maxi = ( (int)Math.pow(10, 9) ) * -1;
            for(int dA = -1; dA <= +1; dA++){
                for(int dB = -1; dB <= +1;  dB++){
                    
                    int val = 0;
                    
                    if(cA == cB){//Same cell
                        val = grid[r][cA];
                    }else{
                        val = grid[r][cA] + grid[r][cB];
                    }
                    val += dfs(r + 1, cA +dA, cB + dB, grid, rows, cols);
                    maxi = Math.max(maxi, val);
                }
            }
            return maxi;
    
        }
    }

    //Memoized Solution
    //TC: O(N * M * M) * 9
    //SC: O(N * M * M) + O(N)
    public class Solution2 {
        public static int maximumChocolates(int r, int c, int[][] grid) {
            // Write your code here.
            int[][][] dp = new int[r][c][c];
            fill(dp, -1);
            return dfs(0, 0, c - 1, grid, r, c, dp);
        }
    
        private static int dfs(int r, int cA,int cB, int [][] grid, int rows, int cols,
         int[][][] dp ){
            //Base cases
            //Out of bounds
            if(cA < 0 || cB < 0 || cA >= cols || cB >= cols){
                //Return a very large number that it will not be considered.
                return ( (int)Math.pow(10, 9) ) * -1;
            }
            //Both Alice and Bob gets to last row of the grid at same time
            if(r ==  rows -1 ){
                //Case where there end up in the same cell
                if(cA == cB){
                    return  grid[r][cA];
                }else{
                    return grid[r][cA] + grid[r][cB];
                }
            }
            if(dp[r][cA][cB] != -1){
                return dp[r][cA][cB];
            }
            //Explore all paths, at one give point we can explore 9 variations,
            //When Alice makes one move, bob can make 3 different moves, likewise,
            //If Bob makes one move, Alice can make 3 moves. thus a combination of 9 moves
            int maxi = ( (int)Math.pow(10, 9) ) * -1;
            for(int dA = -1; dA <= +1; dA++){
                for(int dB = -1; dB <= +1;  dB++){
                    
                    int val = 0;
                    
                    if(cA == cB){//Same cell
                        val = grid[r][cA];
                    }else{
                        val = grid[r][cA] + grid[r][cB];
                    }
                    val += dfs(r + 1, cA +dA, cB + dB, grid, rows, cols, dp);
                    maxi = Math.max(maxi, val);
                }
            }
            return dp[r][cA][cB] =  maxi;
        }
        private static void fill(int[][][] arr, int val){
            for(int[][] row: arr){
                for(int[] rowColumn: row){
                    Arrays.fill(rowColumn, val);
                }
            }
        }
    }
}
