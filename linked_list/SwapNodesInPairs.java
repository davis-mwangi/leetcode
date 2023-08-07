package linked_list;

/**
 * https://leetcode.com/problems/swap-nodes-in-pairs/description/
 * 
 * Algorithm:
 *   Treat each as pair which  needs to be reversed,
 *     on every iteration we reverse the set then point to the next set
[x]-> [1] -> [2] ->[3] ->[4]
 *     {       }   {       }
 *     We will need a dummy node to minimize the edge cases
 *     First reserve pointers
 *     [1]-------->[3]
 *     [1]->[2]
 * 
 *      Reverse Pair
 *      [2]->[1]
 *      [1]->[3]
 *      [x]->[2]
 *     
 *      Update Pointers
 *      [x]=[1]
 *      [2]=[3]
 *      
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy =  new ListNode(0, head);
        ListNode prev =  dummy;
        ListNode curr = head;

        while(curr != null && curr.next != null){
            //Save Pointers
            ListNode nextPair =  curr.next.next;
            ListNode second = curr.next;

            // Reverse current pair
            second.next =  curr;
            curr.next =  nextPair;
            prev.next = second;

            //Update Pointers
            prev =  curr;
            curr =  nextPair;
        }
        return dummy.next;
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
