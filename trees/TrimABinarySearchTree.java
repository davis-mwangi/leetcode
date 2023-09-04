package trees;
/*
 * 
https://leetcode.com/problems/trim-a-binary-search-tree/description/


Time Complexity: O(n)
Space Complexity:(n) -> Call stacks
 */
public class TrimABinarySearchTree {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null){
            return null;
        }
        //Check if nod is greater than high, if it is then we ignore th right subtree and
        //traverse left
        if(root.val > high){
           return trimBST(root.left, low, high);
        }
        //value is less than low, we ignore left subtre, and trsaverse right
        if(root.val <  low){
            return trimBST(root.right, low, high);
        }

        //If within range of high, we return back to the source node
        root.left =  trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);

        return root;
    }

/   
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
