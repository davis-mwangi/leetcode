package trees;
import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * 
 * 94. Binary Tree Inorder Traversal
    L -> Root -> R
 */
public class BinaryTreeInorderTraversal {
     
    //Space Complexity: O(n) due to the function stacks
    //Time Complexity: O(n) since all values have to be traversed.
    List<Integer>result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) { 
       dfs(root);
       return result;
    }

    private void dfs(TreeNode root){
         if(root == null){
            return;
        }
        inorderTraversal(root.left);
        result.add(root.val);
        inorderTraversal(root.right);
    }
    //Iterative Solution
    public List<Integer> inorderTraversal2(TreeNode root){
        Stack<TreeNode>stack = new Stack<>();
        TreeNode curr =  root;
        List<Integer>res = new ArrayList<>();
        while(curr != null || !stack.isEmpty()){
            //Move left
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            //Once the curr is null its at the leaf node, we pop from the stack and
            //evaluate the right nodes
             curr = stack.pop();
             ///Add to result before  traversing the right
             res.add(curr.val);
             curr = curr.right;
        }
        return res;
    }

    static class TreeNode {
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
