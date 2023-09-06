package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * https://leetcode.com/problems/combinations/
 * 
 * Time Complexity: O(2 ^ N)
 * Space Complexity: O(N)
 */
public class Combinations {
     List<List<Integer>>res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(n,k, 1, new Stack<>() );
        return res;
    }

    private void dfs(int n, int k, int i, Stack<Integer>curr){

        if(curr.size() == k){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(i > n || curr.size() > k){
            return;
        }
        //Consider the value i
        curr.push(i);
        dfs(n,k, i + 1, curr);
        //Not consider i
        curr.pop();
        dfs(n, k, i + 1, curr);
    }
}
