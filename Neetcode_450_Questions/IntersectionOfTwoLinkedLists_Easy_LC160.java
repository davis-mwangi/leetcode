package Neetcode_450_Questions;

/*

https://leetcode.com/problems/intersection-of-two-linked-lists/description/

*/
public class IntersectionOfTwoLinkedLists_Easy_LC160 {
    
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    

    public class Solution {
        /*
         * 1.Calculate length of A and B
         * 2. Move A or B by difference,
         * 3. Iterate untill and point both node of A and B will be same.
         * 
         * 
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // Calculate length of A and B
            int a = calculateLen(headA);
            int b = calculateLen(headB);

            // Move A or B by difference
            ListNode currA = headA;
            if (a > b) {
                int diff = a - b;
                while (currA != null && diff > 0) {
                    currA = currA.next;
                    diff--;
                }
            }
            ListNode currB = headB;
            if (b > a) {
                int diff = b - a;
                while (currB != null && diff > 0) {
                    currB = currB.next;
                    diff--;
                }
            }
            // Both will at end at same time if there is intersection
            while (currA != null && currB != null) {
                if (currA == currB) {
                    return currA;
                }
                currA = currA.next;
                currB = currB.next;
            }
            return null;
        }

        private int calculateLen(ListNode head) {
            int len = 0;
            ListNode curr = head;
            while (curr != null) {
                len += 1;
                curr = curr.next;
            }
            return len;
        }

    }
}
