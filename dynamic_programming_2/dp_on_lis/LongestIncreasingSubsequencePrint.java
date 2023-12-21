package dynamic_programming_2.dp_on_lis;
/*
Leetcode: https://leetcode.com/problems/longest-increasing-subsequence/description/
YT: https://www.youtube.com/watch?v=IFfYfonAFGc&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=43


*/
import java.util.*;

public class LongestIncreasingSubsequencePrint {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            //Your code goes here
            int n = nums.length;
            int[] dp = new int[n];
            
            Arrays.fill(dp, 1);
    
            int maxi = 0;
    
            int[]hash = new int[n];
            int lastIndex = 0;
    
            for(int i = 0; i < n; i++){
                hash[i] = i;
                for(int prev = 0; prev < i; prev++){
                    
                    if(nums[prev] < nums[i] &&  (dp[prev] + 1 > dp[i]) ){
                        
                        dp[i] =  dp[prev] + 1;
                        
                        hash[i]= prev;
                    }
    
                }
                if(dp[i] > maxi){
                   maxi = dp[i];
                   lastIndex = i;
                }
                
            }
            List<Integer>list = new ArrayList<>();
            list.add(nums[lastIndex]);
            
            while(hash[lastIndex] != lastIndex){
                lastIndex = hash[lastIndex];
                list.add(nums[lastIndex]);
            }
            Collections.reverse(list);
    
            System.out.println(list);
            return  maxi;
    
        }
    }
}
