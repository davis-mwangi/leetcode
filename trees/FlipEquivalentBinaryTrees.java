package trees;
/*
https://leetcode.com/problems/flip-equivalent-binary-trees/

Time Complexity: O(n)
Space Complexity: O(n)
*/
public class FlipEquivalentBinaryTrees {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null){
            return root1 == null && root2 == null;
        }
        if(root1.val != root2.val){
            return false;
        }
        //case where both both nodes match, left n right
        boolean a = flipEquiv(root1.left, root2.left)  &&
                    flipEquiv(root1.right, root2.right);
        //Compare flipped nodes            
        boolean b = flipEquiv(root1.left, root2.right) &&
                    flipEquiv(root1.right, root2.left);
                    
        return a || b;                        
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
