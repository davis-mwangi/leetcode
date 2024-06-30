package Neetcode_450_Questions.MEDIUM;

/*

Question : https://leetcode.ca/all/426.html
Guide : https://www.youtube.com/watch?v=l1hSUOaXLxc&t=1s

*/
import java.util.*;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    class Solution {

        Node first = null;
        Node last = null;

        public Node treeToDoublyList1(Node root) {
            if (root == null) {
                return null;
            }

            inorder(root);

            // Conect to form a cycle
            last.right = first;
            first.left = last;

            return first;
        }

        private void inorder(Node curr) {
            if (curr == null) {
                return;
            }

            // left call
            inorder(curr.left);

            // Process node
            if (last != null) {
                // Link previous node (last) to current
                // Link current node(curr) to previous (last)
                last.right = curr;
                curr.left = last;
            } else {
                // Keep the smallest node
                first = curr;
            }

            last = curr;

            // Right call
            inorder(curr.right);
        }

        // Iterative Solution

        // Standard iterative in-order traversal of a binary tree. For this problem we
        // maintain a prevNode to make the connections for the doubly linked list (keep
        // connecting prevNode and currNode), and we have a reference to firstNode so
        // that we can make the doubly linked list circular in the end. The resulting
        // doubly linked list is sorted because we do an in-order traversal in a binary
        // search tree.
        // O(n) time where n is the total number of nodes in the given binary search
        // tree, because we process every node in the tree exactly once in O(1) time.
        // O(n) space, because given an unbalanced tree we will have n elements on the
        // stack simultaneously.
        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return root;
            }

            Node firstNode = null, prevNode = null, currNode = root;
            Deque<Node> stack = new ArrayDeque<>();
            while (stack.size() > 0 || currNode != null) {

                while (currNode != null) {
                    stack.addFirst(currNode);
                    currNode = currNode.left;
                }

                currNode = stack.removeFirst();
                // Special case for the first node that the in-order traversal processes because
                // we want to have a reference to the first node so that we can make the dobuly
                // linked list circular later by connecting the first and last nodes.
                if (prevNode == null) {
                    firstNode = currNode;
                } else {
                    // Connect prevNode and currNode
                    prevNode.right = currNode;
                    currNode.left = prevNode;
                }
                prevNode = currNode;

                currNode = currNode.right;
            }

            // Make the sorted doubly linked list circular by connecting the first and last
            // nodes. Note that prevNode is the last element that the iterative in-order
            // traversal processed and therefore it is the greatest/last element in the
            // sorted doubly linked list.
            firstNode.left = prevNode;
            prevNode.right = firstNode;

            return firstNode;
        }
    }
}
