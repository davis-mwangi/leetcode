package trees;
/*
 * https://leetcode.com/problems/count-good-nodes-in-binary-tree/description/
 */
public class CountGoodNodesInBinaryTree {

    //Time Complexity: O(n)
    //Space Complexity:O(n)
    int res = 0;
    public int goodNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root, root.val);

        return res;

    }
    public void dfs(TreeNode node, Integer prevMax){
        if(node == null){
            return;
        }
        if(node.val >= prevMax){
              res += 1;
        }
        int max = Math.max(node.val, prevMax);

        dfs(node.left, max);
        dfs(node.right, max);
    }

    
    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    
}