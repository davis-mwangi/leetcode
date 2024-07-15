package Neetcode_450_Questions.MEDIUM;

/*

Question : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-ii/


Given the root of a binary tree, return the lowest common ancestor (LCA) of two given nodes, p and q. If either node p or q does not exist in the tree, return null. All values of the nodes in the tree are unique.

According to the definition of LCA on Wikipedia: "The lowest common ancestor of two nodes p and q in a binary tree T is the lowest node that has both p and q as descendants (where we allow a node to be a descendant of itself)". A descendant of a node x is a node y that is on the path from node x to some leaf node.

 

Example 1:


Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:



Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5. A node can be a descendant of itself according to the definition of LCA.
Example 3:



Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 10
Output: null
Explanation: Node 10 does not exist in the tree, so return null.
 

Constraints:

The number of nodes in the tree is in the range [1, 104].
-109 <= Node.val <= 109
All Node.val are unique.
p != q


*/
public class LowestCommonAncestorOfABinaryTreeII_LC1644 {
    
   // Definition for a binary tree node.
    public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    }
    
    // TC: O(N)
    // SC :O(N) if we consider auxiliary stack space
    class Solution {
        boolean pFound = false;
        boolean qFound = false;

        public TreeNode lowestCommonAncestor(TreeNode root,
                TreeNode p, TreeNode q) {
            TreeNode ans = postOrder(root, p, q);

            // We return true if both P and Q are found
            return pFound && qFound ? ans : null;
        }

        private TreeNode postOrder(TreeNode node, TreeNode p, TreeNode q) {
            if (node == null) {
                return null;
            }

            TreeNode left = postOrder(node.left, p, q);
            TreeNode right = postOrder(node.right, p, q);

            if (node == p || node == q) {
                // Check which one matches node(has been found) , p or q
                if (node == p) {
                    this.pFound = true;
                } else {
                    this.qFound = true;
                }
                return node;
            }
            // Both left and right has value, then the current node is the LCA
            if (left != null && right != null) {
                return node;
            } else {
                return left != null ? left : right;
            }
        }
    }
}
