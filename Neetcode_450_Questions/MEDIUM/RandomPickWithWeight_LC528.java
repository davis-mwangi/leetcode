package Neetcode_450_Questions.MEDIUM;
/*
Question : https://leetcode.com/problems/random-pick-with-weight/description/

Guide : https://www.youtube.com/watch?v=HXRN8ZfAQOI&t=344s
*/

import java.util.*;

public class RandomPickWithWeight_LC528 {
    class Solution {
        int[] prefixSum;
        int totalSum = 0;
        Random random;
        public Solution(int[] w) {
            int sum = 0;
            int n = w.length;
            this.prefixSum =  new int[n];
            for(int i = 0; i <n; i++){
                sum  += w[i];
                prefixSum[i] = sum;
            }
            this.totalSum = sum;
            this.random = new Random();
        }
        // [1, 2, 4] -> [1, 3, 7]  -> 0-1--3----7
        //This forms buckets : [0->1], [1->3], [3->7]
        // l=2  , r = 2 m = 2=> 2
        //pick 7
        public int pickIndex() {
            int len = prefixSum.length;
            int randomPick = random.nextInt(totalSum) + 1;
            int left = 0;
            int right = len - 1;
            // search position 
            while(left < right){
                int mid = left + (right-left)/2;
                if(prefixSum[mid] == randomPick)
                    return mid;
                else if(prefixSum[mid] < randomPick)
                    left = mid + 1;
                else
                    right = mid;
            }
            return left;
        }
    }
    
 } /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(w);
     * int param_1 = obj.pickIndex();
}
