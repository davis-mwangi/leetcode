package Neetcode_450_Questions;

/*

https://leetcode.com/problems/arranging-coins/description/

*/
public class ArrangingCoins_Easy_LC441 {

    // Bruteforce
    class Solution1 {
        /*
         * i = 1 4
         * i = 2. 2
         * i = 3.
         * 
         * Time Complexity : ~ O(N)
         * Space Complexity : O(1)
         */
        public int arrangeCoins(int n) {

            int k = 0;
            int coins = n;
            for (int i = 1; i <= n; i++) {
                coins = coins - i;
                if (coins < 0) {
                    break;
                }

                k++;
            }
            return k;

        }
    }

    // Using Gauss Formulae
    class Solution2 {
        /*
         * Gauss Law where if you have numbers 1 to n E.g 1,2,3,4,5,6,7,8,9,10
         * l r l+r =11, l+1(2) + r-1(9) = 11
         * starting from both ends , if we increment left by one, we decrement right by
         * one so sum of left + right remains the same
         * So to sum up all values we can do 10/ 2 = 5 * 10 + 1 => 55
         * In short we can represent our formulae as : (n / 2) * (n + 1) Referred to as
         * Gauss Law
         * 
         * So in our case, we can perform binary search, and on each determine if the
         * sum is less than or equal to our coins
         * 
         * 
         * Time Complexity :  O(log N)
         * Space Complexity : O(1)
         */
        public int arrangeCoins(int n) {
            long left = 1;
            long right = n;

            long max = 0;
            while (left <= right) {
                long mid = left + (right - left) / 2;
                long coins = getCoins(mid);
                if (coins > n) {
                    right = mid - 1;
                } else {// We keep check until we find maximum coins required
                    max = Math.max(max, mid);
                    left = mid + 1;
                }
            }
            return (int) max;

        }

        private long getCoins(long num) {
            return (long) (((double) num / 2.0) * ((double) num + 1.0));
        }
    }

}
