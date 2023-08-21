package trees;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
 * 
 * We get the lowest common ancestor whenever we find a split, between nodes A
 * and B
 * If A or B equals the node then the node is the LCA
 */
public class LowestCommonAncestorBinarySearchTree {

    // Time Complexity: O(log n) , the height of the tree since we dont have to go
    // through each node
    // Space Complexity: O(1)
    // Iterative Soln
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while (curr != null) {
            // p & q greater than node then we dont need to check on the left
            if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            } else if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            } else {
                return curr;
            }
        }
        return null;

    }

    // Recursive solution
    //Time Complexity: O(log)
    //Space Complexity: O(n) ~ function stack calls
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        // If both are greater than the root node, chek on the right
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);

        } else if (p.val < root.val && q.val < root.val) {//// If both are less than the root node, chek on the left
            return lowestCommonAncestor(root.left, p, q);

        } else { // Where split occurs it the LCA
            return root;
        }

    }

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
