package linked_list;
/**
 * 
 * https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/
 * 
 *  Algorithm:
   find Middle
   Reverse second half
   Check the max sum of twins

   Time Complexity: O(n)
   Space Complexity: O(1)
 */
public class MaximumTwinSumOfALinkedList {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode sec = slow.next;
        ListNode prev = null;
        while(sec != null){
            ListNode next = sec.next;
            sec.next = prev;
            prev = sec;
            sec = next;
        }
        int max = Integer.MIN_VALUE;
        ListNode f = head;
        ListNode s = prev;
        while(s != null){
            int sum = f.val + s.val;
            max = Math.max(max, sum);
            f = f.next;
            s = s.next;
        }
        return max;

    }

     static class ListNode {
             int val;
            ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
}
