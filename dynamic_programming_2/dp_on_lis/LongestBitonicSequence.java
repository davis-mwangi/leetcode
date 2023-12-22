package dynamic_programming_2.dp_on_lis;
/*
Coding Ninjas: https://www.codingninjas.com/studio/problems/longest-bitonic-sequence_1062688?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTabValue=PROBLEM

Bitonic Sequence is a sequence of numbers that is first strictly increasing and then strictly decreasing

A strict acending order sequence is also bitonic with decreasing  order part as empty, and same for a
strictly descending order sequence.

Algorithm:

 We can use  the Longest Increasing Subsequence algorithm to solve this
 - We just mantain two dp arrays one for increasing and another for decreasing
 - Once we compute, we can get the max length as dp1[i] + dp2[i] - 1 since they  both share same values dp[i].
 - Then we finf the maximun length anfd will longest bitonic sequence




*/
import java.util.*;

public class LongestBitonicSequence {


    //TC: O(N * N ) * 2 +O(N) +O(N) ~ O(N^2)
    //SC: O(N) * 2 ~ O(N)
    public class Solution {
        public static int longestBitonicSequence(int[] arr, int n) {
            // Write your code here.
            int [] dp1 = new int[n]; //Hold increasing LIS
            int [] dp2 = new int[n]; //Hold decreasing LDS
    
            Arrays.fill(dp1, 1);
            Arrays.fill(dp2, 1);
    
            //Longest increasing subsequence
            for(int i = 0; i < n; i++){
                for(int prev = 0; prev < i; prev++){
                    
                    if( arr[prev] < arr[i] && (dp1[prev] + 1) > dp1[i] ){
                        dp1[i] = dp1[prev] + 1;
                    }
                }
            }
            //Longest descreasing subsequence
            for(int i = n -1; i >=0; i--){
                for(int prev = n -1; prev > i; prev --){
                    if(arr[i] > arr[prev] && dp2[prev] + 1 > dp2[i]){
                        dp2[i] = dp2[prev] + 1;
                     }
                }
            }
            int maxi = 0;
            for(int i = 0; i < n; i++){
                maxi = Math.max( (dp1[i]+ dp2[i] - 1), maxi);
            }
    
            return maxi;
        }
    }
}
