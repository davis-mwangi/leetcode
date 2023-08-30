package trees;

/*
 * https://leetcode.com/problems/validate-binary-search-tree/
 *         (5)   [-infinity < 5 < infinity]
 *    (1)      (4)
 *          (3)    (6)
 * 
 * We  do  preorder traversal, 
 * on left , the left remains but we update right boundary
 * for right, the right remains  but we update left boundary
 * since on binary search nodes to the left are less than root node
 * and to the right bigger than root node;
 */
public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean dfs(TreeNode node, Long left, Long right){
        if(node == null){
            return true;
        }
        long val = (long) node.val;
       
        if ( !( val > left && right > val) ){
            return false;
        }
        
        return (dfs(node.left,left, val) &&
                dfs(node.right, val, right ) );   
    }
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
