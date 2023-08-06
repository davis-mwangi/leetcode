package linked_list;
/**
 * https://leetcode.com/problems/swapping-nodes-in-a-linked-list/description/
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class SwappingNodesInALinkedList {
   
    public ListNode swapNodes(ListNode head, int k) {
        ListNode curr = head;
        while( k > 1){
            curr = curr.next;
            k -= 1;
        }
        ListNode left = curr;
        ListNode right = head;

        while(curr.next != null){
            curr = curr.next;
            right = right.next;
        }
        int temp = left.val;
        left.val = right.val;
        right.val = temp;

        return head;

    }

    static class ListNode {
            int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
}
