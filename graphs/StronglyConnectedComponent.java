package graphs;

/*
Question:

LeetCode: https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/description/
Coding Ninjas: 

YouTube: https://www.youtube.com/watch?v=V8qIqJxCioo

https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/solutions/766485/kosaraju-algorithm-on/

Kosaraju Algorithm O(N):
1) Sort all nodes in order of finishing time
2) Transpose the graph (Reverse the graph)
3) Do DFS according to finishing time.


Timme Complexity : O(N + E)
Space Complexity: O(N + E) + O(N) + O(N)

*/
import java.util.*;

class StronglyConnectedComponent {
    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(1).add(3);

        adj.get(3).add(4);
    }

    private void kosaraju(List<List<Integer>> adj, int n) {
        int[] visited = new int[n];

        // 1. Sort all nodes in order of finishing time using Topological sort
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i, stack, adj, visited);
            }
        }
        // 2. Transponse / Reverse the graph.
        List<List<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            transpose.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            visited[i] = 0;
            for (Integer it : adj.get(i)) {
                transpose.get(it).add(i);
            }
        }

        // 3. Do DFS according to finishing time.
        while (stack.size() > 0) {
            int node = stack.peek();
            stack.pop();
            if (visited[node] == 0) {
                System.out.println("SCC: ");
                revDfs(node, transpose, visited);
                System.out.println();
            }
        }
    }

    private void revDfs(int node, List<List<Integer>>transpose, int[] visited){
        visited[node] = 1;
        for(Integer it: transpose.get(node)){
            if(visited[it] == 0){
                revDfs(node, transpose, visited);
            }
        }
    }
    private void dfs(int node, Stack<Integer>stack, List<List<Integer>>adj, int[] visited){
       visited[node] = 1;
       for(Integer it: adj.get(node)){
           if(visited[it] == 0){
               dfs(node, stack, adj, visited);
           }
       }
    }

}