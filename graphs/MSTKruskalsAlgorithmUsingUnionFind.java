package graphs;

/*
https://takeuforward.org/data-structure/kruskals-algorithm-minimum-spanning-tree-g-47/

Guide: https://www.youtube.com/watch?v=DMnDM_sxVig&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=47

*/
import java.util.*;

public class MSTKruskalsAlgorithmUsingUnionFind {
    static class MyComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return Integer.compare(a[1], b[1]);
        }
    }

    // Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        List<int[]> edges = new ArrayList<>();
        // O(N + E)
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int adjNode = adj.get(i).get(j).get(0);
                int wt = adj.get(i).get(j).get(1);
                int node = i;
                int[] temp = new int[] { node, adjNode, wt };
                edges.add(temp);
            }
        }
        UnionFind uf = new UnionFind(V);
        // M log M
        Collections.sort(edges, new MyComparator());
        int mstWt = 0;
        // M x 4 x alpha x 2
        for (int i = 0; i < edges.size(); i++) {
            int wt = edges.get(i)[0];
            int u = edges.get(i)[1];
            int v = edges.get(i)[2];

            if (uf.find(u) != uf.find(v)) {
                mstWt += wt;
                uf.union(u, v);
            }
        }

        return mstWt;
    }

    static class UnionFind {
        int[] parents;
        int[] rank;
        int numOfComponents = 0;

        public UnionFind(int n) {
            this.parents = new int[n];
            this.rank = new int[n];
            this.numOfComponents = n;

            // Initialize parents self nodes
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
                rank[i] = 1;
            }
        }

        public int findComponents(int curr) {
            int parent = find(curr);
            return rank[parent];
        }

        public int find(int curr) {
            if (curr == parents[curr]) {
                return curr;
            }
            // Path Compression
            return parents[curr] = find(parents[curr]);
        }

        public int findIterative(int curr) {
            int root = curr;
            while (root != parents[root]) {
                root = parents[root];
            }

            // Path Compression
            while (curr != root) {
                int preParent = parents[curr];
                parents[curr] = root;
                curr = preParent;
            }
            return root;
        }

        public void union(int node1, int node2) {
            int node1Parent = find(node1);
            int node2Parent = find(node2);

            // Belong to same parent
            if (node1Parent == node2Parent) {
                return;
            }

            // Find parent node with higher rank
            if (rank[node1Parent] > rank[node2Parent]) {
                parents[node2Parent] = node1Parent;
                rank[node1Parent] += rank[node2Parent];
            } else {
                parents[node1Parent] = node2Parent;
                rank[node2Parent] = rank[node1Parent];
            }
            numOfComponents--;

        }
    }
}
