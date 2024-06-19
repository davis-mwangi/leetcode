package graphs;

import java.util.*;

public class DetectCycleUsingTopoSortKhansAlgo {
    static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        // Populate the indegree
        for (int i = 0; i < V; i++) {
            for (int neigh : adj.get(i)) {
                indegree[neigh]++;
            }
        }

        // Add all nodes with indegreee of Zero
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                deque.add(i);
            }
        }
        int count = 0;
        int i = 0;
        //O(V +  E )
        while (!deque.isEmpty()) {
            int node = deque.poll();
            // Add the node, removed to our final ans
            count += 1;

            // Decrease the indegree of the removed node
            for (int neigh : adj.get(node)) {
                indegree[neigh]--;

                // If indegree becomes zero, add it to the Queue for processing
                if (indegree[neigh] == 0) {
                    deque.add(neigh);
                }
            }
        }
        //If we able to form toposort with all numbers then, no cycle else there is a cycle
        return count == V;

    }
}
