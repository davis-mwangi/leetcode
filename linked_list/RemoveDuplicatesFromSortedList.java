package linked_list;
/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
  
        ListNode prev = head;
        ListNode curr = head;
   
        while(curr != null){
          ListNode next = curr.next;
         
          if(curr.val != prev.val){
            prev = curr;
          }else{
             prev.next = next;
          }
          curr = next;
        }
        return head;
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
