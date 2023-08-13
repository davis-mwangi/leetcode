package linked_list;
/**
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * 
 * YouTube:  https://www.youtube.com/watch?v=RF_M9tX4Eag
 * 
 */
public class ReverseLinkedListII {
    /**
    [x]->[1]->[2]->[3]->[4]->[5]->NULL
     l
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //Reach node at position left 
        ListNode dummy = new ListNode(0, head);
        ListNode prevLeft = dummy;
        ListNode curr = head;
        int i = left - 1;
        while(i > 0){
            prevLeft = curr;
            curr = curr.next;
            i -= 1;
        }
 
        // curr = left, prevLeft= node before left
        //Reverse from left tp right
        ListNode prev = null;
        i = right -left + 1;
        while(i > 0){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i -= 1;
        }
        //Update Pointers 
        prevLeft.next.next = curr;// curr is node after right
        prevLeft.next = prev; // prev is right
 
        return dummy.next;
     }

      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
}
