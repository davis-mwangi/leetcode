package arrays_and_hashing;
import java.util.*;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/description/
 * 
 * Guide: https://www.youtube.com/watch?v=xvNwoz-ufXA
 * Neetcode: https://www.youtube.com/watch?v=fFVZt-6sgyo
 */
public class SubarraySumEqualsK {
    //Optimal Solution
    //[1,2,3,-3,1,1,1,4,2,-3] k = 3
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        Map<Integer,Integer> prefixCountMap = new HashMap<>();
        prefixCountMap.put(0,1);
        for(int i = 0; i < nums.length;i++){
            prefixSum +=  nums[i];
            int remove = prefixSum -  k;
            if(prefixCountMap.containsKey(remove)){
                count += prefixCountMap.get(remove);
            }
            prefixCountMap.put(prefixSum,prefixCountMap.getOrDefault(prefixSum, 0) + 1);
                
        }
        return count;
    }


    // [1,1,1] k = 2
    // [1,2,3] k = 3
    // l=
    //Bruteforce
    public int subarraySum1(int[] nums, int k) {
        int count = 0;

        for(int i = 0; i< nums.length;i++){
            int sum = 0;
            for(int j= i; j < nums.length; j++){

              sum +=  nums[j];

              if(sum == k){
                  count++;
              }
            }
        }
        return count;
    }
}
