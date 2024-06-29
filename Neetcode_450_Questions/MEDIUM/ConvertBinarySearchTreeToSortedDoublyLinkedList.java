package Neetcode_450_Questions.MEDIUM;
/*

Question : https://leetcode.ca/all/426.html
Guide : https://www.youtube.com/watch?v=l1hSUOaXLxc&t=1s

*/
public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    class Node {
        public int val;
        public Node left;
        public Node right;
    
        public Node() {}
    
        public Node(int _val) {
            val = _val;
        }
    
        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
