package trees;
import java.util.*;

/**
 * https://leetcode.com/problems/find-duplicate-subtrees/
 * 
 * We can solve this problem but serializing the values factoring in the null values, 
 * We create a hash of string and list of nodes that has same hash
 * we only check if the string has single node since we just need one duplicate.
 * 
 * Time Complexity: O(n^2)
 */
public class FindDuplicateSubtrees {

    List<TreeNode>res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String,List<TreeNode>>map = new HashMap<>();
        preorder(root, map); 
        return res;
    }
    private String preorder(TreeNode node, Map<String, List<TreeNode>>map ){
        if(node == null){
            return "N";
        }
        StringBuilder sb = new StringBuilder();

        String s = sb.append(""+node.val).append(",")
                .append( preorder(node.left, map) ).append(",")
                .append( preorder(node.right, map) ).toString();

        if(map.containsKey(s) && map.get(s).size() == 1) {
            res.add(node);
        }  
        List<TreeNode>lst = map.getOrDefault(s, new ArrayList<>());
        lst.add(node);
        map.put(s, lst);
        return s;
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
