package backtracking;
import java.util.*;
/*
https://leetcode.com/problems/permutations-ii/description/
We solve this by using Permutations 1 approach but only that we have to modify it abit
First we sort the array
second  Once we consider as certain value any subsequent value of the same will be ignored,
we can achieve this by maintaing a previous value so we dont repeat the same path.

Time Complexity: O(2 ^ n)
Space complexity: O(n)

*/
public class PermutationsII {

    List<List<Integer>>res= new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] visited = new boolean [nums.length];
        backtrack(nums,visited,new ArrayList<>() );
        return res;
    }
    private void backtrack(int[] nums,boolean[] visited, List<Integer>curr){
        //Base case 
        if(nums.length == curr.size()){
           res.add(new ArrayList<>(curr));
           return;
        }
        int prev = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(prev == nums[i]){
                continue;
            }
            if( !visited[i] ){
                curr.add(nums[i]);
                visited[i]= true;
                backtrack(nums, visited, curr);
                curr.remove( curr.size() -1);
                visited[i]= false;
                prev = nums[i];
            }
        }

    }
}
