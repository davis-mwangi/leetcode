package Neetcode_450_Questions;

/*
https://leetcode.com/problems/balanced-binary-tree/description/
*/
public class BalancedBinaryTree_Easy_LC110 {
    class Solution {

        // Definition for a binary tree node.
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

        /*
         * diff of left and right is 1
         * [ balanced, height ]
         * 
         */
        public boolean isBalanced(TreeNode root) {
            int[] res = dfs(root);
            return res[0] == 1;
        }

        private int[] dfs(TreeNode node) {
            if (node == null) {
                return new int[] { 1, 0 }; // [balanced, height]
            }

            int[] left = dfs(node.left);
            int[] right = dfs(node.right);

            // Check if balanced
            int balanced = (left[0] == 1 && right[0] == 1)
                    && (Math.abs(left[1] - right[1]) <= 1) ? 1 : 0;

            // Calculate the max height of both right and left
            int height = 1 + Math.max(left[1], right[1]);

            return new int[] { balanced, height };
        }
    }
}
