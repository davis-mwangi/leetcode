package trees;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * 
 * 
 */
public class SerializeAndDeserializeBinaryTree {
     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    
    public class Codec {
    
    List<String>list = new ArrayList<>();
    

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
       
        dfsSerialize(root);
        
        return String.join(",", list);
        
    }
    //Preorder tranversal
    public void dfsSerialize(TreeNode node){
        if(node == null){
            list.add("N");
            return;
        }
        list.add(""+ node.val);
        dfsSerialize(node.left);
        dfsSerialize(node.right);     
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //Create list
        String [] raw = data.split(",");
      
        return  dfsDeserialize(raw);     
    }
    
    int i = 0;
    public TreeNode dfsDeserialize(String [] raw){
        
        if(raw[i].equals("N")){
             i++;
            return null;
        }
        
        int val = Integer.parseInt(raw[i]);
        TreeNode node = new TreeNode(val);
        
        i++;
        
        node.left = dfsDeserialize(raw);
        node.right = dfsDeserialize(raw);
        
        return node;
        
    }
}
}
