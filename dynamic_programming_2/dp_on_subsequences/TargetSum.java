package dynamic_programming_2.dp_on_subsequences;
/*
https://www.codingninjas.com/studio/problems/target-sum_4127362?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0


Same approach as Count partitions


*/

import java.util.*;

public class TargetSum {
    public class Solution {
        public static int targetSum(int n, int target, int[] arr) {
            // Write your code here.
            return countPartitions(n, target, arr);
        }
    
        public static int countPartitions(int n, int d, int[] arr) {
                // Write your code here.
                int totalSum = 0;
                for(int num:  arr){
                    totalSum +=  num;
                }
                //Checks
                if( (totalSum - d) < 0 || (totalSum - d) % 2 != 0){
                    return 0;
                }
                int target = (totalSum - d) / 2;
                return findWays(arr,target);
        
        }
        
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
        
                    if(i == 0){
                        //If there the value at arr[0] is zero, then we have 2 cases, we can either
                        //take it or not  thus should return 2
                        if(target == 0 && num[0]== 0){
                            return 2;
                        }
                        //But if the value of arr[0] is not zero, then we only have one
                        //way, to take it only thus should return 1
                        if(target == 0 ||  num[0] == target){
                            return 1;
                        }
                        return 0;
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
            
                    return dp[i][target] = (dontTake + take);
            }
            
        private static void fill(int[][] arr, int val){
            for(int [] a: arr){
                Arrays.fill(a, val);
            }
        }
            
        
    }
}
