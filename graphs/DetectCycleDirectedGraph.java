package graphs;

/*
https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=detect-cycle-in-a-directed-graph

Guide: https://www.youtube.com/watch?v=9twcmtQj4DU&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=19

*/
import java.util.*;
class DetectCycleDirectedGraph {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[]visited =  new int[V];
        
        //Initialize to not visited
        Arrays.fill(visited, -1); // -1 -  Not visited, 0 - Visiting , 1 - visited
        
        for(int i = 0; i < V; i++){
            if(visited[i] == -1){
                if(hasCycle(i, adj, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean hasCycle(int node, ArrayList<ArrayList<Integer>>adj, int [] visited ){
        //Mark as visiting
        visited[node] = 0;
        
        //Traverse the neighbors
        for(int neigh :  adj.get(node)){
            //Neighbor not visited
            if(visited[neigh] == -1){
                if(hasCycle(neigh, adj, visited)){
                    return true;
                }
            }
            //If already been  marked as visiting then there is a cycle
           else if(visited[neigh] == 0){
               return true;
           }
        }
        //Mark completely visited
        visited[node] = 1;
        return false;
    }
}
