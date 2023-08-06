package linked_list;
import java.util.*;
/**
 * https://leetcode.com/problems/linked-list-cycle/description/
 */
public class LinkedListCycle {
    
    //Using Floyd's Hare and Tortoise technique(Slow & fast pointers)
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }


    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode curr = head;
        while (curr != null) {
            if (set.contains(curr)) {
                return true;
            }
            set.add(curr);
            curr = curr.next;
        }
        return false;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
