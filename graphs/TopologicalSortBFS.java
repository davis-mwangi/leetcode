package graphs;
/*
Geek for Geeks:  https://www.geeksforgeeks.org/problems/topological-sort/1
Coding Ninjas:  https://www.codingninjas.com/studio/problems/982938

Khan's Algorithm:
1) Determine  the indegreee of each vertex.
2) Add vertex with indegree of zero(0), you can use a Queue or a Deque
3) Every time we remove a node from queue for processing we  add  to our result, then
   decrease its neighbors indegree count.
4) We repeat untill all nodes have indegree of one and all nodes in the Queue has been processed.
5) We  then return our result.


*/
import java.util.*;
public class TopologicalSortBFS {
    class Solution
    {
        //Function to return list containing vertices in Topological order. 
        static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
        {
            // add your code here
            int [] indegree = new int[V];
            
            //Populate indegree of each vertex
            for(int i = 0; i <  V; i++){
                for(int it :  adj.get(i) ){
                    indegree[it]++;
                }
            }
            
            // Add items with zero indegree to a queue
            Deque<Integer>deque = new LinkedList<>();
            for(int i = 0; i < V; i++){
               if( indegree[i] == 0 ){
                     deque.add(i);
               }
            }
            int[] topologicallySorted = new int [V];
            int i = 0;
            while( !deque.isEmpty() ){
                int node = deque.poll();
                topologicallySorted[i++] = node;
                
                //Reduce the neighbors their indgree since we have remove one of its  edges
                for(int it : adj.get(node) ){
                    indegree[it]--;
                    //If the indegree becomes zero, then we add it back, since not more indegrees for this vertex
                    if(indegree[it] == 0 ){
                        deque.add(it);
                    }
                }
                
            }
            return topologicallySorted;
            
        }
    } 
}
