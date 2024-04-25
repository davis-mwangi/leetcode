package Neetcode_450_Questions;
/*

https://leetcode.com/problems/remove-linked-list-elements/description/

*/
public class RemoveLinkedListElements_easy_LC203 {
 
 // Definition for singly-linked list.
 public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy.next;
        ListNode prev = dummy;
        while(curr != null){
              ListNode next = curr.next;
              if(curr.val == val){
                 prev.next = next;
                 curr =  next;
              }else{
                prev = curr;
                curr = next;
              }
        }
        return dummy.next;
    }
}
}
