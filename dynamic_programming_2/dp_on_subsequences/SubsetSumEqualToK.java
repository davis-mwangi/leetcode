package dynamic_programming_2.dp_on_subsequences;

/*

https://www.codingninjas.com/studio/problems/subset-sum-equal-to-k_1550954?leftPanelTab=1%3Fsource%3Dyoutube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

Take U Forward :  DP 14
1) Express in terms of index and target
2) Explore possibilities of that index
 arr[index] part of the subsequence or 
   arr[index] not part of the index
3) return true of false
 */
import java.util.*;

public class SubsetSumEqualToK {
  // Recursive Solution
  // TC: O (2^n)
  // SC: O (N) ~ Auxiliary Space Stack
  static class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]) {
      // Write your code here.
      return dfs(n - 1, k, arr);
    }

    private static boolean dfs(int idx, int target, int[] arr) {
      // Base Case
      if (target == 0) {
        return true;
      }
      // If the remaining target can match the last item int target
      if (idx == 0) {
        if (arr[0] == target) {
          return true;
        } else {
          return false;
        }
      }

      // explore possibilities
      boolean notTake = dfs(idx - 1, target, arr);
      boolean take = false;
      // We only take it if the target is greater or equal to the current value
      if (target >= arr[idx]) {
        take = dfs(idx - 1, target - arr[idx], arr);
      }
      // since we only need one subset/subsequence to ascertain is subset
      return notTake || take;
    }
  }

  // Memoized Solution
  //SC: O(n * target) + O(N) -> Auxiliary Space stack
  //TC: O(N)
  static class Solution2 {
    public static boolean subsetSumToK(int n, int k, int arr[]) {
      // Write your code here.
      int[][] dp = new int[n + 1][k + 1];
      fill(dp, -1);
      return dfs(n - 1, k, arr, dp);
    }

    private static boolean dfs(int idx, int target,
        int[] arr, int[][] dp) {
      // Base Case
      if (target == 0) {
        return true;
      }
      // If the remaining target can match the last item int target
      if (idx == 0) {
        if (arr[0] == target) {
          return true;
        } else {
          return false;
        }
      }
      if (dp[idx][target] != -1) {
        return dp[idx][target] == 1;
      }

      // explore possibilities
      boolean notTake = dfs(idx - 1, target, arr, dp);
      boolean take = false;
      // We only take it if the target is greater or equal to the current value
      if (target >= arr[idx]) {
        take = dfs(idx - 1, target - arr[idx], arr, dp);
      }
      // since we only need one subset/subsequence to ascertain is subset
      boolean res = notTake || take;
      dp[idx][target] = res ? 1 : 0;
      return res;
    }

    private static void fill(int[][] arr, int val) {
      for (int[] a : arr) {
        Arrays.fill(a, val);
      }
    }

  }

  //Bottom-up Solution
  //SC: O(n *  k)
  //TC: O(n *  k)
  static class Solution3 {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
       boolean [][] dp = new boolean [n][k+1];
       //when target is zero, then the  first col with true
       for(int i = 0; i < n; i++){
           dp[i][0] = true;
       }
       if(arr[0] <= k){
            dp[0][arr[0]] = true;
       } 
       for(int i = 1; i < n; i++){
           for(int target = 1; target <= k; target++){
                boolean notTake = dp[i - 1][ target];
                boolean take = false;
                //We only take it if the target is greater or equal to the current value
                if(target >= arr[i]){
                    take = dp[i -1][target - arr[i] ];
                }
                //since we only need one subset/subsequence to ascertain is subset
                dp[i][target] = notTake || take;
            }
       }
       return dp[n -1][k];
    }

}

}
