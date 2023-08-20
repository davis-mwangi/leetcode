package trees;
/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
 * 
 * The intution is to find the mid, since all values are sorted, we create the parent node with the mid value,
 * Any values to left of mid will be part of left subtree and values to the right will be to the right sub-tree.
 * Base case is when left > right , then we can return empty or null;
 * 
 * 
 * Time Complexity:  O(n)
 * Space Complexity: O(log n) 
 */
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length -1);
    }
    private TreeNode helper(int[]nums, int l, int r){
        //Base case
        if(l > r){
            return null;
        }
        int mid = l + ((r - l)/2);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, l, mid -1);
        root.right = helper(nums, mid + 1, r);
        return root;
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
