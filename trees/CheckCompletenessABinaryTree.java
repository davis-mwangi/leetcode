package trees;
import java.util.*;

/*
https://leetcode.com/problems/check-completeness-of-a-binary-tree/

The algorithm is we check for completenes, if we ever find a null value  when perfoming a BFS
all other nodes should be null else its not complete binary tree

In a complete binary tree, every level, except possibly the last, is completely filled, 
and all nodes in the last level are as far 
left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

Standard BFS (Breadth First Search Approach)

Approach is to maintain one flag variable and check whether we encountered any NULL value or not.
If we encounter any NULL value then we set flag as true.
Suppose if after that we encounter any value other than NULL. Then this means that the tree is not complete and hence we return false.
It means that the all the leaf nodes are not left alignd. Hence answer is false otherwise simply return true.

Time Complexity: O(n)
Space Complexity:O(n)
*/
public class CheckCompletenessABinaryTree {
    

    public boolean isCompleteTree(TreeNode root) {
        if(root == null){
            return true;
        }
        
       Deque<TreeNode>deque = new LinkedList<>();
       deque.add(root);
       int foundNull = 0;

       while(!deque.isEmpty()){

         TreeNode node = deque.poll();
         if(node == null){
             foundNull = 1;
         }else{
             //If we encountered null in the past then the binary tree in not complete
             if(foundNull == 1){
                 return false;
             }
            deque.add(node.left);
            deque.add(node.right);
         }

       }
       return true;

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
