package dynamic_programming_2.dp_on_subsequences;
/*
https://www.codingninjas.com/studio/problems/rod-cutting-problem_800284?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos


*/
import java.util.*;
public class  RodCuttingProblem {
    
    //Recursive Solution
    //SC: O(N * N)
    //TC: O() ~ Exponential
    public class Solution1 {
        public static int cutRod(int price[], int n) {
            // Write your code here.
            int x =  price.length;
            return dfs(x -1, n, price);
        }
        private static int dfs(int i, int N, int [] price){
            //Base Case
            if(i ==0){
                return N * price[0];
            }
            int dontTake =  0 + dfs(i -1, N, price);
            
            int rodLength = i + 1;
    
            int take =  (int)Math.pow(10, 9) * -1;
    
            if(rodLength <= N){
               take = price[i] + dfs(i, N - rodLength, price);
            }
            return Math.max(take, dontTake);
        }
    }
    //Memoized Solution
    //SC: O(N * N) + O(N -1)
    //TC:  O(N * N)
    public class Solution2 {
        public static int cutRod(int price[], int n) {
            // Write your code here.
            int x =  price.length;
            int[][]dp = new int[n][n+1];
            fill(dp, -1);
            return dfs(x -1, n, price,dp);
        }
        private static int dfs(int i, int N, int [] price, int[][]dp){
            //Base Case
            if(i ==0){
                return N * price[0];
            }
            if(dp[i][N] != -1){
                return dp[i][N];
            }
            int dontTake =  0 + dfs(i -1, N, price, dp);
            
            int rodLength = i + 1;
    
            int take =  (int)Math.pow(10, 9) * -1;
    
            if(rodLength <= N){
               take = price[i] + dfs(i, N - rodLength, price, dp);
            }
            return dp[i][N] = Math.max(take, dontTake);
        }
    
        private static void fill(int[][] arr, int val){
            for(int[] a: arr){
                Arrays.fill(a, val);
            }
        }
    }

    //Tabulation
    //SC: O(N * N)
    //TC: O(N)
    public class Solution {
        public static int cutRod(int price[], int n) {
            // Write your code here.
            int[][]dp = new int[n][n+1];
            //Base case
        
            for(int i = 0;  i <= n; i++){
                dp[0][i] = i * price[0];
            }
    
            for(int i = 1; i < n; i++){
                
                for(int N = 0; N <= n; N++){
                    int dontTake =  0 + dp[i -1][N];
            
                    int rodLength = i + 1;
    
                    int take =  (int)Math.pow(10, 9) * -1;
    
                    if(rodLength <= N){
                       take = price[i] + dp[i][N - rodLength];
                    }
    
                    dp[i][N] = Math.max(take, dontTake);
                }
    
            }
            return dp[n -1][n];
        }
    }
}
