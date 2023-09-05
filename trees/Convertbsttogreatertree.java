package trees;
/*
 * https://leetcode.com/problems/convert-bst-to-greater-tree/
 * 
 * Approach:
 * We do ineverse inorder traversal i.e right -> root -left
 * We maintain a global that maintains the current sum of  of a given node,
 * We do a dfs from right then update the sum then do dfs on the left
 * 
 * Space Complexity: O(n) on worst case, average case O(h) -> height , best case O(log N)
 * Time Complexity: O(n)
 */
public class Convertbsttogreatertree {
    int currSum = 0;
    public TreeNode convertBST(TreeNode root) {
       inorder(root);
       return root;
    }
    private void inorder(TreeNode node){
        if(node == null){
            return;
        }
        
        //We do inverse inorder traversal
        inorder(node.right);
        //Once done with right node, we process the root 
        currSum = currSum + node.val;
        node.val =  currSum;
        
        //Traverser left
        inorder(node.left);
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
