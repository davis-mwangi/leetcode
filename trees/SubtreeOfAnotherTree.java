package trees;
/**
 * https://leetcode.com/problems/subtree-of-another-tree/description/
 * 
 * The intuation is to check if exists the same tree in root  for subRoot;
 * This is same as same tree problem
 * 
 */
public class SubtreeOfAnotherTree {

    //Time Complexity: O(p * q)
    

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //Base Cases
        if(subRoot == null){
            return true;
        }
        if(root == null){
            return false;
        }
        if(sameTree(root, subRoot)){
            return true;
        }
        //Check if we find matching subtree either on left or right of root node
        return ( isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot) );    
     }
     private boolean sameTree(TreeNode p, TreeNode q){
         if(p == null && q == null){
             return true;
         }
         if(p != null && q != null && p.val == q.val){
             return ( sameTree(p.left,q.left) &&
                     sameTree(p.right, q.right));
         }
         return false;
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
