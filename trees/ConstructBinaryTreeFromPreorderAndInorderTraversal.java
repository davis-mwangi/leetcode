package trees;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    

    //Solution 1
    //[3, 9, 20, 15, 7] preorder [root, left, right]
    //[9, 3, 15, 20, 7] inorder. [left, root, right]
    //Space Complexity:O(n)
    //Time Complexity: O(n)
    public static TreeNode buildTree(int [] preorder, int [] inorder){
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        
        TreeNode parent = new TreeNode(preorder[0]);
        int parentPosition = 0;
        
        //Linear search for parent node on inorder array
        for(int i =0; i < inorder.length; i++){
            if(preorder[0] == inorder[i]){
                parentPosition =  i;
                break;
            }
        }
        
        parent.left =  buildTree(
            Arrays.copyOfRange(preorder, 1, parentPosition + 1 ),
            Arrays.copyOfRange(inorder, 0, parentPosition ));
        
        parent.right =  buildTree(
            Arrays.copyOfRange(preorder, parentPosition + 1, preorder.length), 
            Arrays.copyOfRange(inorder, parentPosition + 1 ,inorder.length )
        );
        
        return parent;
        
    }

    //Solution 2:
    HashMap<Integer, Integer>inorderPositions = new HashMap<>();
    public TreeNode buildTree2(int [ ] preorder, int [ ] inorder)   {

        //Check either is empty
        if(preorder.length < 1 || inorder.length < 1){
            return null;
        }
        
        //Map Inorder values to index {value -> index}
        for(int i=0; i<inorder.length; i++){
            inorderPositions.put(inorder[i], i);
        }

        //Build tree
        return  builder(preorder, 0, 0, inorder.length -1);
    }

    public TreeNode builder(int[] preorder, int preorderIndex, int inorderLow, int inorderHigh) {
        if (preorderIndex > preorder.length-1 || inorderLow > inorderHigh) {
            return null;
        }
        
        int currentVal = preorder[preorderIndex];
        
        TreeNode n = new TreeNode(currentVal);
        
        int mid = inorderPositions.get(currentVal);

        n.left = builder(preorder, preorderIndex+1, inorderLow, mid-1);
        
        n.right = builder(preorder, preorderIndex + (mid - inorderLow) + 1, mid+1, inorderHigh);

        return n;
    }
     
     //Definition for a binary tree node.
     static class TreeNode {
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
