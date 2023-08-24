package trees;
/**
 * https://leetcode.com/problems/symmetric-tree/submissions/
 * 
 * Intuation is to compare left and right nodes, we will run  this in parallel,
 *  if both are null then are symmetric, if one is null then its not symmetric,
 *  we compare both left and right values and  run dfs.
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return  dfs(root.left, root.right);
    }
    //Compare left and right
    //Space Complexity: O(h) height of the tree
    //Time Complexity: O(n) since we have to go through nodes, both right and rleft
    private boolean dfs(TreeNode left, TreeNode right){
        //Case all null
        if(left == null && right == null){
            return true;
        }
        //One is null
        if(left == null || right == null){
            return false;
        }
       
       return ( left.val == right.val &&
        dfs(left.left, right.right) &&
        dfs(left.right, right.left) );

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
