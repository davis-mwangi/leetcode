package Neetcode_450_Questions;
/*

https://leetcode.com/problems/reverse-linked-list/description/
*/
public class ReverseLinkedList_Easy_LC206 {

    
  //Definition for singly-linked list.
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {

    //Time Complexity :  O(N)
    //Space Complexity : O(1)
    public ListNode reverseList(ListNode head) {
         ListNode curr = head;
         ListNode prev = null;

         while (curr != null){
              ListNode next = curr.next;
              curr.next = prev;
              prev = curr;
              curr =  next;
         }
         return  prev;
    }
}
}
