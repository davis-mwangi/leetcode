package dynamic_programming_2.dp_on_grid;
/*
Problem: https://www.codingninjas.com/studio/problems/maze-obstacles_977241?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

YouTube: https://www.youtube.com/watch?v=TmhpgXScLyY&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=10
*/
import java.util.*;
public class UniquePathsII {

    //Recursive Solution without Memoization
    //Time Complexity: O(2 ^ m *n )
    //Space Complexity: (m * n)
    public class Solution {
        private static int MODULAR = ((int) Math.pow(10, 9)) + 7;
    
        public static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
            // Write your code here.
            return dfs(n-1, m-1,mat);
        }
        private static int dfs(int r, int c, ArrayList<ArrayList<Integer>> mat){
            //Base case
            if(r >= 0 && c >= 0 && mat.get(r).get(c) == -1){
                return 0;
            }
            if(r == 0 && c == 0){
                return 1;
            }
            if(r < 0 || c < 0){
                return 0;
            }
    
            int left = dfs(r,  c -1, mat);
            int up =   dfs(r -1, c, mat);
    
            return (left + up) % MODULAR;
        }
    
    }
    // Memoized Solution
    // Time Complexity: O(N * M) + O(M * N)
    // Space Complexity: O(N * M)
    public class Solution2 {
        private static int MODULAR = ((int) Math.pow(10, 9)) + 7;
    
        public static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
            // Write your code here.
            int[][]dp = new int[n][m];
            fill(dp, -1);
            return dfs(n-1, m-1,mat, dp);
        }
        private static int dfs(int r, int c, ArrayList<ArrayList<Integer>> mat, int[][]dp){
            //Base case
            if(r >= 0 && c >= 0 && mat.get(r).get(c) == -1){
                return 0;
            }
            if(r == 0 && c == 0){
                return 1;
            }
            if(r < 0 || c < 0){
                return 0;
            }
            if(dp[r][c] != -1){
                return dp[r][c];
            }
    
            int left = dfs(r,  c -1, mat, dp);
            int up =   dfs(r -1, c, mat, dp);
    
            return dp[r][c] = (left + up) % MODULAR;
        }
        private static void fill(int[][]arr, int val){
            for(int [] a: arr){
                Arrays.fill(a, val);
            }
        }
    
    }

    //Tabulation (Bottom-Up)
    //Time Complexity:  O(N * M)
    //Space Complexity: O(N * M)
    public class Solution3 {
        private static int MODULAR = ((int) Math.pow(10, 9)) + 7;
    
        public static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
            // Write your code here.
            int[][]dp = new int[n][m];
            dp[0][0] = 1;
            for(int i = 0; i < n; i++){
                
                for(int j = 0; j< m;j++){
                     if(i == 0 && j ==0){
                         continue;
                     }else if(mat.get(i).get(j) == -1){
                        dp[i][j] = 0;
                     
                     }else{
                         int left = 0;
                         int up = 0;
                        
                         if(j > 0){
                            left = dp[i][j -1];
                         }
    
                         if(i > 0){
                             up = dp[i-1][j];
                         }
    
                         dp[i][j] = (left + up) % MODULAR;
                     }
    
                }
            }
            return dp[n-1][m-1];
        }
    }

    //Space Optimized
    //Time Complexity: O(N  * M)
    //Space Complexity: O(M)
    public class Solution4 {
        private static int MODULAR = ((int) Math.pow(10, 9)) + 7;
    
        public static int mazeObstacles(int n, int m, ArrayList<ArrayList<Integer>> mat) {
            // Write your code here.
            int[]prev = new int[m];
            // prev[0] = 1;
            for(int i = 0; i < n; i++){
               
                int[] curr = new int[m];
                
                for(int j = 0; j< m;j++){
                     if(i == 0 && j ==0){
                         curr[j] = 1;
                     }else if(mat.get(i).get(j) == -1){
                        curr[j] = 0;
                     
                     }else{
                         int left = 0;
                         int up = 0;
                        
                         if(j > 0){
                            left = curr[j -1];
                         }
    
                         if(i > 0){
                             up = prev[j];
                         }
    
                         curr[j] = (left + up) % MODULAR;
                     }
                }
                prev = curr;
            }
            return prev[m-1];
        }
    }
    
    
}
