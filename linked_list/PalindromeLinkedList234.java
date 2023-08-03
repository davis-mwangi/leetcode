package linked_list;
import java.util.*;
/**
 * https://leetcode.com/problems/palindrome-linked-list/description/
 * 
 * The First approach is to use an array, add the nodes to an array then use two pointers to check for Palindrome.
 * The second approach is to use pointers with the following steps:
 * 1) Use fast & slow pointers to get the middle point
 * 2) Reverse the remaining bit from mid(slow pinter) to the end
 * 3) Check if the linked list is palindrome.
 */
public class PalindromeLinkedList234 {
    //Converting to an array and using two pointers
     //Time Complexity: O(n)
     //Space Complexity: O(n)
     public boolean isPalindrome2(ListNode head) {
        List<Integer>nums = new ArrayList<>();
        while(head != null){
            nums.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right =  nums.size() -1;
        while(left <= right){
            if(nums.get(left) != nums.get(right)){
                return false;
            }
            left  += 1;
            right -= 1;
        }
        return true;
        
    }

    //Slow and Fast pointers
    //Time Complexity:  O(n)
    //Space Complexity: O(1)
    public boolean isPalindrome(ListNode head) {
        ListNode slow =  head;
        ListNode fast =  head;

        //The slow pointer will be at middle
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow =  slow.next;      
        }

         //Reverse from midle to the end(remainig slow pointer)
        ListNode prev = null;
        while(slow != null){
            ListNode next = slow.next;
            slow.next = prev; 
            prev = slow;
            slow =  next; 
        }
        //Check for Valid Palindrome
        ListNode left = head;
        ListNode right = prev;

        while(right != null){
            if(left.val != right.val){
                return false;
            }
            right = right.next;
            left  = left.next;
        }
        return true;
    }

     //Definition for singly-linked list.
     static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
}
