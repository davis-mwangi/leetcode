package dynamic_programming_2.dp_on_subsequences;

/*
https://www.codingninjas.com/studio/problems/minimum-elements_3843091

We use the concept of take and dont take, unlike other subsequent problems
this one we use a  value multiple items,

So i this , if decide not to take then it will o +  next iteration,
if we decide to pick, we have first ensure what we pick is less or equal to the 
remaiming target.

On the base case, we can do a mod since we only can pick a coin if its
denomination can equate to the remaining target
E.g nums[i] = 4 and target =  12 them count will be 12 / 4 = 3
if its not we retain a larget number that wont be considered.

We then return a min of take or not take it

In case we dont find a target we return -1 

*/
import java.util.*;
public class MinimumElements {

    //TC: O(N *  target) 
    //SC: O(N *  target)+ (N) Auxiliary Space
    public class Solution {
        public static int minimumElements(int num[], int x) {
            // Write your code here..
            int n = num.length;
            int[][] dp = new int[n][x + 1];
            fill(dp, (int) Math.pow(10, 9));
            int ans = dfs(n - 1, num, x, dp);
            if (ans == (int) Math.pow(10, 9)) {
                return -1;
            }
            return ans;

        }

        private static int dfs(int i, int[] nums, int target, int[][] dp) {
            // Base case
            if (i == 0) {
                if (target % nums[0] == 0) {
                    return target / nums[0];
                } else {
                    return (int) Math.pow(10, 9);
                }
            }

            if (dp[i][target] == -1) {
                return dp[i][target];
            }

            // Explore paths
            int dontTake = 0 + dfs(i - 1, nums, target, dp);

            int take = (int) Math.pow(10, 9);
            if (nums[i] <= target) {
                take = 1 + dfs(i, nums, target - nums[i], dp);
            }
            return dp[i][target] = Math.min(take, dontTake);
        }

        private static void fill(int[][] arr, int val) {
            for (int[] a : arr) {
                Arrays.fill(a, val);
            }
        }

    }

    public class Solution2 {
        public static int minimumElements(int num[], int x) {
            // Write your code here..
            int n = num.length;
            int [][] dp = new int [n][x+1];
            //Base case
            for(int t = 0; t <= x; t++){
               if(t % num[0] == 0){
                  dp[0][t] = t / num[0];
               }else{
                   dp[0][t] = (int)Math.pow(10, 9);
               } 
            } 
            for(int i = 1; i < n; i++){
                for(int t = 0; t <= x; t++){
                    int dontTake = 0  + dp[i - 1][t];
    
                    int take = (int) Math.pow(10, 9);
                    if(num[i] <= t){
                        take = 1 + dp[i][t - num[i] ];
                    }
                    dp[i][t] = Math.min(take, dontTake);
                }
            }
            int ans =  dp[n -1][x];
            if( ans == (int) Math.pow(10, 9) ){
                return -1;
            }
            return ans;
    
        }
}
