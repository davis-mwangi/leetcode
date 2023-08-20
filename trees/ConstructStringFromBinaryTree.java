package trees;

/**
 * https://leetcode.com/problems/construct-string-from-binary-tree/
 * 
 */
class ConstructStringFromBinaryTree {

    //Solution1
    public String tree2str1(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
 
        return sb.toString();
     }
     public void preorder(TreeNode node, StringBuilder sb){
         if(node == null){
             return;
         }
         sb.append(node.val);
 
         if(node.left == null && node.right == null){
             return;
         }
         sb.append("(");
         preorder(node.left, sb);
         sb.append(")");
 
         if(node.right != null){
             sb.append("(");
             preorder(node.right, sb);
             sb.append(")");
         }
 
     }
    //Solution2
    public String tree2str(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);

        if(root.left != null ||  root.right != null){
            sb.append( "("+tree2str(root.left) + ")" );
        }

        if(root.right != null){
            sb.append(  "("+ tree2str(root.right)+ ")" );
        }
        return sb.toString();
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