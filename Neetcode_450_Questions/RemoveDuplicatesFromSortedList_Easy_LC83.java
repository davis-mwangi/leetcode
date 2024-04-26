package Neetcode_450_Questions;

/*
https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/

*/
public class RemoveDuplicatesFromSortedList_Easy_LC83 {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode curr = dummy.next;
            ListNode prev = dummy.next;

            while (curr != null) {
                ListNode next = curr.next;

                if (prev.val != curr.val) {
                    prev = curr;
                } else {
                    prev.next = next;
                }
                curr = next;

            }
            return dummy.next;

        }
    }
}
