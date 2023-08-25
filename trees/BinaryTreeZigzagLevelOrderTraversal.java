package trees;

import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 * 
 * we can BFS in this solution, which is a left-> right traversal
 * In this solution we can keep track of whether the level is odd or not,
 * If odd we reverse the level items else we dont.
 * 
 * The Space Complexity: (n/2) sinc we only keep items at a given level, ~ O(n)
 * Time Complexity: O(n) -> Since we have to traverse each item.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // Base Case , root is null or empty
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        List<List<Integer>> result = new ArrayList<>();
        int levelValue = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            // Keep track on the items on this level
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                // Pop the item from left
                TreeNode node = deque.pollFirst();
                level.add(node.val);
                // we dont add null to the deque
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
            // Add to the result, but before we add we check whether the level is odd so
            // that we can reverse
            level = levelValue % 2 == 1 ? reverse(level) : level;
            result.add(level);
            levelValue += 1;
        }
        return result;

    }

    private List<Integer> reverse(List<Integer> lst) {
        int l = 0;
        int r = lst.size() - 1;
        while (l <= r) {
            Integer temp = lst.get(l);
            lst.set(l, lst.get(r));
            lst.set(r, temp);
            l++;
            r --;
        }
        return lst;
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
