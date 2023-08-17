package trees;
/**
 * https://leetcode.com/problems/invert-binary-tree/description/
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        //Base Case
       if(root == null){
           return null;
       }

       //Swap the left and right node
       TreeNode temp = root.left;
       root.left =  root.right;
       root.right =  temp;

       //Recurse  preorder
       invertTree(root.left);
       invertTree(root.right);

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
