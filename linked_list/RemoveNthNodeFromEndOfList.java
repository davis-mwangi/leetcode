package linked_list;
/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 * 
 * Use two pointers and maintain a diff of n 
 * Use a dummy node to avoid dealing with many edge cases
 * When  right pointers getsto the end shift the next pointer skipping the nth node.
 */
public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode();
        dummy.next = head;
 
        ListNode left = dummy;
        ListNode right = head;
 
        while(n > 0 && right != null){
            right = right.next;
            n -= 1;
        }
        while(right != null){
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return dummy.next;
     }


  //Definition for singly-linked list.
  public class ListNode {
      int val;
     ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
