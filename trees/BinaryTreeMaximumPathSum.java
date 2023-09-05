package trees;
/* 
https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

Approach is we maintain a global variable that keeps track the max sum 
we do a post order traversal.
considering the split, we find max by node value + left max + right max,

since when we return to previous node we dont dont consider split, we take one  of the paths 
in this case
we find max (left  max ,right max) + node val
*/
public class BinaryTreeMaximumPathSum {
       
        int [] result = new int[1];
    
        public int maxPathSum(TreeNode root) {
            
            result[0] = root.val;
            
            dfs(root);
            
            return result[0];
        }
        
        public int dfs(TreeNode root){
            if(root == null){
                return 0;
            }
            
            int leftMax = dfs(root.left);
            int rightMax = dfs(root.right);
            
            //Case where left or right max is negative
            leftMax = Math.max(leftMax, 0);
            rightMax = Math.max(rightMax, 0);
            
            int totalMax =  leftMax  + rightMax + root.val;
            
            result[0]= Math.max(result[0], totalMax);
            
            return root.val + Math.max(leftMax, rightMax);
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
