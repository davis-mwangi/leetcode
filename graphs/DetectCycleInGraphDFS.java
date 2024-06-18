package graphs;

import java.util.*;

/*
https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=detect-cycle-in-an-undirected-graph


Guide: https://www.youtube.com/watch?v=zQ3zgFypzX4&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=12
*/
class DetectCycleInGraphDFS {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
         boolean[] visited = new boolean[V];//By default is false
         for(int i = 0; i < V; i++){
             if(!visited[i]){
                if(detectCycleDFS(i, V, adj, visited)){
                    return  true;
                }
             }
         }
         return false;
    }
    
    private boolean detectCycleDFS(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        //Mark as visited
        visited[node] = true;
        
        for(int neigh : adj.get(node)){
            if(!visited[neigh]){
                 //If we get there is a cycle, return it immediately
                 if(detectCycleDFS(neigh, node, adj, visited)){
                     return true;
                 }
            }else if(neigh != parent){ //Visited and is not parent, them some body must have gone through the node, so there a cycle
                 return true;
            }
        }
        return false;//No Cycle
        
    }
}