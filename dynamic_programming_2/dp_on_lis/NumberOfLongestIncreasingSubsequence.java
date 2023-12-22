package dynamic_programming_2.dp_on_lis;
/*
Coding Ninjas: https://www.codingninjas.com/studio/problems/number-of-longest-increasing-subsequence_3751627?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTabValue=PROBLEM
Leetcode: https://leetcode.com/problems/number-of-longest-increasing-subsequence/

Algorithm:
   Using LIS Algorithm
      
   Modification: 
    - we add additional  to hold count of subsequences
    - Whenever we find a pre-existing len we simply add its count to the current count
 arr    =[50,3,90,60,80]
 dp    = [1, 1, 1 ,1, 1]    
 count = [1, 1, 1, 1, 1]
        
E.g 90 we have  2 lenghts [50, 90] and [3, 90] so on call  num 3 we copy count at index 1 to  count at index 90
arr    = [50,3,90,60,80]
dp    = [1, 1, 2 ,1, 1]   
count = [1, 1, 2, 1, 1]

 arr    =[50,3,90,60,80]
 dp    = [1, 1, 2 ,2, 3]   
 count = [1, 1, 2, 2, 2]

 at 80 we have [50,60, 80] and [3,60,80], this max len of 3 with count of 2 

*/
import java.util.*;

public class NumberOfLongestIncreasingSubsequence {
    public class Solution {
        public static int findNumberOfLIS(int []arr) {
            // Write your code here.
            int n = arr.length;
            int[]dp = new int[n];
            int [] count = new int[n];
    
            Arrays.fill(dp, 1);
            Arrays.fill(count, 1);
    
            int maxLen = 0;
            for(int i = 0; i < n; i++){
                for(int prev = 0; prev < i; prev++){
                   //Forms a greater value
                   if(arr[prev] < arr[i] &&  dp[prev] + 1 > dp[i]){
                       dp[i] = dp[prev] + 1;
                       //New, inherit from previous
                       count[i] = count[prev];
                  
                   }else if(arr[prev] < arr[i] && dp[prev] + 1 == dp[i] ){
                       //Subsequence with same len exists, increase current count by previous count
                       count[i] += count[prev];
                   }
    
                }
                maxLen = Math.max(maxLen, dp[i]);
            } 
            int nums = 0;
            for(int i =0; i< n; i++){
                if(dp[i]== maxLen){
                    nums += count[i];
                }
            }
            return  nums;
        }
    }
}
