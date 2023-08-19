package trees;

/*
https://leetcode.com/problems/balanced-binary-tree/

We maintain a set of two  {balance, height}, balance to keep track of whether the tree is balanced from thr given node
and height this will track the max height of left and right at a given node

*/
public class BalancedBinaryTree {

    //Time Complexity: O(N) since we visited the node only once
    public boolean isBalanced(TreeNode root) {
        int [] res = dfs(root);
        return res[0] == 1;
    }
    private int[] dfs(TreeNode node){
        //Base Case
        if(node == null){
            return new int[]{1, 0}; //[balanced, height] balanced =1, not balanced = 0
        }
        
        int [] left = dfs(node.left);
        int [] right =  dfs(node.right);

        boolean balanced = (Math.abs(left[1] - right[1]) <= 1) &&
                        (left[0] == 1) && (right[0] == 1);
        int h = 1+ Math.max(left[1], right[1]);
        return  new int[]{balanced ? 1: 0, h };           
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