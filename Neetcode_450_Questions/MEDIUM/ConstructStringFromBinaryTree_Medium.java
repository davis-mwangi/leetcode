package Neetcode_450_Questions.MEDIUM;

public class ConstructStringFromBinaryTree_Medium {

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
        public String tree2str(TreeNode root) {
            String ans = preorder(root);
            return ans.substring(1, ans.length() - 1);
        }

        public String preorder(TreeNode root) {
            if (root == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(root.val);
            if (root.left == null && root.right != null) {
                sb.append("(").append(")");
            }
            return sb.append(preorder(root.left))
                    .append(preorder(root.right))
                    .append(")").toString();
        }
    }
}
