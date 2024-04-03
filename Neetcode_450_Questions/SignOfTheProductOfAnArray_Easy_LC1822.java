package Neetcode_450_Questions;

import java.math.BigInteger;

public class SignOfTheProductOfAnArray_Easy_LC1822 {

    // Time Complexity : O(N)
    // Space Complexity : O(1)
    class Solution {
        public int arraySign(int[] nums) {
            // Calculate product sum
            BigInteger sum = new BigInteger(nums[0] + "");
            for (int i = 1; i < nums.length; i++) {
                BigInteger product = sum.multiply(new BigInteger(nums[i] + ""));
                sum = product;
            }
            return signFunc(sum);
        }

        private int signFunc(BigInteger x) {
            if (x.compareTo(new BigInteger("0")) == 1) {
                return 1;
            } else if (x.compareTo(new BigInteger("0")) == -1) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
