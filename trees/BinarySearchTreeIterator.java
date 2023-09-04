package trees;
import java.util.*;
/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 */
public class BinarySearchTreeIterator {
    private Stack<TreeNode>stack;
    public BinarySearchTreeIterator(TreeNode root) {
        this.stack =  new Stack<>();
        //Add all items to the left to the stack
        while(root != null){
            this.stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode res = this.stack.pop();
        //Befor we return next lets add all right nodes to the stack
        TreeNode curr = res.right;
        while(curr != null){
            this.stack.push(curr);
            curr = curr.left;
        }
        return res.val;
    }
    
    public boolean hasNext() {
        return !this.stack.isEmpty();
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
