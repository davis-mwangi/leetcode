package dynamic_programming_2.dp_on_lis;

/*
Coding Ninjas:  https://www.codingninjas.com/studio/problems/longest-increasing-subsequence_630459?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
LeetCode: https://leetcode.com/problems/longest-increasing-subsequence/
Take You Forward: DP 41. Longest Increasing Subsequence | Memoization

Algorithm:
   1) Express our function in terms iof index and previous index
   2) explore all possible ways
      - We can have prev index as -1, so can decide to take it or not take, If we take in the next call we have to check 
      if the value is greater than previous since we want increasing subsequence
   3)  Return max of both take or non-take
   4) Write base case

*/
import java.util.*;

public class LongestIncreasingSubsequence {

    // Recusrive Solution
    // TC: O(2^N)
    // SC: O(N) auxiliary stack space
    public class Solution1 {

        public static int longestIncreasingSubsequence(int arr[]) {
            // Your code goes here
            return dfs(0, -1, arr);

        }

        private static int dfs(int index, int prevIndex, int[] arr) {
            // Base case
            if (index == arr.length) {
                return 0;
            }

            int len = 0 + dfs(index + 1, prevIndex, arr);
            ;

            if (prevIndex == -1 || arr[index] > arr[prevIndex]) {
                int take = 1 + dfs(index + 1, index, arr);
                len = Math.max(take, len);
            }

            return len;
        }

    }
    //Memoized Solution
    //TC: O(N * N)
    //SC: O(N *N) + O(N)
    public class Solution {

        public static int longestIncreasingSubsequence(int arr[]) {
            //Your code goes here
            int n =  arr.length;
            int[][]dp= new int[n][n+1];
            
            fill(dp, -1);
    
            return  dfs(0, -1, arr, dp);
    
        }
        private static int dfs(int index, int prevIndex, int[] arr, int[][]dp ){
            //Base case
            if(index == arr.length){
                return 0;
            }
            if(dp[index][prevIndex +1] != -1){
                return dp[index][prevIndex +1];
            }
    
            int len = 0 +  dfs(index + 1, prevIndex, arr,dp);
            
            if(prevIndex == -1 ||  arr[index] > arr[prevIndex] ){
                int take = 1 + dfs(index + 1, index, arr, dp);  
                len =  Math.max(take,len);
            }
    
            return dp[index][prevIndex +1] = len;
        }
    
        private static void fill(int[][]arr, int val){
            for(int[] a: arr){
                Arrays.fill(a, val);
            }
        }
    
    }
}
