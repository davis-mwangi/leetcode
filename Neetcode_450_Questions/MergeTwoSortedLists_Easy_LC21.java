package Neetcode_450_Questions;

/*
https://leetcode.com/problems/merge-two-sorted-lists/description/

*/
public class MergeTwoSortedLists_Easy_LC21 {

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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode(0);
            ;

            ListNode curr = dummy;

            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    curr.next = new ListNode(list1.val);
                    list1 = list1.next;
                } else {
                    curr.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
                curr = curr.next;
            }

            // Case where list1 and list 2 are of unequal length
            if (list1 != null) {
                curr.next = list1;
            }

            if (list2 != null) {
                curr.next = list2;
            }
            return dummy.next;

        }
    }
}
