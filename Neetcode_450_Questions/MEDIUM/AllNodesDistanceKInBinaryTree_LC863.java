package Neetcode_450_Questions.MEDIUM;

/*

https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/

Guide:  https://www.youtube.com/watch?v=2IHdqU48N2w

*/
import java.util.*;

public class AllNodesDistanceKInBinaryTree_LC863 {

    // Definition for a binary tree node.

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
     * {0=[1], 1=[3, 0, 8], 2=[5, 7, 4], 3=[5, 1], 4=[2], 5=[3, 6, 2], 6=[5], 7=[2],
     * 8=[1]}
     * 
     * 
     * TC: O(N)
     * SC: O(N) +O(N) O(N) -> O(N)
     */

    class Solution {
        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            // 1.Construct and adjacency List // {node: [neigh1,neigh2 ....]}
            Map<Integer, List<Integer>> adj = new HashMap<>();

            buildGraph(root, adj);

            // Perform BFS on the Graph starting from target
            List<Integer> res = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();
            Deque<int[]> deque = new LinkedList<>();

            // Add the start node
            deque.add(new int[] { target.val, 0 }); // [node, dist]
            visited.add(target.val);

            while (!deque.isEmpty()) {
                int[] curr = deque.poll();
                int node = curr[0];
                int dist = curr[1];

                // If node is k dist from origin, add it to result,
                // We dont need to continue further from this node
                // We continue processing the others
                if (dist == k) {
                    res.add(node);
                    continue;
                }

                // Add All unvisited neighbors of the current node to the Queue
                for (Integer neigh : adj.getOrDefault(node, new ArrayList<>())) {
                    if (!visited.contains(neigh)) {
                        visited.add(neigh);
                        deque.add(new int[] { neigh, dist + 1 });
                    }
                }

            }
            return res;
        }

        private void buildGraph(TreeNode root, Map<Integer, List<Integer>> adj) {
            Deque<TreeNode> deque = new LinkedList<>();
            deque.add(root);

            while (!deque.isEmpty()) {
                TreeNode node = deque.poll();
                // LEft Node
                if (node.left != null) {
                    // Parent -> child mapping
                    if (!adj.containsKey(node.val)) {
                        adj.put(node.val, new ArrayList<>());
                    }
                    adj.get(node.val).add(node.left.val);

                    // Child ->. Parent mapping
                    if (!adj.containsKey(node.left.val)) {
                        adj.put(node.left.val, new ArrayList<>());
                    }
                    adj.get(node.left.val).add(node.val);

                    // Add left node to Queue
                    deque.add(node.left);
                }
                // Right Node
                if (node.right != null) {
                    // Parent -> child
                    if (!adj.containsKey(node.val)) {
                        adj.put(node.val, new ArrayList<>());
                    }
                    adj.get(node.val).add(node.right.val);

                    // Child -> Parent
                    if (!adj.containsKey(node.right.val)) {
                        adj.put(node.right.val, new ArrayList<>());
                    }
                    adj.get(node.right.val).add(node.val);

                    deque.add(node.right);
                }

            }
        }
    }
}
