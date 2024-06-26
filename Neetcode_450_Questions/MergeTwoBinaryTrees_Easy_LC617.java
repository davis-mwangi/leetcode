package Neetcode_450_Questions;

/*

https://leetcode.com/problems/merge-two-binary-trees/description/

*/
public class MergeTwoBinaryTrees_Easy_LC617 {

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

        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            // Base cases
            if (root1 == null && root2 == null) {
                return null;
            }
            if (root1 != null && root2 == null) {
                return root1;
            }
            if (root2 != null && root1 == null) {
                return root2;
            }

            TreeNode root = new TreeNode(root1.val + root2.val);
            root.left = mergeTrees(root1.left, root2.left);
            root.right = mergeTrees(root1.right, root2.right);

            return root;
        }

    }
}
