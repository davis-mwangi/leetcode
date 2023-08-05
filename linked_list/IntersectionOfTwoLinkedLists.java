package linked_list;
/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * 
 */
public class IntersectionOfTwoLinkedLists {
    // 
    /**
     * Algorithm:
     *  Find lengths of list A and B
     *  Move the pointer of ther larger list by the diffrence of the two.
     *  Compare the node of A and B are equal, if they are equal  then thats the intersection.
     * 
     * @param headA
     * @param headB
     * @return
     * 
     * Time Complexity: O(a) + O(b) + O(max(a, b))
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a = 0;
        //Calculate length of A
        ListNode currA = headA;
        ListNode currB = headB;
        while(currA != null){
            a += 1;
            currA =  currA.next;
        }
        //Calculate length of B
        int b = 0;
        while(currB != null){
            b += 1;
            currB = currB.next;
        }

        int diff = 0;
        currA = headA;
        currB = headB;
        if(b > a){
           diff = b - a;
           while(currB != null && diff > 0){
               currB = currB.next;
               diff -= 1;
           }
        }
        else if(a > b){
            diff = a - b;
            while(currA != null && diff > 0){
              currA = currA.next;
              diff -= 1;
            }
        }
        while(currA != null &&  currB != null){
            if(currA == currB){
                return currA;
            }
            currA = currA.next;
            currB = currB.next;
        }
        return null;

    }

    /**
     * Approach B
     */

     public class ListNode {
             int val;
             ListNode next;
             ListNode(int x) {
                val = x;
                 next = null;
             }
        }
 
}
