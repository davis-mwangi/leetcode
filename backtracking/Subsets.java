package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * https://leetcode.com/problems/subsets/
 * 
 * We  perform a dfs recursiv call where we consider adding the value or not
 * We can use a stack to push item if we consider the value or pop
 *  it if we dont want to consider the value.
 * 
 * Time Complexity:  O(2 ^ N) => since at every point we make two decisions, N siz of array
 * Space Complexity:  O(N)
 */
class Subsets {

     List<List<Integer>>result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,new Stack<>(), 0);
        return result;
    }
    public void  backtrack(int[] nums,Stack<Integer>stack,  int i){
      if(i == nums.length){
          result.add(new ArrayList<>(stack) );
          return;
      }

      //Consider the value in our selection
      stack.push(nums[i]);
      backtrack(nums,stack,  i + 1);

      //not considering the value
      stack.pop();
      backtrack(nums, stack, i + 1);

    }
}