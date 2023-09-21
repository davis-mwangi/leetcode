package dynamic_programming_1;

/*
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 * 
 * Approach:
 * [10,15,20] 0
 *  0  1  2   3
 * 
 * We calculate the min cost until it get out of bound
 * So we  assume the value n + 1 will be zero.
 * Since we can only move 1 step or 2 steps  and we can start 
 * at zero or one, we iterate from  right to left(in reverse)
 * at every cost[i]  we conside minimun of cost[-1], cost[-2]
 * 
 * At the end we return min of the first and second, 
 * i.e eeither we start from 0 or right.
 * 
 * Time Compleexity: O(2 ^n)
 * Space Complexity = O(n)
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int one = 0;
        int two = 0;

        for (int i = cost.length - 1; i >= 0; i--) {
            cost[i] += Math.min(one, two);
            two = one;
            one = cost[i];
        }

        return Math.min(cost[0], cost[1]);
    }
}
