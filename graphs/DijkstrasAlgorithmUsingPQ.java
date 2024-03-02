package graphs;

/*
Coding Ninjas : https://www.codingninjas.com/studio/problems/920469
Geek for Geeks :  https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1 


*/
import java.util.*;

public class DijkstrasAlgorithmUsingPQ {
    class Solution {
        // Function to find the shortest distance of all the vertices
        // from the source vertex S.
        static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
            // Write your code here
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            int[] dist = new int[V];

            // Initialize with infinity values
            Arrays.fill(dist, (int)Math.pow(10,9));

            // Add the first part obviously zero(0), at point zero we have zero distance
            dist[S] = 0;
            pq.add(new int[] { 0, S });

            while (!pq.isEmpty()) {
                int[] pair = pq.poll();
                int dis = pair[0];
                int node = pair[1];

                for (int i = 0; i < adj.get(node).size(); i++) {
                    int adjNode = adj.get(node).get(i).get(0);
                    int edgeWeight = adj.get(node).get(i).get(1);

                    // Check if the curr dist plus edge weight is less that the current edge
                    // distance
                    if ((dis + edgeWeight) < dist[adjNode]) {
                        dist[adjNode] = dis + edgeWeight;
                        pq.add(new int[] { dist[adjNode], adjNode });
                    }
                }

            }
            return dist;
        }
    }

}
