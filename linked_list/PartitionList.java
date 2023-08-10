package linked_list;
/**
 * https://leetcode.com/problems/partition-list/
 * 
 * Algorithm:
 *   1)Have two  pointers left and right
 *   2) Anything less than x will be added to  left pointer and anything greater than x will be added to right pointer
 *   3) At the end attach left to right and set right to null. 
 */
public class PartitionList {
    
    //Time Complexity: O(n)
    //Space complexity: O(1)
    public ListNode partition(ListNode head, int x) {
        ListNode left=  new ListNode();
        ListNode right = new ListNode();

        ListNode ltail =  left;
        ListNode rtail = right;

        while(head != null){

            if(head.val < x){
                ltail.next = new ListNode(head.val);
                ltail = ltail.next;
            }else{
                rtail.next = new ListNode(head.val);
                rtail = rtail.next;
            }
            head =  head.next;
        }
        rtail.next = null;
        ltail.next = right.next;

        return left.next;
    }

    public class ListNode {
            int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
}
