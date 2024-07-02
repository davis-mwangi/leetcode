package Neetcode_450_Questions;

/*
Question :  https://leetcode.com/problems/range-sum-of-bst/description/

YouTube :  https://www.youtube.com/watch?v=6dT3ZWhgDAU

*/
import java.util.*;

public class RangeSumOfBST_Easy_LC939 {
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

    // Recursive solutiuon
    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return sum;

    }

    public void dfs(TreeNode node, int low, int high) {
        if (node == null) {
            return;
        }
        if (node.val >= low && node.val <= high) {
            sum += node.val;
        }
        if (low < node.val) {
            dfs(node.left, low, high);
        }
        if (high > node.val) {
            dfs(node.right, low, high);
        }
    }

    // Iterattive Solution
    public int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        int sum = 0;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (node != null) {
                if (node.val >= low && node.val <= high) {
                    sum += node.val;
                }

                if (low < node.val) {
                    stack.add(node.left);
                }

                if (node.val < high) {
                    stack.add(node.right);
                }
            }
        }
        return sum;
    }

}
