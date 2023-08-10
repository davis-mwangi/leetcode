package linked_list;

/**
 * https://leetcode.com/problems/rotate-list/description/
 * 
 * YouTube: https://www.youtube.com/watch?v=UcGtPs2LE_c
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length += 1;
        }
        // Make the list Cyclic
        tail.next = head;
        // Handle case where k > length
        k = k % length;
        k = length - k;
        if (k == 0) {
            return head;
        }
        // Get pivot
        while (k > 0) {
            tail = tail.next;
            k -= 1;
        }
        head = tail.next;
        tail.next = null;

        return head;
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
