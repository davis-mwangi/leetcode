package trees;
/**
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 */
public class InsertIntoABinarySearchTree {
    //Recursive solution
    //Time Complexity: O(h) h - height of the tree
    //Space Complexity: O(h) h  function call stacks
    public TreeNode insertIntoBST(TreeNode root, int val) {
        //Case root is null we return the new node
        if(root == null){
            return  new TreeNode(val);
        }
        //Value greater than curr.val, move right
        if(val > root.val){
            root.right = insertIntoBST(root.right, val);
        }else{
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    //Iterative Solution
    //Time Complexity: O(h)
    //Space  Comple
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        TreeNode curr =  root;
        while(curr != null){
            if(curr.val < val){
                 if(curr.right == null){
                     curr.right = new TreeNode(val);
                     return root;
                 }
                 curr = curr.right;
            }else{
                if(curr.left == null){
                    curr.left =  new TreeNode(val);
                    return root;
                }
                curr.left =  root;
            }
        }
        return root;

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
