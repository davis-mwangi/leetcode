package graphs;

/*

 Geek for Geeks:  https://www.geeksforgeeks.org/problems/topological-sort/1

 Coding Ninjas:  https://www.codingninjas.com/studio/problems/982938

 */
import java.util.*;

public class TopologicalSortBFS {
    public class Solution {
        /*
         * Input:
         * 2 -> 1
         * 1 -> 0
         * 3 -> 2
         * 0 -> 1
         * 0 -> 2
         * Ouput:
         * 1 -> 0
         * 0 -> 2 -> 1
         * [1,2,2
         * ]
         * 0 1,2
         * 
         */
        public static int[] topologicalSort(ArrayList<ArrayList<Integer>> adj,
                int v, int e) {
            // Write your code here
            int[] indegree = new int[v];
            // Get the indegree of each vertex
            for (int i = 0; i < v; i++) {
                for (int it : adj.get(i)) {
                    indegree[it]++;
                }
            }

            // add your code here
            int[] indegree = new int[v];
            // Get the indegree of each vertex
            for (int i = 0; i < v; i++) {
                for (int it : adj.get(i)) {
                    indegree[it]++;
                }
            }

            Deque<Integer> deque = new LinkedList<>();
            // Push the vertex with 0(zero) indegree to start the iteration
            for (int i = 0; i < v; i++) {
                if (indegree[i] == 0) {
                    deque.add(i);
                }
            }
            int[] topo = new int[v];
            int i = 0;
            while (!deque.isEmpty()) {
                int node = deque.poll();
                topo[i++] = node;

                for (int it : adj.get(node)) {
                    indegree[it]--;
                    if (indegree[it] == 0) {
                        deque.add(it);
                    }
                }
            }
            return topo;

        }
    }

}
