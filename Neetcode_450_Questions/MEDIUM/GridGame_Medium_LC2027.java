package Neetcode_450_Questions.MEDIUM;

/*
https://leetcode.com/problems/grid-game/description/

*/
public class GridGame_Medium_LC2027 {
    class Solution {
        /*
         * [2, 5, 4]
         * [1, 5, 1]
         * move right or down
         * - Observation, If rober 1 switch to row 2 then robber one will utilize what
         * has remaining on row 1
         * - So we can achieve these using prefix sum
         * We calculat the remainder (n - i) if the robber make a switch to row 2
         * And then from 0 to i -> will be also be a candidate for robber 2
         * At every step, we take max of remainder top and first row 2
         * Since we want min of pints the, we keep track of minimun, at end we return
         * minimum points from robber 2
         */
        public long gridGame(int[][] grid) {
            int n = grid[0].length;
            long[] row1PrefixSum = new long[n];
            long[] row2PrefixSum = new long[n];

            // Copy values ton the prefix sum arrays.
            for (int i = 0; i < n; i++) {
                row1PrefixSum[i] = (long) grid[0][i];
                row2PrefixSum[i] = (long) grid[1][i];
            }

            // Calculate prefix sum of the two rows
            for (int i = 1; i < n; i++) {
                row1PrefixSum[i] += row1PrefixSum[i - 1];
                row2PrefixSum[i] += row2PrefixSum[i - 1];
            }
            long minPoints = Long.MAX_VALUE;
            // Iterate and check when robber one can make a switch to row one
            for (int i = 0; i < n; i++) {
                long top = row1PrefixSum[n - 1] - row1PrefixSum[i]; // i -> n-1
                long bottom = (i - 1) >= 0 ? row2PrefixSum[i - 1] : 0; // 0 -> i
                long robber2 = Math.max(top, bottom);
                minPoints = Math.min(robber2, minPoints);
            }
            return minPoints;
        }
    }
}
