package dynamic_programming_2.do_on_squares;
/*
Leetcode: https://leetcode.com/problems/count-square-submatrices-with-all-ones/description/
Dp 56: https://www.youtube.com/watch?v=auS1fynpnjo&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=57


*/
public class CountSquareSubmatricesWithAllOnes {
    class Solution {
        public int countSquares(int[][] matrix) {
            int rows = matrix.length;
            int cols = matrix[0].length;
    
            int[][] dp = new int[rows][cols];
    
            //fill in the first column and row
            for(int  r = 0; r < rows; r++){
                dp[r][0] = matrix[r][0];
            }
    
            for(int c = 0; c < cols; c++){
                dp[0][c] = matrix[0][c];
            }
    
            //Calculate squares per given position. dp[i][j] = max( dp[i][j-1], dp[i -1][j -1], dp[i-1][j])  
            for(int i =1; i <  rows; i++){
                for(int j =1; j < cols; j++){
                    if(matrix[i][j] == 1){
                        dp[i][j] = (Math.min( dp[i-1][j-1] ,  Math.min( dp[i -1][j], dp[i][j-1] ) ) ) + 1;
                    }else{
                        dp[i][j] = 0;
                    }
                }
            }  
    
            int sum = 0;
            for(int i = 0; i < rows; i++){
                for(int j =0; j< cols; j++){
                   sum +=  dp[i][j]; 
                }
            }  
            return sum;  
        }
    }
}
