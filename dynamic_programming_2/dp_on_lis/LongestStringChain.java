package dynamic_programming_2.dp_on_lis;
/*
https://www.codingninjas.com/studio/problems/longest-string-chain_3752111?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos

https://leetcode.com/problems/longest-string-chain/


*/
import java.util.*;

public class LongestStringChain {
    //TC: N * N * max(len)
    //SC: O(N)
    class Solution {
        public int longestStrChain(String[] words) {
            int n = words.length;
            int[] dp =  new int[n];
    
            Arrays.sort(words, (x, y) -> x.length() - y.length()  );
    
            Arrays.fill(dp, 1);
    
            int maxLen = 0;
            for(int i = 0; i < n; i++){
               
                for(int prev = 0; prev < i; prev++){
                    
                    if( compare(words[i], words[prev])  && (dp[prev] + 1) > dp[i] ){
                        dp[i] = dp[prev] + 1;
                    }
                }
    
                maxLen = Math.max(dp[i], maxLen);
            }
    
          return maxLen;
        }
        // Function to compare two strings and check if they form a valid chain
        static boolean compare(String s1, String s2) {
            if (s1.length() != s2.length() + 1) {
                return false;
            }
    
            int first = 0;
            int second = 0;
    
            while (first < s1.length()) {
                if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                    first++;
                    second++;
                } else {
                    first++;
                }
            }
    
            return first == s1.length() && second == s2.length();
        }
    }
}
