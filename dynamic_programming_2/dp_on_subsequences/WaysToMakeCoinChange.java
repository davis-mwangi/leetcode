package dynamic_programming_2.dp_on_subsequences;

/*
https://www.codingninjas.com/studio/problems/ways-to-make-coin-change_630471?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos



*/
public class WaysToMakeCoinChange {

    // Recursive Solution
    //
    public class Solution {

        public static long countWaysToMakeChange(int denominations[], int value) {
            // write your code here
            int n = denominations.length;
            return dfs(n - 1, value, denominations);

        }

        public static int dfs(int i, int target, int[] d) {
            // Base Case
            if (i == 0) {
                if (target % d[0] == 0) {
                    return target / d[0];
                }
                return 0;
            }
            int dontTake = dfs(i - 1, target, d);
            int take = 0;
            // Only take if less or equal to the target
            if (d[i] <= target) {
                take = dfs(i, target - d[i], d);
            }

            return dontTake + take;
        }

    }
}
