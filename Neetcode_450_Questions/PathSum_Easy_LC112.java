package Neetcode_450_Questions;

/*

https://leetcode.com/problems/path-sum/description/

*/
public class PathSum_Easy_LC112 {

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
        public boolean hasPathSum(TreeNode root, int targetSum) {
            return dfs(root, targetSum, 0);
        }

        private boolean dfs(TreeNode root, int targetSum, int currSum) {
            // Base case
            if (root == null) {
                return false;
            }

            currSum += root.val;
            // Check leaf node and get if current sum equals target
            if (root.left == null && root.right == null) {
                return currSum == targetSum;
            }

            return dfs(root.left, targetSum, currSum) || dfs(root.right, targetSum, currSum);

        }
    }
}
