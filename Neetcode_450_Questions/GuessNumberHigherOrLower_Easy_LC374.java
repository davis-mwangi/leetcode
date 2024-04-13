package Neetcode_450_Questions;

/*
https://leetcode.com/problems/guess-number-higher-or-lower/description/

*/
public class GuessNumberHigherOrLower_Easy_LC374 {
    /**
     * Forward declaration of guess API.
     * 
     * @param num your guess
     * @return -1 if num is higher than the picked number
     *         1 if num is lower than the picked number
     *         otherwise return 0
     *         int guess(int num);
     * 
     *         1 --- > N ordered
     *         1,2,3,4,5,6,7,8,9, 10
     * 
     * 
     * Time Complexity : O(log N)
     * Space Complexity : O(1)
     */

    public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int l = 1;
            int r = n;

            while (l <= r) {
                int mid = l + (r - l) / 2;
                int guess = guess(mid);
                if (guess == 0) {
                    return mid;
                } else if (guess == -1) {
                    r = mid - 1;
                } else if (guess == 1) {
                    l = mid + 1;
                }
            }
            return 0;
        }

    }

    class GuessGame {
        public int guess(int num) {
            int random = getRandomNumber(1, 100);
            if (num > random) {
                return -1;
            } else if (num < random) {
                return 1;
            } else {
                return 0;
            }
        }

        public int getRandomNumber(int min, int max) {
            return (int) ((Math.random() * (max - min)) + min);
        }
    }
}
