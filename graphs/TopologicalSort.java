package graphs;
/*

Given an adjacency list for a Directed Acyclic Graph (DAG) where adj_list[i] contains
 a list of all vertices j such that there is a directed edge from vertex i to vertex j, 
 with  V  vertices and E  edges, your task is to find any valid topological sorting of the graph.


In a topological sort, for every directed edge u -> v,  u must come before v in the ordering.

https://www.geeksforgeeks.org/problems/topological-sort/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=topological-sort

Guide : https://www.youtube.com/watch?v=5lZ0iJMrUMk&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=21
*/
import java.util.*;
class TopologicalSort
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        int [] visited = new int[V];
        Arrays.fill(visited, -1);
        Stack<Integer>stack = new Stack<>();//LiFo
        for(int i = 0; i < V; i++){
            if(visited[i] == -1){//Not visited
                 dfs(i, adj, stack, visited);
            }
        }
        //Result 
        int[] ans = new int[stack.size()];
        int i = 0;
        while( !stack.isEmpty() ){
            ans[i] = stack.pop();
            i++;
        }
        return ans;
        
    }
    private static void dfs(int node, ArrayList<ArrayList<Integer>>adj, Stack<Integer>stack, int[]visited ){
        visited[node] = 0;//Visiting
        
        for(int neigh : adj.get(node)){
            
            if(visited[neigh]== -1){
                dfs(neigh, adj, stack, visited);
            }
        }
        //Once complete visiting the node
        stack.push(node);
    }
}
