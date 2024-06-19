package graphs;

/*

https://www.geeksforgeeks.org/problems/topological-sort/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=topological-sort

Guide : https://www.youtube.com/watch?v=73sneFXuTEg&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=22
*/
import java.util.*;

public class TopologicalSortKhansAlogorithm {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
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
        int[] topoSort = new int[V];
        int i = 0;
        //O(V +  E )
        while (!deque.isEmpty()) {
            int node = deque.poll();
            // Add the node, removed to our final ans
            topoSort[i++] = node;

            // Decrease the indegree of the removed node
            for (int neigh : adj.get(node)) {
                indegree[neigh]--;

                // If indegree becomes zero, add it to the Queue for processing
                if (indegree[neigh] == 0) {
                    deque.add(neigh);
                }
            }
        }
        return topoSort;

    }

}
