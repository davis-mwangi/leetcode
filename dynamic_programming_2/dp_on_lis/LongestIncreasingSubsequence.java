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


  Binary Search Solution
   [1,7,8,4,5,6,,-1,9]
   Naive way is to compare  previous and current ones and form sub-lists
    [1,7,8,9] = len 4
    [1,4,5,6,9] = len 5
    [-1,9] = len 2

    Max is len 5

    A more optmized way  is it the value if not in the list we replace it
    so we use binary search to search for the position to replace
       

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

//---------------------------------------------Memoized Recursive Solution--------------------------------------------------------------------

    // Memoized Solution
    // TC: O(N * N)
    // SC: O(N *N) + O(N)
    public class Solution4 {

        public static int longestIncreasingSubsequence(int arr[]) {
            // Your code goes here
            int n = arr.length;
            int[][] dp = new int[n][n + 1];

            fill(dp, -1);

            return dfs(0, -1, arr, dp);

        }

        private static int dfs(int index, int prevIndex, int[] arr, int[][] dp) {
            // Base case
            if (index == arr.length) {
                return 0;
            }
            if (dp[index][prevIndex + 1] != -1) {
                return dp[index][prevIndex + 1];
            }

            int len = 0 + dfs(index + 1, prevIndex, arr, dp);

            if (prevIndex == -1 || arr[index] > arr[prevIndex]) {
                int take = 1 + dfs(index + 1, index, arr, dp);
                len = Math.max(take, len);
            }

            return dp[index][prevIndex + 1] = len;
        }

        private static void fill(int[][] arr, int val) {
            for (int[] a : arr) {
                Arrays.fill(a, val);
            }
        }

    }
//---------------------------------------------Bottom-Up Solution--------------------------------------------------------------------
       //Top-down approach
    //TC: O(N * N)
    //SC: O(N * N)
    public class Solution3 {

        public static int longestIncreasingSubsequence(int arr[]) {
            //Your code goes here
            int n =  arr.length;
            int[][]dp= new int[n+1][n+1];
            
            for(int  index = n-1; index >=0 ; index--){
    
                for(int prevIndex = index-1; prevIndex>=-1; prevIndex--){
                   
                    int len = 0 +  dp[index + 1][prevIndex +1];
            
                    if(prevIndex == -1 ||  arr[index] > arr[prevIndex] ){
                            int take = 1 + dp[index + 1][index+1];  
                            len =  Math.max(take,len);
                    }
    
                    dp[index][prevIndex +1] = len;
                }
            }
    
            return  dp[0][-1 +1];
    
        }
    
    
    }
//---------------------------------------------LIS Solution using Binary Search--------------------------------------------------------------------
    // Solve using Binary Search
    // TC: O(N * log N)
    // SC: O()
    public static class BinarySearchSolution {
        public int lengthOfLIS(int[] nums) {
            // Your code goes here
            List<Integer> temp = new ArrayList<>();
            int n = 0;
            temp.add(nums[0]);
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] > temp.get(n)) {
                    temp.add(nums[i]);
                    n++;

                } else {// We do binary search and replace
                    int idx = binarySearchNearestIndex(temp, nums[i]);
                    temp.set(idx, nums[i]);
                }
            }
            return n + 1;
        }

        private int binarySearchNearestIndex(List<Integer> list, Integer target) {
            int left = 0;
            int right = list.size() - 1;

            while (left <= right) {

                int mid = left + (right - left) / 2;

                if (list.get(mid) == target) {
                    return mid;

                } else if (target > list.get(mid)) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            // If the target is not found, return the index where the element should be
            // inserted
            return (left > right) ? left : right;
        }
    }

//---------------------------------------------Algorithmic Solution--------------------------------------------------------------------
public class Solution5 {

    //Using Algorithm
	public static int longestIncreasingSubsequence(int arr[]) {
		//Your code goes here
		int n = arr.length;
        int[] dp = new int[n];
		
		Arrays.fill(dp, 1);

		int maxi = 0;
		for(int i = 0; i < n; i++){
			for(int prev = 0; prev < i; prev++){
				if(arr[i] > arr[prev]){
					int newLen =  dp[prev] + 1;
					dp[i] = Math.max(dp[i], newLen);
				}
			}
			maxi = Math.max( dp[i], maxi);
		}
		return  maxi;

	}


}


}
