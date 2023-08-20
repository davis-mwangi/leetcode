package trees;
/**
 * https://leetcode.com/problems/path-sum/description/
 * 
 * We use inorder traversal, once we get to the leaf node, we compare if sum will be equal to the target  sum,
 * 
 * If either left or right subtree returns true then we found a target sum.
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }
    private boolean dfs(TreeNode root, int sum, int t){
        if(root == null){
            return false;
        }
        //check if is leaf node
         sum += root.val; 
        if(root.left == null && root.right == null){
            return sum == t;
        }
        return (dfs(root.left,sum,t) || dfs(root.right,sum,t) );

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
