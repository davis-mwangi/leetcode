package Neetcode_450_Questions;

/*
https://leetcode.com/problems/symmetric-tree/description/
*/
public class SymmetricTree_Easy_LC101 {
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
        /*
         * 1. Inverse
         * 2.Compare each node using sameTree concept
         * 
         */

        public boolean isSymmetric(TreeNode root) {
            TreeNode reversed = inverse(root);
            return sameTree(root, reversed);
        }

        private TreeNode inverse(TreeNode node) {
            if (node == null) {
                return null;
            }

            TreeNode root = new TreeNode(node.val);
            root.left = inverse(node.right);
            root.right = inverse(node.left);
            return root;
        }

        private boolean sameTree(TreeNode orig, TreeNode reversed) {
            if (orig == null && reversed == null) {
                return true;
            }
            if (orig == null || reversed == null) {
                return false;
            }
            if (orig.val != reversed.val) {
                return false;
            }
            return sameTree(orig.left, reversed.left) && sameTree(orig.right, reversed.right);
        }
    }
}
