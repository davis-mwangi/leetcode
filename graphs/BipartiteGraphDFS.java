package graphs;

import java.util.*;


/*
Question : https://www.geeksforgeeks.org/problems/bipartite-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=bipartite-graph

Guide: https://www.youtube.com/watch?v=KG5YFfR0j8A&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=18


Time Complexity: O(N +  2E)
Space Complexity: O(N)

*/
class BipartiteGraphDFS {
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] colors = new int[V];
        Arrays.fill(colors, -1);
        for (int i = 0; i < V; i++) {
            if (colors[i] == -1) {// Not assigned any color
                if (!checkBipartiteDFS(i, 0, adj, colors)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkBipartiteDFS(int node, int color, ArrayList<ArrayList<Integer>> adj, int[] colors) {

        colors[node] = color;

        for (int neigh : adj.get(node)) {

            if (colors[neigh] == -1) {// Not assigned color
                if (!checkBipartiteDFS(neigh, (color == 0 ? 1 : 0), adj, colors)) {// Alternate color
                    return false;
                }
            } else if (colors[neigh] == color) {
                return false;
            }
        }
        return true;
    }
}
