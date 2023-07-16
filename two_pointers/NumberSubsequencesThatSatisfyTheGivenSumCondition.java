package two_pointers;
import java.util.*;
/***
 * https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/
 * 
 * 
1.sort the array nums
2. Traverse each number of the array as the left boundary L.
3.According to the left boundary L, use the binary search to find the qualified right boundary R
4.After determining L and R, any permutation and combination of numbers between (L+1)-R meets the requirements (the number is 2 to the power of R-L)
5.Just add all the results together, the specific code is as follows

 */
public class NumberSubsequencesThatSatisfyTheGivenSumCondition {
    public int numSubseq(int[] nums, int target) {
        int MOD = ((int)Math.pow(10, 9))+7;
        Arrays.sort(nums);
        int n = nums.length;
        int[] f = new int[n];
        f[0] = 1;
        for (int i = 1; i < n; i++)
            f[i] = (f[i - 1] << 1) % MOD;
        int l = 0, r = n-1;
        int ans = 0;
        while (l <= r) {
            if (nums[l] + nums[r] > target)
                r--;
            else {
                ans = (ans + f[r - l]) % MOD;
                l++;
            }
        }
        return ans;
     }
}
