package dynamic_programming_2.dp_on_subsequences;
/*
https://www.codingninjas.com/studio/problems/number-of-subsets_3952532?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

1) express in terms of index
2)Explore ways
We use concept of take and not take.
3)return sum of ways (take + dont take)




*/
import java.util.*;
public class CountSubsetsWithSumK {
    
    //Recursive Solution
    //TC: O(2 ^ m *n ) ~ m = target, n = size of arr
    //SC: O(n)
    public class Solution {
        public static int findWays(int num[], int tar) {
            // Write your code here.
            int n = num.length;
            return countWays(n-1, tar, num);
        }
        private static int countWays(int i, int target, int[] num){
            //Base case
            if(target == 0){
                return 1;
            }
            if(i == 0){
                return (num[i] == target) ? 1 : 0;
            }
            //Explore 
            int dontTake = countWays(i - 1, target, num);
            
            int take = 0;
            if(num[i] <= target){
                take = countWays(i - 1, target - num[i], num);
            }
    
            return dontTake + take;
        }
    }

    //Memoized Solution
    //SC: O(n * target) + O(N)=> auxiliary space
    //TC: O(n * target)
    public class Solution2 {
        public static int findWays(int num[], int tar) {
            // Write your code here.
            int n = num.length;
            int [][] dp = new int [n][tar + 1]; // [i, target]
            fill(dp, -1);
            return countWays(n-1, tar, num, dp);
        }
        private static int countWays(int i, int target, int[] num,
         int [][] dp){
            //Base case
            if(target == 0){
                return 1;
            }
            if(i == 0){
                return (num[i] == target) ? 1 : 0;
            }
            if(dp[i][target] != -1){
                return dp[i][target];
            }
            //Explore 
            int dontTake = countWays(i - 1, target, num, dp);
            
            int take = 0;
            if(num[i] <= target){
                take = countWays(i - 1, target - num[i], num, dp);
            }
    
            return dp[i][target] = dontTake + take;
        }
    
        private static void fill(int[][] arr, int val){
            for(int [] a: arr){
                Arrays.fill(a, val);
            }
        }
    }
    //Bottom-up Solution
    //TC: O(n *  target)
    //SP: O(n *  target)
    public class Solution3 {
        public static int findWays(int num[], int tar) {
            // Write your code here.
            int n = num.length;
            int [][] dp = new int [n][tar + 1]; // [i, target]
            
            //Base cases
            for(int i = 0; i < n; i++){
                dp[i][0] = 1;
            }
            if(num[0] <= tar){
               dp[0][ num[0] ] = 1; 
            }
            for(int i = 1; i < n; i++){
    
                for(int t = 0; t <= tar; t++ ){
    
                    int dontTake = dp[i - 1][t];
            
                    int take = 0;
                    if(num[i] <= t){
                        take = dp[i - 1][t - num[i] ];
                    }
    
                    dp[i][t] = dontTake + take; 
                }
            }
            return dp[n-1][tar];
        }
    }
}
