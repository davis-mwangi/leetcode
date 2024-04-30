package Neetcode_450_Questions;

/*

https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

*/
import java.util.*;

public class MaximumDepthOfBinaryTree_Easy_LC104 {

    /*
     * 2 - Approaches
     * i. BFS
     * ii. DFS
     */
    class Solution {

        // solution using DFS
        public int maxDepth(TreeNode root) {
            // Base Case
            if (root == null) {
                return 0;
            }

            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }

        // Solution using BFS
        public int maxDepth2(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Deque<TreeNode> deque = new LinkedList<>();
            deque.add(root);

            int[] level = new int[1];
            while (!deque.isEmpty()) {
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    TreeNode curr = deque.poll();
                    if (curr.left != null) {
                        deque.add(curr.left);
                    }

                    if (curr.right != null) {
                        deque.add(curr.right);
                    }
                }
                level[0] += 1;

            }
            return level[0];
        }

    }

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
