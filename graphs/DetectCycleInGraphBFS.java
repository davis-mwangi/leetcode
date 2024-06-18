package graphs;

import java.util.*;

/*
https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=detect-cycle-in-an-undirected-graph


Guide: https://www.youtube.com/watch?v=zQ3zgFypzX4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=11
*/

public class DetectCycleInGraphBFS {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];//By default is false
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (detectCycle(i, V, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean detectCycle(int source, int V, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        //Mark as visited
        visited[source] = true;
        Deque<Integer[]> deque = new LinkedList<>();
        deque.add(new Integer[]{source, -1}); //[node, source]

        while (!deque.isEmpty()) {
            //  int size = deque.size();

            //  for(int i = 0; i < size; i++){

            Integer[] pair = deque.poll();
            int node = pair[0];
            int parent = pair[1];

            for (Integer neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    deque.add(new Integer[]{neighbor, node});
                } else if (neighbor != parent) {//If the neighbor is not the source, then there must be a cycle on the graph
                    return true;

                }
            }

            //  }
        }
        return false; //No Cycle
    }
}
