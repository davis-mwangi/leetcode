package trees;
/**
 * https://leetcode.com/problems/house-robber-iii/description/
 * 
 * YouTube: https://www.youtube.com/watch?v=nHR8ytpzz7c
 * 
 * Approach:
 * we consider two cases: with root or without root
 * with root:  root value + without root from left and right subtree
 * without root: we have the liberty to choose any so in this case we choose the max of with or without root for both left and right nodes
 * At the end we take the maximun of with root or without root;
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class  HouseRobberIII {

    class Solution {
        public int rob(TreeNode root) {
            int[] res =  dfs(root);
            return Math.max(res[0], res[1] );    
        }
        //returns [withRoot, withoutRoot]
        private int[] dfs(TreeNode node){
            if(node == null){
                return new int[]{0, 0};
            }
            int [] leftPair = dfs(node.left);
            int [] rightPair = dfs(node.right);
    
            int withRoot = node.val + leftPair[1] + rightPair[1];
            int withoutRoot = Math.max(leftPair[0], leftPair[1]) + 
                              Math.max(rightPair[0], rightPair[1] );
            return new int[]{withRoot, withoutRoot};                  
        }
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
