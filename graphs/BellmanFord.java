package graphs;

/*
https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/0?fbclid=IwAR2_lL0T84DnciLyzMTQuVTMBOi82nTWNLuXjUgahnrtBgkphKiYk6xcyJU

Given a weighted and directed graph of V vertices and E edges,
 Find the shortest distance of all the vertex's from the source vertex S. 
 If a vertices can't be reach from the S then mark the distance as 10^8. 
 
 Note: If the Graph contains a negative cycle then return an array consisting of only -1.

Detect negative cycle.
- To detect negative cycle if the distance continue to reduce, then its a cycle
  else it could have stoped at N-1 iterations;

*/
import java.util.*;

class BellmanFord {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int[] dist = new int[V];
        int infinity = (int) Math.pow(10, 8);
        Arrays.fill(dist, infinity);
        dist[S] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);

                if (dist[u] != infinity && (dist[u] + wt) < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Nth relaxation to check negative cycle, if in the Nth iteration the distance stilll reduces
        // it has a negative cycle.
        for (ArrayList<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            if (dist[u] != infinity && (dist[u] + wt) < dist[v]) {
                return new int[] { -1 };
            }
        }
        return dist;
    }
}