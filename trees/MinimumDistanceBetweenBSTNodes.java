package trees;
/**
 * https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 * 
 * We use inorder traversal to traverse binary search tree
 */
public class MinimumDistanceBetweenBSTNodes {
    
    //Time complexity: O(n)
    //Space complexity:O(n)
    int[] res = new int[] { Integer.MAX_VALUE };
    TreeNode prev = null;
    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return res[0];
    }

    private void inorder(TreeNode node){
        if(node == null){
            return;
        }
        inorder(node.left);

        if(prev != null){
          int diff = node.val - prev.val;
          res[0] = Math.min(res[0], diff);
        }
        prev = node;
        inorder(node.right);
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
