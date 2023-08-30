package trees;

import java.util.Stack;

/*
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
   
 */
public class KthSmalletInBST {
    
     /*
     We can do inorder traversal using DFS iteratively
     Space Complexity: O(n)
     Time Complexity: O(n)
    */
    public int kthSmallest(TreeNode root, int k) {
      Stack<TreeNode>stack = new Stack<>();

      int x = 0;
      TreeNode curr = root;
      while(curr != null || !stack.isEmpty() ){
          //Move far left
          while(curr != null){
            //but before we shift, we add the current node to the stack
            stack.add(curr);
            curr = curr.left;
        }
        //At this point, we are at the farthest left
        curr = stack.pop();
        x += 1;
        if(x == k){
            return  curr.val;
        }
        //If we exhaust left we move to right
        curr = curr.right;
      }
      return -1;
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
