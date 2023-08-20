package trees;
/**
 * https://leetcode.com/problems/merge-two-binary-trees/
 * 
 * We perform on both trees incase we have two nodes present we sum them up, or if empty then we take 0 as the value
 * Case where both are empty we return null values
 * 
 * Time Complexity: O(p+q)
 * Space Complexity: O(p+q)
 */
public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //Base Cases
        if(root1 == null && root2 == null ){
              return null;
        }
        
        //We assume it node is null we take 0 as the value
        int v1 = root1 != null ? root1.val : 0;
        int v2 = root2 != null ? root2.val : 0;

        //Create a new Node
        TreeNode node = new TreeNode( (v1 +v2) );
        node.left =  mergeTrees( 
                   root1 != null ? root1.left : null,
                   root2 != null ? root2.left : null);

        node.right = mergeTrees(
                   root1 != null ? root1.right : null,
                   root2 != null ? root2.right : null);

        return node;
    
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
