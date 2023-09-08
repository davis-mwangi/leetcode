package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/subsets-ii/
 * 
 * Approach:
 * Similar to subset I for each step in descision tree we can choose to 
 * include the value or not.
 * 
 * But since this array might not be ordered and have duplicates.
 * We start by sorting the array thats guarantees ordering,
 * then once we include a value we dont factor it in the other
 * decision tree, 
 *     Eg
 * 
 *                   [1,2,2,3]
 *            [1]                  []   
 *         [1,2]       [1]    [2]       []
 *    [1,2,2][1,2] [1,3][1]  [2,2][2]   [3][]
 * 
 * Time Complexity: O(n logn n) + O(2 ^ n) * n
 * Space Complexity: O(n)            
 */
public class SubsetsII {
     List<List<Integer>>result= new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //We sort array First
        Arrays.sort(nums);
        
        backtrack(nums, 0 , new ArrayList<>() );
        return result;
        
    }
    private void backtrack(int[] nums, int i, List<Integer>subset){
        //Base case
        if(i == nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }
        //All subsets that include nums[i]
        subset.add(nums[i]);
        backtrack(nums, i + 1, subset);
        //Before we do the other consideration we need to pop the value we lastly added
        subset.remove( (subset.size() - 1 ) );
        
        //All subsets that dont include nums[i]
        while(i + 1 != nums.length && nums[i] == nums[i+1]){
            i += 1;
        }
        //i now points either to the next unique value after nums[i] or has gone out of bound
        backtrack(nums, i + 1, subset);
    }
    
}
