package graphs;
/*

Take u Foreward : https://www.youtube.com/watch?v=mJcZjjKzeqk&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=45

GFG : https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=minimum-spanning-tree
*/
import java.util.*;
public class MSTPrimsAlgorithm {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        
        PriorityQueue<int[]>pq = new PriorityQueue<>( (a,b) ->  a[0] - b[0] ); // [weight, node, parent]
        int [] visited = new int[V];
        int sum = 0;
        pq.add( new int[]{0, 0, -1} );
        
        while(!pq.isEmpty()){
            int [] tuple =  pq.poll();
            int wt = tuple[0];
            int node = tuple[1];
            int parent = tuple[2];
            
            //If node is already visited, ignore and move on
            if(visited[node] != 0){
                continue;
            }
            
            //Mark the node as visited
            visited[node] = 1;
            sum += wt;
            
            for(int[] neigh :  adj.get(node)){
                int neighNode = neigh[0];
                int neighWt = neigh[1];
                
                if(visited[neighNode] == 0){
                    pq.add(new int[]{neighWt, neighNode, node});
                }
                
            }
            
        }
        return sum;
    }
}
