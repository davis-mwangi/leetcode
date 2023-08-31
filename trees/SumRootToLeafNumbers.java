package trees;

import trees.ValidateBinarySearchTree.TreeNode;

/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * 
    Time complexity: O(V) where V is the number of vertices
    Space complexity: O(h) where h is the height of the tree
 */
public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root){
      int res = 0;
      res = dfs(root, res);
      return res;

    }
    private int dfs(TreeNode node, int currentPath){
        //Base case, if no node then return 0
        if(node == null){
            return 0;
        }
        //Add current node value to the current path
        //(multiply by 10 to move decima to the right by 1)
        currentPath = (currentPath * 10) + node.val;

        //If at leaf node,return solution
        if(node.left == null &&  node.right == null){
              return currentPath;
        }
        //Check find th leaf nodes on the left and right
        return  dfs(node.left, currentPath) + 
             dfs(node.right, currentPath);
    }
    
}
