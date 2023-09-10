package backtracking;
import java.util.*;
/*
https://leetcode.com/problems/combination-sum-ii/

Approach:

Since on every  iteration,we either conside to include  the value or not, 
then to avoid duplicate we  sort tjhe array first, such that if we included the value we dont consider
it in another iteration.

Time Complexity: O(2 ^ n)
Space Complexity: O(n)

*/
public class CombinationSumII {
    //Solution 1
    List<List<Integer>>res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // [10,1,2,7,6,1,5] => [1,1,2,5,6,7,10]
        Arrays.sort(candidates);
        backtrack(candidates,target, 0, new ArrayList<>());
        return res;
    }
    public void backtrack(int[] c, int t, int i, List<Integer>curr){
        //If target becomes 0, we add the items result to the sum
        if(t == 0){
            res.add(new ArrayList<>(curr) );
            return;
        }
        //if target  goes beyond we return
        if(t < 0){
            return;
        }

        int prev  = Integer.MIN_VALUE;

        for(  int j = i; j < c.length; j++){
            if (prev == c[j]){
                continue;
            }  
            curr.add(c[j]);
            
            backtrack(c, t - c[j], j + 1, curr);

            //pop back item lastly added
            curr.remove( (curr.size() - 1) );
            prev = c[j];
        
        }
    }
    //Solution 2
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //First we sort the candidate numbers [1,2,2,2,5]
        List<List<Integer>>result= new ArrayList<>();
        
        Arrays.sort(candidates);
        
        backtrack(candidates, result, new ArrayList<>(), 0,target);
        
        return result; 
    }
    
    public void backtrack(int[] candidates, List<List<Integer>>result, List<Integer>list,int start, int target){
       
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }
    
        if(start >= candidates.length){
            return;
        }
        if(target < 0){
            return;
        }
        
        //Case where we take the candidates[start]
        list.add(candidates[start]);
        
        backtrack(candidates, result, list, start + 1, target -  candidates[start] );
        list.remove( list.size() - 1);
        
        //Case where we dont take candidate[start]
        while(start + 1 < candidates.length && candidates[start] == candidates[start + 1]){
            start += 1;
        }
        
        backtrack(candidates, result, list, start + 1, target);
    }

}
