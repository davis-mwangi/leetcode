package dynamic_programming_2.dp_on_subsequences;
/*
https://www.codingninjas.com/studio/problems/0-1-knapsack_920542?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
W = 5
Wi= [3,  2,  5]
Pi =[40, 30, 50]


*/
import java.util.*;

public class O_1_Knapsack {
    //Memoized Solution
    //TC: O(N * weight)
    //SC: O(N * weight) + O(N)
    public class Solution{
        static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
           int[][]dp = new int[n][maxWeight + 1];
           fill(dp, -1);
           return dfs(n - 1, maxWeight,weight, value, dp);
        }
        private static int dfs(int idx, int maxWeight, int[] w, int[] v,
        int[][]dp){
          //Base case
          if(idx == 0){
              //two cases either we pick the item if less than remaining weight or not pick it
              if(maxWeight >= w[0]){
                  return v[0];
              }else{
                  return 0;
              }
          }
          if(dp[idx][maxWeight] != -1){
              return dp[idx][maxWeight];
          }
    
          //Explore all paths
    
          //Dont take
          int dontTake = 0 + dfs(idx - 1, maxWeight, w, v, dp);
          //take
          int take = (int) Math.pow(10,9) * -1;
          if(maxWeight >= w[idx] ){
              take = v[idx] + dfs(idx -1, maxWeight - w[idx] , w, v, dp);
          }
          //return Max
          return  dp[idx][maxWeight] = Math.max(dontTake, take);
        }
        private static void fill(int[][] arr,int val){
            for(int[] a: arr){
                Arrays.fill(a, val);
            }
        }
    }

    //Tabulation (Bottom-up)
    //TC: O(N * maxHeight)
    //SC: O(N * maxHeight)
    public class Solution2 {
        static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
           int[][]dp = new int[n][maxWeight + 1];
           
           for(int w = weight[0]; w <= maxWeight;  w++){
               dp[0][w] = value[0];
           }
           for(int idx = 1;  idx < n; idx++){
               for(int w = 0; w <= maxWeight; w++){
                   int dontTake = 0 + dp[idx - 1][w];
                    //take
                    int take = (int) Math.pow(10,9) * -1;
                    if(w >= weight[idx] ){
                        take = value[idx] + dp[idx -1][w - weight[idx] ];
                    }
                    
                    dp[idx][w] = Math.max(dontTake, take);
               }
           }
    
    
           return dp[n - 1][maxWeight];
        }
    
    }
    //Space Optimized
    //TC: O(N *  maxHeight)
    //SC: O(maxHeight)
    public class Solution3 {
        static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
           int[]prev = new int [maxWeight + 1];
           
           for(int w = weight[0]; w <= maxWeight;  w++){
               prev[w] = value[0];
           }
           for(int idx = 1;  idx < n; idx++){
               int[] curr = new int [maxWeight + 1];
    
               for(int w = 0; w <= maxWeight; w++){
    
                   int dontTake = 0 + prev[w];
                    //take
                    int take = (int) Math.pow(10,9) * -1;
                    if(w >= weight[idx] ){
                        take = value[idx] + prev[w - weight[idx] ];
                    }
                    
                    curr[w] = Math.max(dontTake, take);
               }
               prev = curr;
           }
    
    
           return prev[maxWeight];
        }
    
    }
}
