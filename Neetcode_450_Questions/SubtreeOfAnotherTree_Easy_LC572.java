package Neetcode_450_Questions;

/*

https://leetcode.com/problems/subtree-of-another-tree/description/

*/
public class SubtreeOfAnotherTree_Easy_LC572 {

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
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (root == null && subRoot == null) {
                return true;
            }
            if (root == null || subRoot == null) {
                return false;
            }

            // Check if tree is same
            if (sameTree(root, subRoot)) {
                return true;
            }

            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        private boolean sameTree(TreeNode nodeA, TreeNode nodeB) {
            if (nodeA == null && nodeB == null) {
                return true;
            }
            if (nodeA == null || nodeB == null) {
                return false;
            }
            // Compare values
            if (nodeA.val != nodeB.val) {
                return false;
            }
            boolean left = sameTree(nodeA.left, nodeB.left);
            boolean right = sameTree(nodeA.right, nodeB.right);

            return left && right;
        }
    }
}
