package Neetcode_450_Questions;

/*
 * 
 * https://leetcode.com/problems/sqrtx/description/
 */
public class Sqrt_x__Easy_LC69 {
    class Solution {
        /*
         * x = 4
         * 
         * 1......2......4
         * 
         */
        public int mySqrt(int x) {
            long l = 0L;
            long r = (long) x;
            long min = Long.MAX_VALUE;
            while (l <= r) {
                long mid = l + (r - l) / 2L;
                long sqr = (mid * mid);

                if (sqr == x) {
                    return (int) mid;
                } else if (sqr > x) {
                    r = mid - 1L;
                } else {
                    min = mid;
                    l = mid + 1L;
                }
            }
            return (int) min;

        }
    }
}
