package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
     List<List<Integer>>res =  new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, new Stack<>(), 0,target, 0);
        return res;
    }
    public void backtrack(int[] c, Stack<Integer>curr, int currSum, int t, int i){
        //We get a sum matching target
        if(currSum == t){
            res.add(new ArrayList<>(curr));
            return;
        }
        //Handle  negativ cases
        if(currSum > t || i >= c.length){
            return;
        }
        //we consider the value
        curr.push(c[i]);
        backtrack(c, curr, currSum + c[i],t, i );

        //We dont consider the value
        curr.pop();
        backtrack(c, curr, currSum,t, i+ 1);
    }
}
