package linked_list;
/**
 * https://leetcode.com/problems/remove-linked-list-elements/description/
 * 
 * 
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            if(curr.val == val){
                prev.next = next;
            }else{
                prev = curr;
            }
            curr = next;
        }
        return dummy.next;
    }

    // Definition for singly-linked list.
     static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
