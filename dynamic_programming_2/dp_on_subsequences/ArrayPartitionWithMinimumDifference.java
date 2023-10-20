package dynamic_programming_2.dp_on_subsequences;
/*
https://www.codingninjas.com/studio/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum_842494

[3,1,5,2,8]
Min subset diff, we can use the concept of subset 
in this case we consinder the sum of the values
Meaning the subset can fall between 0 ---> sum(A[i])
Since we want comparison two subsetset, if we find a subset of one then the other can be the remainder
from the sum E.g
   0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19
0  T  
1  T
2  T
3  T
4  T T T T T T T T T T  T  T  F T  T  T  T  F  T  T
19 => 3 + 1 + 5 + 2 + 8 => T
18 => 3 +  5+ 2 + 10 => T
17 => No values sum to 17  therefore not possible (F)

This is for one subset for the second subset its much the same in reverse order
subset 1     = 0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19
subset 2     = 19 18 17 16 15 14 13 12 11 10  9  8  7  6  5  4  3  2  1  0
min abs diff = 19 17 15 13 11 9  7   5  3  1  1  3  5  7  9  11 13 15 17 19   
minimum is 11, we dont need even need to traverse the whole arrr, we need just the half of it since 
its the same in reverse.
*/


public class ArrayPartitionWithMinimumDifference {
    public static int minSubsetSumDifference(int []arr, int n) {
        // Write your code here.
        int totalSum = 0;
        for(int i = 0;  i < arr.length; i++){
            totalSum += arr[i];
        }
        int k = totalSum;

        //Subset sum
        boolean [][] dp = new boolean [n][k+1];
        //when target is zero, then the  first col with true
        for(int i = 0; i < n; i++){
            dp[i][0] = true;
        }
        if(arr[0] <= k){
                dp[0][arr[0]] = true;
        } 
        for(int i = 1; i < n; i++){
            for(int target = 1; target <= k; target++){
                    boolean notTake = dp[i - 1][ target];
                    boolean take = false;
                    //We only take it if the target is greater or equal 
                    //to the current value
                    if(target >= arr[i]){
                        take = dp[i -1][target - arr[i] ];
                    }
                    //since we only need one subset/subsequence to ascertain is subset
                    dp[i][target] = notTake || take;
                }
        }

        //Minimun difference arr[n-1][0 ---> totalSum]
        int mini = (int)Math.pow(10,9);
        for(int sum = 0; sum <= totalSum / 2; sum++){
            if(dp[n-1][sum]){
                int min = (totalSum - sum) - sum;
                mini = Math.min( mini, Math.abs(min) );
            }   
        }
        return mini;
    }
}
