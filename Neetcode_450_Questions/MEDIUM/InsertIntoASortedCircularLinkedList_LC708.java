package Neetcode_450_Questions.MEDIUM;

/*
Question : https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/description/
Guide :  https://www.youtube.com/watch?v=XN9OsmP2YTk&t=796s



*/
public class InsertIntoASortedCircularLinkedList_LC708 {

    class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };

    class Solution {
        /*
         * Insertion Cases
         * 1. head is null head = null
         * 2. Normal insertion E.g [3,4, 1] and insert val is 2
         * 3. Insert on edge i.e Either a bigger value than current or a lesser value
         * than the next value
         * 4. Unified Linked list,all values are the same E.g 3, 3, 3, 3, 3
         * 
         * Time Complexity : O(N)
         * Space Complexity: O(1)
         * 
         * [3, 5, 1] 3 -> 5 -> 1 k = 0
         * 
         * [3,5,1,0]
         */
        public Node insert(Node head, int insertVal) {
            // Case 1: When head is null, create a new node and return
            if (head == null) {
                Node newNode = new Node(insertVal);
                newNode.next = newNode; // create circular node
                return newNode;
            }
            // Head is not null
            // Since the linked list is circular, we compare with head to know when to stop
            Node curr = head;

            while (curr.next != head) {
                // Case 2.Normal insertion E.g inserting btween 2 between 1 and 3 i.e 3 -> 4 ->
                // 1 -> 3 k = 2
                if (curr.val <= insertVal && insertVal <= curr.next.val) {
                    Node newNode = new Node(insertVal, curr.next);
                    curr.next = newNode;
                    return head;
                    // Case 3: we insert on edge of the sorted linked list(Edge is where the next
                    // value is smaller than current value)
                    // E.g inserting 9 in 3 -> 4 -> 1 -> 3 k = 9, will insert between 4 and 1
                    // Or insert a value less than next value E,g inserting zero(0)
                } else if (curr.val > curr.next.val) {
                    if (insertVal >= curr.val || insertVal <= curr.next.val) {
                        Node newNode = new Node(insertVal, curr.next);
                        curr.next = newNode;
                        return head;
                    }

                }
                curr = curr.next;
            }
            // Case 4. all are nodes are same we can insert anywhere
            Node newNode = new Node(insertVal, curr.next);
            curr.next = newNode;
            return head;
        }
    }
}
