package dynamic_programming_1;

/*
 https://www.codingninjas.com/studio/problems/frog-jump_3621012


 
 */
import java.util.* ;
import java.io.*; 
public class FrogJump {

    //Recursive Solution
    //Time Complexity: O(2^ N)
    //Space Complexity: O (N)
    public static int frogJump(int n, int heights[]) {
        return dfs(n-1, heights);
     }
 
      public static int dfs(int i, int heights[]) {
        //Base Case
        if(i == 0){
            return 0;
        }
      
         int left = dfs(i - 1, heights) + Math.abs(heights[i] - heights[i -1]);
 
         int right = Integer.MAX_VALUE;
         if(i > 1){
             right = dfs(i - 2, heights) + Math.abs(heights[i] -  heights[i - 2]);
         }
 
         return Math.min(left, right);
        
     }

     //Memoized Solution
     //Time Complexity: O(N)
     //Space Complexity: O(N)
     //Top-Down Approach
     public static int frogJump(int n, int heights[]) {
        int[] dp =  new int[n+1];
        Arrays.fill(dp, -1);
        return dfs(n-1, heights, dp);
     }
 
      public static int dfs(int i, int[] heights,int[] dp) {
        
 
        //Base Case
        if(i == 0){
            return 0;
        }
 
         if(dp[i] != -1){
             return dp[i];
         }
      
         int left = dfs(i - 1, heights, dp) + Math.abs(heights[i] - heights[i -1]);
 
         int right = Integer.MAX_VALUE;
         if(i > 1){
             right = dfs(i - 2, heights, dp) + Math.abs(heights[i] -  heights[i - 2]);
         }
 
         int res = dp[i] = Math.min(left, right);
        
         return res;
        
     }

     //Bottom Up Approach
     //Time Complxity: O(N)
     //Space Complexity: O(N)
     public static int frogJump(int n, int heights[]) {
        int[] dp =  new int[n+1];
        dp[0] = 0;
       
        for(int i = 1; i < n; i++){
            int left =  dp[i-1] + Math.abs(heights[i] - heights[i - 1]);
            int right= Integer.MAX_VALUE;
            if(i > 1){
                right =  dp[i-2] + Math.abs(heights[i] - heights[i -2]); 
            }
            dp[i] = Math.min(left, right);
        }
        return dp[n-1];
        
     }

     //Optimized Tabulation(1 Dp)
     public static int frogJump(int n, int heights[]) {
        int prev  = 0;
        int prev2 = 0;
       
        for(int i = 1; i < n; i++){
            int left =  prev + Math.abs(heights[i] - heights[i - 1]);
            int right= Integer.MAX_VALUE;
            if(i > 1){
                right =  prev2 + Math.abs(heights[i] - heights[i -2]); 
            }
             prev2 =  prev;
             prev = Math.min(left, right);
        }
        return prev;
        
     }

}