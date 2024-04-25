package Neetcode_450_Questions;
/*
https://leetcode.com/problems/palindrome-linked-list/description/
*/
public class PalindromeLinkedList_Easy_LC234 {
 
 // Definition for singly-linked list.
 public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 
class Solution {
    /*
    1 -> 1 -> 2 -> 1
    1 -> 2 -> 1 -> 1
    1.Reverse 
    2. Check palindrome
    */
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow =  head;
        while(fast != null && fast.next != null ){
            fast =  fast.next.next;
            slow = slow.next;
        }
        // Revesed the first half
        ListNode second = reverseList(slow);
        //Compare the first and second half
        ListNode first = head;
        while(second != null && first != null){
            if(first.val != second.val){
                return false;
            }
            first = first.next;
            second = second.next;
        }
        return true;
    }

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
