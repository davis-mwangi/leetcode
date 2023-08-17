package trees;

import java.util.*;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthOfBinaryTree {
    
//-----------------------------------------------------------
    // BFS
    public int maxDepth1(TreeNode root) {
        int level = 0;
        if (root == null) {
            return level;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = deque.pollFirst();
                if (curr.left != null) {
                    deque.add(curr.left);
                }
                if (curr.right != null) {
                    deque.add(curr.right);
                }
            }
            level += 1;
        }
        return level;
    }

    // ------------------------------------------------------------
    // RECURSIVE DFS SOLUTION
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int maxDepth2(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        return 1 + Math.max(left, right);
    }

    // -----------------------------------------------------------
    // ITERATIVE DFS
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<Pair> deque = new ArrayDeque<>();
        deque.add(new Pair(root, 1));
        int res = 0;
        while (!deque.isEmpty()) {

            Pair pair = deque.pollFirst();
            TreeNode node = pair.getNode();
            int depth = pair.getDepth();

            if (node != null) {
                res = Math.max(res, depth);
                deque.add(new Pair(node.left, depth + 1));
                deque.add(new Pair(node.right, depth + 1));
            }
        }
        return res;
    }

    static class Pair {
        TreeNode node;
        int depth;

        public Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }

        public TreeNode getNode() {
            return this.node;
        }

        public int getDepth() {
            return this.depth;
        }

    }

    // --------------------------------------------------------------
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

}
