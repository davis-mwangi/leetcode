package Neetcode_450_Questions.MEDIUM;
/*
Question :  https://www.cnblogs.com/lz87/p/7478925.html
Guide : https://www.youtube.com/watch?v=xpXoHCFYC5c&t=15s 


Time Complexity : O(N)
Space Complexity : O(N)
*/
import java.util.*;

public class BinaryTreeVerticalTraversal_Medium_LC314 {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>>res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Deque<Pair>deque = new LinkedList<>(); // {x, node}
        //Add the first elemen (x, node) => (0,0)
        deque.add( new Pair(0, root));
    
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        //Map {x_point : [all items unders x]}
        Map<Integer, List<Integer>>map = new HashMap<>();//{ 0 :[3]}
        
        while( !deque.isEmpty() ){
            Pair pair = deque.poll();
            int x = pair.x;
            TreeNode node = pair.node;
    
            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
    
            //Add items to the map
            if(!map.containsKey(x)){
                map.put(x, new ArrayList<>());
            }
            map.get(x).add(node.val);
    
             if(node.left != null){
                deque.add(new Pair(x - 1, node.left));
             }
             if(node.right != null){
                deque.add(new Pair(x  + 1, node.right));
             }
        }
    
        for(int i = minX; i <= maxX; i++){
            res.add(map.get(i));
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
    
    
    static class Pair{
       public  int x;
       public  TreeNode node;
    
        public Pair(int x, TreeNode node){
            this.x = x;
            this.node = node;
        }
    }
}
