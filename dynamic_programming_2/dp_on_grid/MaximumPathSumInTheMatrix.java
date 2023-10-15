package dynamic_programming_2.dp_on_grid;
/*
https://www.codingninjas.com/studio/problems/maximum-path-sum-in-the-matrix_797998?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf

Recurrence relation:
up = arr[i][j] + f(i -1, j)
leftDiagonal = arr[i][j] + f(i -1, j -1)
rightDiagonal = arr[i][j] + f( i -1, j +1 )

return max(up, leftDiagnal, rightDiagonal);

Since we dont have a fixed starting point, we execute dfs  from  the
last row for each col, each time we reach the Oth row, we compare
if its maximun, if maximum we update out maximum value.


*/
import java.util.* ;

public class MaximumPathSumInTheMatrix {
    //Recursion - Memoized solution
    public class Solution {

        //Memoized solution 
        //TC : O(n * m) + (m * n)
        //SP : O(m * n)  + O(n)
        public static int getMaxPathSum(int[][] matrix) {
            // Since we can start from any col in the last row
            int rows = matrix.length;
            int cols = matrix[0].length;
    
            int [][] dp = new int[rows][cols];
            fill(dp, -1);
            int maxi = ( (int) Math.pow(10, 9) ) * -1;
    
            for(int  c = cols -1 ; c >= 0; c--){
                int max = dfs(rows -1, c, matrix, rows, cols, dp);
                maxi = Math.max(maxi, max);
            }
            return maxi;
        }
        private static int dfs(int r, int c, int[][]matrix, 
             int rows,int cols, int [][] dp){
            //Base Case
            if(r < 0 || c < 0 || c > cols 
                || r > rows ){
    
                return ( (int) Math.pow(10,9) ) * -1;
            }
            
            if(r == 0){
                return matrix[0][c];
            }
            if(dp[r][c] != -1){
                return dp[r][c];
            }
    
            int up = ( (int) Math.pow(10,9) ) * -1;
            int leftDiag = ( (int) Math.pow(10,9) ) * -1;
            int rightDiag = ( (int) Math.pow(10,9) ) * -1;
            
            if(r > 0){
              up = matrix[r][c] + dfs(r - 1, c, matrix, rows, cols, dp);
            }
            if(r > 0 && c > 0){
              leftDiag = matrix[r][c] + dfs(r - 1, c - 1, matrix, rows, cols, dp);
            }
            if(r > 0 && c < cols - 1 ){
               rightDiag = matrix[r][c] + dfs(r - 1, c + 1, matrix, rows, cols, dp);
            }
    
            return dp[r][c] =  Math.max(rightDiag,  Math.max(up, leftDiag) ); 
    
        }
        private static void fill(int [][] arr, int val){
            for(int [] a : arr){
               Arrays.fill(a, val);
            }
        }
    }
   
    //TC : O(m) + (m * n) + O(m)
    //SP : O(m * n)
    public class Solution2 {
        public static int getMaxPathSum(int[][] matrix) {
            // Since we can start from any col in the last row
            int rows = matrix.length;
            int cols = matrix[0].length;
    
            int [][] dp = new int[rows][cols];
    
            for(int c = 0; c < cols; c ++){
                dp[0][c] =  matrix[0][c];
            }
    
            for(int r = 1; r < rows; r++){
                
                for(int c = 0; c < cols; c++){
                    
                    int up = ( (int) Math.pow(10,9) ) * -1;
                    int leftDiag = ( (int) Math.pow(10,9) ) * -1;
                    int rightDiag = ( (int) Math.pow(10,9) ) * -1;
                    
                    if(r > 0){
                      up = matrix[r][c] + dp[r - 1][c];
                    }
                    if(r > 0 && c > 0){
                      leftDiag = matrix[r][c] + dp[r - 1][c - 1];
                    }
                    if(r > 0 && c < cols - 1 ){
                      rightDiag = matrix[r][c] + dp[r - 1][c + 1];
                    }
    
                    dp[r][c] =  Math.max(rightDiag,  Math.max(up, leftDiag) ); 
    
                }
            }
            int maxi = ( (int) Math.pow(10,9) ) * -1;
            for(int c = 0; c < cols; c ++){
                maxi = Math.max(dp[rows -1][c], maxi);
            }
            return maxi;
        }
    }
}
