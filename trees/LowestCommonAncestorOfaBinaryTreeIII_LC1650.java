package trees;
/*

Question : https://leetcode.ca/all/1650.html
Guide : https://www.youtube.com/watch?v=vZxxksAP8yk

        https://leetcode.ca/2020-06-06-1650-Lowest-Common-Ancestor-of-a-Binary-Tree-III/

Given two nodes of a binary tree p and q, return their lowest common ancestor (LCA).

Each node will have a reference to its parent node. The definition for Node is below:
*/
import java.util.*;
public class LowestCommonAncestorOfaBinaryTreeIII_LC1650 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
   // TC : O(N)
   // SC : O(N)
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> set = new HashSet<Node>();
        Node temp = p;
        while (temp != null) {
            set.add(temp);
            temp = temp.parent;
        }
        temp = q;
        while (temp != null) {
            if (set.contains(temp))
                break;
            else
                temp = temp.parent;
        }
        return temp;
    }
   
    // SC : O(1)
    // TC : O(N)
    /*
   Move up to the parent if , it becomes null reset to the  other node,
   This will ensure they travel up the same distance to get to the parent node

    */
    public Node lowestCommonAncestor2(Node p, Node q) {
       Node pCopy = p;
       Node qCopy = q;

       while(p != null && q != null){
           p =  p.parent == null ? qCopy : p.parent;
           q =  q.parent == null ? pCopy : q.parent;
       }
       return pCopy;
    }

}
