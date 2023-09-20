package dynamic_programming_1;
/*
 * https://leetcode.com/problems/climbing-stairs/submissions/
 * 
 * Approach:
 * We can  move either 1 step or 2 steps
 * at  0  = stairs, we can only move 1 way , i.e nothing
 * at  1 = stairs, we can only move 1 way i.e climb 1 step
 * at  2 = stairs, we can only move 2 ways  1 step + 1 step or 2 steps
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
