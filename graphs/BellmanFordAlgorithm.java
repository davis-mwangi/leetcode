package graphs;

/*
https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=distance-from-the-source-bellman-ford-algorithm

Guide : https://www.youtube.com/watch?v=0vVofAhAYjc&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=42


Time Complexity : O(E *  V )
Space Complexity : O(V)
*/

import  java.util.*;

public class BellmanFordAlgorithm {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int [] dist = new int[V];
       
        int holder = (int) Math.pow(10, 8);
       
        Arrays.fill(dist,  holder);
        
         //Initialize source to dist 0
        dist[S] = 0;
        
        for(int i = 0; i < V -1; i++ ){
            
            for( ArrayList<Integer> neigh : edges ) {
                
                 Integer u  = neigh.get(0);
                 Integer v  = neigh.get(1);
                 Integer wt = neigh.get(2);
                 
                 // Relax edges if the current dist is lesss
                 if(dist[u] !=  holder && (dist[u] + wt) < dist[v] ){
                     dist[v] = dist[u] + wt;
                 }
                 
            }
        }
       
        //Negative relaxation to check negative cycle
        for( ArrayList<Integer> neigh : edges ) {
                
            Integer u  = neigh.get(0);
            Integer v  = neigh.get(1);
            Integer wt = neigh.get(2);
                 
                 // Relax edges if the current dist is lesss
            if(dist[u] !=  holder && (dist[u] + wt) < dist[v] ){
                return new int[]{-1};
            }
                 
        }
        return dist;
    }
}
