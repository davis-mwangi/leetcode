package trees;

import java.util.*;

/*
https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
YouTube:  https://www.youtube.com/watch?v=vm63HuIU7kw
*/
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //HashMap of {value:index} improve lookup
        Map<Integer,Integer> inorderMap = getValueIndexMap(inorder);
        Stack<Integer>postOrderStack = getPostOrder(postorder);

        return helper(inorder,inorderMap, postOrderStack, 0,inorder.length -1);

        
    }
    private Stack<Integer> getPostOrder(int[] postorder) {
        Stack<Integer>stack = new Stack<>();
        for (int i = 0; i < postorder.length; i++){
           stack.push(postorder[i]);
        }
        return stack;
    }
    private Map<Integer,Integer> getValueIndexMap(int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>(); 
        for(int i=0; i< inorder.length; i++){
            map.put(inorder[i], i);
        }
        return map;
    }

    private TreeNode  helper (int[] inorder, Map<Integer,Integer> inorderMap, Stack<Integer>postorder, int left, int right){
        if(left > right){
            return null;
        }
        TreeNode root = new TreeNode(postorder.pop());
        int idx = inorderMap.get(root.val);

        root.right = helper(inorder, inorderMap, postorder, idx + 1, right);
        root.left = helper(inorder, inorderMap, postorder, left,idx -1);
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
