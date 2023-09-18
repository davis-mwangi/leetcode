package backtracking;
/*
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 * 
 * Approach:
 * We use backtracking where we either chose a value or not
 * We get the target by summing all the values and divide by k
 * If the sum mode k is not an even num, then not possible so we return false;
 * 
 * Our base case is when k becomes zero, since whenever  subset equals target,
 * we decrease number of k,
 * 
 * 
 * Time Complexity: O(k * 2^ n)
 */
public class PartitiontoKequalSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total =  sum(nums);
        if(total % k != 0){
            return false;
        }
        int target =  total  / k;
        boolean[] used = new boolean[nums.length];
        return backtrack(nums, 0, k, target, 0, used);
    }
    private boolean backtrack(int [] nums, int i, int k ,int target, int subsetSum, boolean [] used){
        if(k == 0){
            return true;
        }
        if( subsetSum == target ){
            //Retart te backtrack
          return backtrack(nums, 0, k - 1, target, 0, used);
        }
        for(int j = i; j < nums.length; j++){
            if(used[j] || (subsetSum + nums[j]) >  target){
                continue;
            }
            used[j] = true;
            if(  backtrack( nums, (j + 1), k,target, (subsetSum +  nums[j]), used) ){
                return true;
            }
            used[j] = false;
        }
        return false;
    }
    private int sum(int[] arr){
        int sum = 0;
        for(int num: arr){
            sum += num;
        }
        return sum;
    }
}
