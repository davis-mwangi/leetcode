package trees;
import java.util.*;
/* 
https://leetcode.com/problems/maximum-width-of-binary-tree/description/


*/
public class MaximumWidthOfBinaryTree {

    //Time Complexity: O(n)
    //Space Complexity:O(n)
   public int widthOfBinaryTree(TreeNode root) {
        Deque<Data>deque= new LinkedList<>();
        deque.add( new Data(root, 1, 0) );//{node, num, level}

        int prevLevel = 0;
        int firstInRow = 1;
        int res = 0;

        while(!deque.isEmpty()){

            Data data = deque.pollFirst();

            TreeNode node = data.node;
            Integer num = data.num;
            Integer level = data.level;

            //Start of a new level
            if(level > prevLevel){
                prevLevel = level;
                firstInRow =  num;
            }
            res = Math.max(res, (num - firstInRow + 1) );

            if(node.left != null){
                deque.add( new Data(node.left, num * 2, level +1) );
            }
            if(node.right != null){
                deque.add(new Data(node.right, num * 2 + 1, level + 1) );
            }

        }
        return res;
    }

    static class Data {
        public TreeNode node;
        public Integer num;
        public Integer level;

        public Data(TreeNode node, Integer num, Integer level){
            this.node = node;
            this.num = num;
            this.level= level;
        }
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
