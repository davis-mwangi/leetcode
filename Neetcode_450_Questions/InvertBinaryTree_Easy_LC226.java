package Neetcode_450_Questions;

/*

https://leetcode.com/problems/invert-binary-tree/description/

*/
import java.util.*;

public class InvertBinaryTree_Easy_LC226 {

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

    class Solution1 {

        /*
         * 1. BFS
         * [7, 2]
         * [9, 6, 3 ,1]
         */

        // Invert using BFS
        public TreeNode invertTree(TreeNode root) {
            // Case root is null
            if (root == null) {
                return null;
            }
            Deque<TreeNode> deque = new LinkedList<>();
            deque.add(root);

            while (!deque.isEmpty()) {
                int size = deque.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.poll();
                    if (node != null) {
                        TreeNode temp = node.left;
                        node.left = node.right;
                        node.right = temp;

                        deque.add(node.right);
                        deque.add(node.left);

                    }
                }
            }
            return root;

        }

        //Invert using DFS
        class Solution2 {
            public TreeNode invertTree(TreeNode root) {
                // Base Case
                if (root == null) {
                    return null;
                }

                // Swap the left and right node
                TreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;

                // Recurse preorder
                invertTree(root.left);
                invertTree(root.right);

                return root;
            }
        }
    }
}
