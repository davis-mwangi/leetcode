package trees;
import java.util.*;
/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * 
 * left -> right -> parent
 */
public class BinaryTreePostorderTraversal {
   
    //Recurvise solution
    List<Integer>result = new ArrayList<>();

    public List<Integer> postorderTraversal1(TreeNode root) {
        dfs(root);
        return result; 
    }

    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        dfs(root.right);
        result.add(root.val);
    }

    //ITERATIVE SOLUTION
    public List<Integer> postorderTraversal(TreeNode root) {
     
       Stack<TreeNode>stack = new Stack<>();
       stack.push(root);
       Stack<Boolean>visited =  new Stack<>();
       visited.push(false);

       while(!stack.isEmpty()){
             TreeNode curr = stack.pop();
             boolean v = visited.pop();
             if(curr != null){
                 if(v){
                     result.add(curr.val);
                 }else{
                    //Add the nodes to the stack
                    stack.push(curr);
                    visited.push(true);

                    stack.push(curr.right);
                    visited.push(false);

                    stack.push(curr.left);
                    visited.push(false);

                 }
             }
       }
       return result;
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
