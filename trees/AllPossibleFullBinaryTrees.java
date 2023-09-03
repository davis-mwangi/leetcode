package trees;
import java.util.*;
/*
https://leetcode.com/problems/all-possible-full-binary-trees/

Given an integer n, return a list of all possible full binary trees with n nodes. Each node of each tree in the answer must have Node.val == 0.

Each element of the answer is the root node of one possible tree. You may return the final list of trees in any order.

A full binary tree is a binary tree where each node has exactly 0 or 2 children.

Input: n = 7
Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]


Intuition

Approach

Approach:
To generate all possible full binary trees with n nodes, we'll use a recursive approach with memoization.
 The idea is to break down the problem into subproblems and store the results of subproblems in a hashmap (memoization).
  By doing this, we avoid redundant calculations and improve the efficiency of the solution.

Implementation Explanation:

Class TreeNode:

We start by defining a TreeNode class to represent the nodes of the full binary trees. 
Each TreeNode has an integer val, and pointers to its left and right child nodes.
allPossibleFBT Method:

The allPossibleFBT method is the main entry point of our solution.
It first checks if n is 0 or even (since full binary trees can only have an odd number of nodes). 
If n is 0 or even, we return an empty list, as no full binary tree is possible in these cases.

Otherwise, we create a hashmap memo to store the computed results of subproblems, where the key is n (the number of nodes), 
and the value is the list of possible full binary trees with n nodes.
We call the generateFBT method, passing n and the memo hashmap, to generate all possible full binary trees with n nodes.
generateFBT Method:

The generateFBT method is the recursive helper function that generates all possible full binary trees with n nodes.
We first check the base case: if n is 1, which means we have a single-node tree, we create a TreeNode with value 0 and add it to a list. We return this list as the result.
Next, we check if the result for the current value of n is already present in the memo hashmap. If it is, we return the precomputed list of full binary trees for n.
If the result is not in the memo, we initialize an empty list called result to store all possible full binary trees with n nodes.
We use a loop to try different combinations of left and right subtrees with a total of n nodes. Since full binary trees can only have an odd number of nodes,
 we iterate through odd values from 1 to n-1 (inclusive), considering all possible ways to split the n nodes into left and right subtrees.
For each odd value i, we recursively call generateFBT(i, memo) to generate all possible left subtrees with i nodes, and generateFBT(n - i - 1,
 memo) to generate all possible right subtrees with n - i - 1 nodes. Note that we subtract 1 from n - i because the root node will be one of
  the nodes in the full binary tree.
We then create all possible full binary trees by combining the left and right subtrees obtained in the previous step. For each combination,
 we create a new TreeNode as the root and set its left and right subtrees accordingly.
Finally, we add the newly created root node to the result list.
After the loop is complete, we store the result list in the memo hashmap with n as the key.
We return the result list, which contains all possible full binary trees with n nodes.
Complexity

Time complexity:
The time complexity of this approach is O(2^n) since there are 2^n possible unique full binary trees with n nodes. 
However, memoization significantly reduces the number of redundant calculations, making the actual time complexity much better for practical cases.

Space complexity:
The space complexity of this approach is O(n * N), where N is the number of nodes in all possible 
full binary trees with n nodes. Since each node in a full binary tree is unique, the space complexity can be approximated as O(n * C), where C is the number of unique full binary trees with n nodes. Memoization helps reduce redundant space usage by storing the computed results of subproblems.

*/
public class AllPossibleFullBinaryTrees {

    public List<TreeNode> allPossibleFBT(int n) {
        if(n== 0 || n  % 2 == 0){
            return new ArrayList<>();
        }
        Map<Integer, List<TreeNode>>dp = new HashMap<>();//Memoize
        return backtrack(dp, n); 
    }
    private List<TreeNode> backtrack( Map<Integer,List<TreeNode>>dp, int n){
        List<TreeNode>res = new ArrayList<>();
        
        if(n == 1){
            res = new ArrayList<>();
            res.add( new TreeNode(0) );
        }
        
        if(dp.containsKey(n)){
            dp.get(n);
        }

        for(int left  = 1;  left <= n -1; left += 2){// o -> (n -1)
            int right =  n - 1 - left;
            List<TreeNode>leftTrees =  backtrack(dp, left);
            List<TreeNode>rightTrees =  backtrack(dp, right);

            for(TreeNode t1 : leftTrees){
                for(TreeNode t2:  rightTrees){
                    res.add( new TreeNode(0, t1, t2) );
                }
            }

        }
        dp.put(n, res);
        return res;
    }
   //Definition for a binary tree node.
   public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode() {}
       TreeNode(int val) { this.val = val; }
       TreeNode(int val, TreeNode left, TreeNode right) {
           this.val = val;
           this.left = left;
           this.right = right;
       }
   }
   
}
