package Neetcode_450_Questions;
/*
https://leetcode.com/problems/diameter-of-binary-tree/

*/


public class DiameterOfBinaryTree_Easy_543 {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        int[] result = new int[1];

        public int diameterOfBinaryTree(TreeNode root) {

            int x = dfs(root);

            System.out.println(x);

            return result[0];
        }

        public int dfs(TreeNode current) {
            if (current == null) {
                return -1;
            }
            int left = 1 + dfs(current.left);
            int right = 1 + dfs(current.right);

            result[0] = Math.max((left + right), result[0]);

            return Math.max(left, right);
        }
    }
}
