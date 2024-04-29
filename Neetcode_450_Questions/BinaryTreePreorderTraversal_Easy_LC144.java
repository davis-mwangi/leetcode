package Neetcode_450_Questions;

/*
https://leetcode.com/problems/binary-tree-preorder-traversal/description/
*/
import java.util.*;

public class BinaryTreePreorderTraversal_Easy_LC144 {

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
        List<Integer> res = new ArrayList<>();

        public List<Integer> preorderTraversal(TreeNode root) {
            dfs(root);
            return res;
        }

        private void dfs(TreeNode node) {
            if (node == null) {
                return;
            }
            res.add(node.val);
            dfs(node.left);
            dfs(node.right);
        }
    }

}
