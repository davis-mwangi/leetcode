package trees;
/**
 * https://leetcode.com/problems/diameter-of-binary-tree/
 * 
 * height = 1 + max(leftH,rightH);
 * Diameter = 2 + leftH + rightH
 */
public class DiameterOfBinaryTree {

    int[] d = new int[1];
    public int diameterOfBinaryTree(TreeNode root) {
       
       dfs(root);
       return d[0];
    }
    //DFS 
    //Time Complexity: O(n)
    //Space Complexity: (n)  -> call stack
    public int dfs(TreeNode node){
        //Height of empty/null node is -1;
        if(node == null){
           return -1;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        //Calulcate diamater
        d[0] = Math.max(d[0], (1 + left) + (1 + right) );
        //Calculate height
        return 1 + Math.max(left, right);
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
