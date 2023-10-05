package dynamic_programming_1;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * https://www.codingninjas.com/studio/problem-details/maximum-sum-of-non-adjacent-elements_843261
 * 
 * Source : Coding Ninjas
 * YouTube : https://www.youtube.com/watch?v=GrMBfJNk_NY&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=6 
 */
public class MaximumSumOfAdjacentElements {

    //Recursive Solution
    // Time Complexity: O(2^N)
    // Spae Complexity: O(N)
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
	   return	dfs(nums, nums.size() - 1);

	}
	private static int dfs(ArrayList<Integer>nums, int idx){
		if(idx == 0){
			return nums.get(idx);
		}
		if(idx < 0){
			return 0;
		}

		int pick = nums.get(idx) + dfs(nums, idx - 2);
		int notPick = 0 + dfs(nums, idx - 1);

		return Math.max(pick, notPick);

	}

    //Memoized Solution
    //Time Complexity: O(N) + O(N) ~ O(N)
    //Space Complexity:
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
	   int n =  nums.size();
	   int [] dp = new int[n + 1];
	   Arrays.fill(dp, -1);
	   return	dfs(nums, n - 1, dp);

	}
	private static int dfs(ArrayList<Integer>nums, int idx, int [] dp){


		if(idx == 0){
			return dp[idx]= nums.get(idx);
		}
		if(idx < 0){
			return 0;
		}

		int pick = nums.get(idx) + dfs(nums, idx - 2, dp);
		int notPick = 0 + dfs(nums, idx - 1, dp);

		return dp[idx] = Math.max(pick, notPick);

	}

    //Optimized Tabulation 
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
	   int n =  nums.size();
	   if(n == 0){
		   return 0;
	   }
	   int prev = nums.get(0);
	   int prev2 = 0;

       for(int i = 1; i < n; i++){
		   int pick = nums.get(i);
		   if(i > 1){
			   pick += prev2;
		   }
		   int notPick = 0 +  prev;

		   int curr = Math.max(pick, notPick);
           prev2 = prev;
		   prev =  curr;
	   }
	   return prev;

	}
    
}
