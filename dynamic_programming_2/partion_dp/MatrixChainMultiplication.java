package dynamic_programming_2.partion_dp;

/*
Coding Ninjas: https://www.codingninjas.com/studio/problems/matrix-chain-multiplication_975344?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
DP 48 : Take U forward
YouTube: https://www.youtube.com/watch?v=vRVfmbCFW7Y&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=49

Algorithm:
   -  Start with entire block or array , express in terms of (i, j)
   - Try all partitions => run a  loop to try all partitons
   - Return  the best possible 2 partitions

   ith = A[i -1] * A[i]
        i           j
    0   1   2   3   4
   [10, 20, 30, 40, 50]
        A   B    C  D
   Return the minimum multiplications to multiply  matrix 1  -> matrix x  
      func (1, 4) => f(1, n -1)

    k = (i -> j-1) 
    k = f(i, k), f(k+1, j)

    k2 = f()
    

*/
import java.util.* ;

public class MatrixChainMultiplication {


    //TC: O(N * N) *  ~(N) => O(N^3)
    //SC:  O(N * N)
    public class Solution {
        public static int matrixMultiplication(int[] arr, int N) {

            // Write your code here
            int[][] dp = new int[N][N];
            fill(dp, -1);
            return f(1, N - 1, arr, dp);
        }

        private static int f(int i, int j, int[] arr, int[][] dp) {
            if (i == j) {// Equal block
                return 0;
            }

            if (dp[i][j] != -1) {
                return dp[i][j];
            }

            int min = (int) Math.pow(10, 9);

            for (int k = i; k < j; k++) {

                int steps = arr[i - 1] * arr[k] * arr[j] +
                        f(i, k, arr, dp) + f(k + 1, j, arr, dp);

                if (steps < min) {
                    min = steps;
                }
            }
            return dp[i][j] = min;
        }

        private static void fill(int[][] arr, int val) {
            for (int[] a : arr) {
                Arrays.fill(a, val);
            }
        }
    }
}
