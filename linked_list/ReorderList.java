package linked_list;

/**
 * https://leetcode.com/problems/reorder-list/description/
 * 
 * Guide: https://www.youtube.com/watch?v=S5bfdUTrKLM
 * 
 * Algorithm:
 *  1) Find the  middle of the Linked list using slow and fast technique
 *  2) Reverse the seconf half
 *  3) Merge the the first and second list 
 * 
 * 
 * Time Complexity:  O(n)
 * Space Complexity: O(1)
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        // Fist find middle
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Reverse second half
        ListNode second = slow.next;
        ListNode prev = slow.next = null;

        while (second != null) {
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        // Merge 2 halfs
        ListNode first = head;
        ListNode sec = prev;

        while (sec != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = sec.next;

            first.next = sec;
            sec.next = temp1;
            first = temp1;
            sec = temp2;
        }
    }

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
}
