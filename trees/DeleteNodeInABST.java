package trees;
/**
 * https://leetcode.com/problems/delete-node-in-a-bst/
 */
public class DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        //Base case
        dfs(root, root, key);
       return root;
    }
    private void dfs(TreeNode node,TreeNode prev, int key){
        if(node == null){
            return;
        }

        if (key > node.val){
            dfs(node.right,node, key);
        }else if(key < node.val){
             dfs(node.left,node, key);
        }else{
            prev.left = node.left;
            prev.right =node.right;
        }
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
