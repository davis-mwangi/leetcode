package Neetcode_450_Questions.MEDIUM;

/*
https://leetcode.com/problems/construct-binary-tree-from-string/description/

You need to construct a binary tree from a string consisting of parenthesis and integers.

The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.

You always start to construct the left child node of the parent first if it exists.

           4
         /    \
        2      6
      /   \   /
     3     1 5 

Example 1:     

Input: s = "4(2(3)(1))(6(5))"
Output: [4,2,6,3,1,5]


Example 2:
Input: s = "4(2(3)(1))(6(5)(7))"
Output: [4,2,6,3,1,5,7]

Example 3:
Input: s = "-4(2(3)(1))(6(5)(7))"
Output: [-4,2,6,3,1,5,7]
 

Constraints:

0 <= s.length <= 3 * 104
s consists of digits, '(', ')', and '-' only.  
*/
import java.util.*;

public class ConstructBinaryTreeFromString_LC536 {

    // Definition for a binary tree node.
    //TC: O(N)  where N is length of the String 
    //SC : O(N)  , we are using a tack
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public TreeNode str2tree(String s) {
            // Check for null or empty string
            if (s == null || s.length() == 0) {
                return null;
            }
            Stack<TreeNode> stack = new Stack<TreeNode>();
            int idx = 0;
            int n = s.length();

            while (idx < n) {
                char ch = s.charAt(idx);
                // Case when char is digit or operator (-)
                if (Character.isDigit(ch) || ch == '-') {
                    // Handle case where number has more than 1 digit
                    int j = idx + 1;
                    while (j < n && Character.isDigit(s.charAt(j))) {
                        j++;
                    }
                    int nodeVal = Integer.parseInt(s.substring(idx, j));
                    System.out.println(nodeVal);

                    // Create TreeNode
                    TreeNode node = new TreeNode(nodeVal);
                    // Check if stack has an item , thich the new node might be its left or right
                    // child;
                    if (!stack.isEmpty()) {
                        TreeNode parent = stack.peek();
                        if (parent.left == null) {
                            parent.left = node;
                        } else {
                            parent.right = node;
                        }
                    }
                    stack.add(node);
                    idx = j;
                    continue;

                } else if (ch == ')') {
                    stack.pop();
                }
                idx++;
            }
            return stack.pop();
        }
    }
}
