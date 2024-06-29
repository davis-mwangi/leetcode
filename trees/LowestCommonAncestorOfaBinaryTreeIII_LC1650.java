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

    // SC : O(1) ~ O(N) Auxiliary stack space
    // TC : O(N)
    /*
     * Move up to the parent if , it becomes null reset to the other node,
     * This will ensure they travel up the same distance to get to the parent node
     * 
     */
    // Solution 2:

    public Node lowestCommonAncestor2(Node p, Node q) {
        // Checks
        if (p == null || q == null) {
            return null;
        }
        Node curr = p;
        // Move up until you reach the parent
        while (curr.parent != null) {
            curr = curr.parent;
        }

        return find(p, q, curr);
    }

    private Node find(Node p, Node q, Node root) {
        if (root == null) {
            return null;
        }
        if (p == root || q == root) {
            return root;
        }

        Node left = find(p, q, root.left);
        Node right = find(p, q, root.right);

        // Post Order
        // Both return a value
        if (left != null && right != null) {
            return root;
        }
        // Either, left or right return a value
        return left == null ? right : left;
    }

}
