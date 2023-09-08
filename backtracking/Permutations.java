package backtracking;

import java.util.*;

/*
 * https://leetcode.com/problems/permutations/description/
 * 
 * Time complexity: O(2 ^ n) where n is the length of nums
 * Space Complexity: O(n)
 */
public class Permutations {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>>permute(int[]nums){
        boolean[] visited = new boolean[nums.length];
        helper(nums,new ArrayList<>(), visited);
        return result;
    }

    private void helper(int[] nums, List<Integer> list,
     boolean[] visited) {
        // Base case
        if (nums.length == list.size()) {
            // add items to the result list
            result.add(new ArrayList<>(list));
            return;
        }
        //Go through each value
        for(int i = 0; i < nums.length; i++){
               if(!visited[i]){
                   //Mark current index as visited
                   visited[i] = true;
                   list.add(nums[i]);
                   helper(nums, list, visited);

                   //Pop back the last item we added
                   visited[i] = false;
                   list.remove( (list.size() -1) );

               }
        }
    }
}
