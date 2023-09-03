package trees;
import java.util.*;

/*
https://leetcode.com/problems/find-bottom-left-tree-value/description/

Given the root of a binary tree, return the leftmost value in the last row of the tree.

Approach:
 Since we want left most, we also do consider  leaf noode thats has only right node,
    In this case we  do BFS, processing right to left, so incase we have only right 
    node, it will be the left most node/
    
    Time Complexity: O(n)
    Space Complexity: O(n)
*/
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode>deque = new LinkedList<>();
        deque.add(root);
        int res = 0;
       
        while(!deque.isEmpty()){
            
            int size = deque.size();

            for (int i = 0; i <  size; i++){
                TreeNode node = deque.poll();
                res = node.val;
                if(node.right != null){
                    deque.add(node.right);
                }
                if(node.left != null){
                    deque.add(node.left);
                }
          }
        }
        return res;
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
