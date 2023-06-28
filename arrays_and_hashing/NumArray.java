package arrays_and_hashing;

/**
 * https://leetcode.com/problems/range-sum-query-immutable/
 */
//Solution 1:
public class NumArray {
    private int [] nums;
  
    public NumArray(int[] nums) {
        this.nums =  nums;
    }
    
    public int sumRange(int left, int right) {
        //Bruteforce
        int sum = 0;
        while(left <= right){
           sum +=  nums[left];
           left++;
        }
        return sum;
    }
}


//Solution 2:
//Optimized Solution using a prefix sum array
public class NumArray {
    private int [] prefixSum;
  
    public NumArray(int[] nums) {
        int n = nums.length;
        this.prefixSum = new int[n];

        int leftSum = 0;

        for(int i = 0; i< n; i++){
            prefixSum[i] = leftSum + nums[i];
            leftSum = prefixSum[i];
        }
    }
    
    public int sumRange(int left, int right) {
       int rightSum = prefixSum[right];
       int leftSum = left - 1 >= 0 ? prefixSum[left -1 ] :0;
  
      return rightSum - leftSum;

    }
}