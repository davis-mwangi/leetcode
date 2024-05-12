package Neetcode_450_Questions;

/*
https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/

*/
public class MinimumDistanceBetweenBSTNodes_Easy_LC783 {

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
        int[] res = new int[] { Integer.MAX_VALUE };
        TreeNode prev = null;

        public int minDiffInBST(TreeNode root) {
            inorder(root);

            return res[0];
        }

        private void inorder(TreeNode node) {
            if (node == null) {
                return;
            }

            inorder(node.left);

            if (prev != null) {
                res[0] = Math.min(res[0], (node.val - prev.val));
            }
            prev = node;
            inorder(node.right);

        }
    }
}
