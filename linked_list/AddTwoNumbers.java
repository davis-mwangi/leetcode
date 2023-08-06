package linked_list;
/**
 * https://leetcode.com/problems/add-two-numbers/
 * 
 * Agorithm:
 * Use a  dummy node
 *  Whenever the value is greater than 9 we divide the value by 10 to get the carry value.
 * 
 * One adge case is when  the  nodes have exhausted on l1 and l2 and there is a carry value, 
 * if there is a carry value we add the extra node..
 */
public class AddTwoNumbers {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int carry = 0;
        while( (l1 != null) || (l2 != null) || (carry != 0) ){
          //case where the pointers reach the end
          int val1 = l1 != null ? l1.val : 0;
          int val2 = l2 != null ? l2.val : 0;

          //sum values
          int sum = val1 + val2 + carry;
          carry = sum / 10;
          int val = sum % 10;

          curr.next = new ListNode(val);

          //Update pointers
          curr = curr.next;
          l1 = l1 != null ? l1.next :null;
          l2 = l2 != null ? l2.next : null;
          
        }
        return dummy.next;
    }

     public class ListNode {
            int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
}
