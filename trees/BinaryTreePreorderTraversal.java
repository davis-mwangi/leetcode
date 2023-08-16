package trees;
import java.util.*;

/**
 *  https://leetcode.com/problems/binary-tree-preorder-traversal/
 * 
 *  parent -> left -> right
 */
public class BinaryTreePreorderTraversal {
    List<Integer>result= new ArrayList<>();
    
    public List<Integer> preorderTraversal(TreeNode root) {
        dfs(root);
        return result;

    }
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    //Recursive solution
    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        result.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }

    //Iterative Solution
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public List<Integer> preorderTraversal2(TreeNode root) {
        Stack<TreeNode>stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()){
             if(curr != null){
               result.add(curr.val);
               stack.push(curr.right);
               curr = curr.left;
             }else{
                 curr = stack.pop();
             }
        }
        return result;
    }

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
