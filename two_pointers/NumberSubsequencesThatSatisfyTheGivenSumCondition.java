package two_pointers;
import java.util.*;
/***
 * https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/
 * 
 * To be revisited
 */
public class NumberSubsequencesThatSatisfyTheGivenSumCondition {
    public int numSubseq(int[] nums, int target) {
        //Sort
        Arrays.sort(nums);
        int n = nums.length;
        long res  = 0;
        long mod = ((long) Math.pow(10, 9)) + 7L;
 
        int left = 0;
        int right =  n - 1;
        
        while(left <= right){
            if(nums[left] + nums[right] > target ){
                right -= 1;
            }else{
               res += (long) Math.pow(2,  (right - left));
               res %= mod;
               left += 1;
            }
        }
        return (int) (res % mod);
     }
}
