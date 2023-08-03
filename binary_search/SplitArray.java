package binary_search;
/**
 * https://leetcode.com/problems/split-array-largest-sum/
 * 
 * 
 * GUIDE:
 *  Neetcode: https://www.youtube.com/watch?v=YUF3_eBdzsk
 */
public class SplitArray {
    
    public int splitArray(int[] nums, int k) {
        int left = max(nums);
        int right = sum(nums);

        int res = right;

        while(left <= right){
           int mid = left + ((right-left)/2);
           if(canSplit(nums, mid, k)){
               res = mid;
               right = mid - 1;
           }else{
               left = mid + 1;
           }
        }
        return res;
    }
    private int max(int[]nums){
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            max = Math.max(max, num);
        }
        return max;
    }
    private int sum(int[]nums){
        int sum = 0;
        for(int num: nums){
            sum += num;
        }
        return sum;
    }
    private  boolean canSplit(int[] nums, int largest, int k ){
        int subarray = 0;
        int currSum = 0;
        for(int num:  nums){
            currSum += num;
            if(currSum > largest){
                subarray += 1;
                currSum =  num;
            }
        }
        return subarray+1 <= k;
    }
}
