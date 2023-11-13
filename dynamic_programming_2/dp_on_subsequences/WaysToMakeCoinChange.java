package dynamic_programming_2.dp_on_subsequences;

/*
https://www.codingninjas.com/studio/problems/ways-to-make-coin-change_630471?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos



*/
import java.util.*;
public class WaysToMakeCoinChange {

    // Recursive Solution
    // TC: >>O(2 ^ T) where T = target
    // SC: >> O(T)
    public class Solution {

        public static long countWaysToMakeChange(int denominations[], int value){
            //write your code here
            int n = denominations.length;		
            return dfs(n -1, value, denominations);
    
        }
        public static int dfs(int i, int target, int [] d){
            //Base Case
            if(target < 0){
                return 0;
            }
            if(i == 0){
                return (target % d[0]== 0) ? 1  : 0;
            }
            int dontTake = dfs(i -1, target, d);
        
            int take  = 0;
            //Only take if less or equal to the target
            if(d[i] <= target){
                take  = dfs(i, target - d[i], d);
            }
    
            return dontTake + take;
        }
        
    }
    //Memoized Solution
    //TC: O(N * target) + O(T)
    //SC: O(N *  target) +  O(target)//Auxilliary stack space
    public class Solution2 {

        public static long countWaysToMakeChange(int denominations[], int value){
            //write your code here
            int n = denominations.length;
            int t = value;
            long[][] dp = new long[n][t + 1];	
            fill(dp, -1);	
    
            return dfs(n -1, t, denominations, dp);
    
        }
        public static long dfs(int i, int target, int[]d, long[][] dp){
            //Base Case
            if(target < 0){
                return 0;
            }
            if(i == 0){
                return (target % d[0]== 0) ? 1L  : 0L;
            }
            if(dp[i][target] != -1L){
                return dp[i][target];
            }
            long dontTake = dfs(i -1, target, d, dp);
        
            long take  = 0;
            //Only take if less or equal to the target
            if(d[i] <= target){
                take  = dfs(i, target - d[i], d, dp);
            }
    
            return dp[i][target] = dontTake + take;
        }
    
        private static void fill( long[][]arr, long val){
            for(long[] a: arr){
                Arrays.fill(a, val);
            }
        }
        
    }

    //Tabulation 
    //SC: O(N * Target)
    //TC:  O(N * target)
    public class Solution3 {

        public static long countWaysToMakeChange(int denominations[], int value){
            //write your code here
            int n = denominations.length;
            long[][] dp = new long[n][value + 1];	
    
            //Base Case
            for(int t = 0; t  <= value; t++){
                dp[0][t] = (t % denominations[0]== 0) ? 1L  : 0L;
            }
            for(int  i = 1; i < n ; i++){
                for(int t = 0;  t <= value; t++){
                    long dontTake = dp[i -1][t];
        
                    long take  = 0;
                    //Only take if less or equal to the target
                    if(denominations[i] <= t){
                        take  = dp[i][ t - denominations[i] ];
                    }
                    dp[i][t] = dontTake + take;
                }
            }
            return dp[n-1][value];
    
        }
        
    }

    //Space Optmized
    //SC: O(target)
    //TC: O(N * target)
    public class Solution4 {

        public static long countWaysToMakeChange(int denominations[], int value){
            //write your code here
            int n = denominations.length;
            long[] prev = new long [value + 1];	
    
            //Base Case
            for(int t = 0; t  <= value; t++){
                prev[t] = (t % denominations[0]== 0) ? 1L  : 0L;
            }
            for(int  i = 1; i < n ; i++){
                long [] curr = new long [value +1];
                for(int t = 0;  t <= value; t++){
                    
                    long dontTake = prev[t];
        
                    long take  = 0;
                    //Only take if less or equal to the target
                    if(denominations[i] <= t){
                        take  = curr[ t - denominations[i] ];
                    }
                    curr[t] = dontTake + take;
                }
                prev =  curr;
            }
            return prev[value];
    
        }
        
    }
}
