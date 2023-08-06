package linked_list;
import java.util.*;
/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/description/
 * 
 * Algorithm:
 *   Use two passes
 *   Pass 1:  map old nodes to new nodes using a hashmap
 *   Pass 2:  Link the maps nodes to the respective pointers(next & random pointers)
 */
public class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;
    
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node,Node>oldToCopyMap = new HashMap<>();

        //For cases where random is pointing to null
        oldToCopyMap.put(null, null);

        Node curr = head;
        
        while(curr != null){
            Node copy = new Node(curr.val);
            oldToCopyMap.put(curr, copy);
            curr = curr.next;
        }

        curr = head;
        while(curr != null){
            Node copy =  oldToCopyMap.get(curr);
            copy.next =  oldToCopyMap.get(curr.next);
            copy.random = oldToCopyMap.get(curr.random);
            curr = curr.next;
        }
        return oldToCopyMap.get(head);
    }
}
