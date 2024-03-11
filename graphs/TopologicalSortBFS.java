package graphs;
<<<<<<< HEAD

/*

 Geek for Geeks:  https://www.geeksforgeeks.org/problems/topological-sort/1

 Coding Ninjas:  https://www.codingninjas.com/studio/problems/982938

 */
import java.util.*;

public class TopologicalSortBFS {
    public class Solution {
        /*
         * Input:
         * 2 -> 1
         * 1 -> 0
         * 3 -> 2
         * 0 -> 1
         * 0 -> 2
         * Ouput:
         * 1 -> 0
         * 0 -> 2 -> 1
         * [1,2,2
         * ]
         * 0 1,2
         * 
         */
        public static int[] topologicalSort(ArrayList<ArrayList<Integer>> adj,
                int v, int e) {
            // Write your code here
            int[] indegree = new int[v];
            // Get the indegree of each vertex
            for (int i = 0; i < v; i++) {
                for (int it : adj.get(i)) {
                    indegree[it]++;
                }
            }

            // add your code here
            int[] indegree = new int[v];
            // Get the indegree of each vertex
            for (int i = 0; i < v; i++) {
                for (int it : adj.get(i)) {
                    indegree[it]++;
                }
            }

            Deque<Integer> deque = new LinkedList<>();
            // Push the vertex with 0(zero) indegree to start the iteration
            for (int i = 0; i < v; i++) {
                if (indegree[i] == 0) {
                    deque.add(i);
                }
            }
            int[] topo = new int[v];
            int i = 0;
            while (!deque.isEmpty()) {
                int node = deque.poll();
                topo[i++] = node;

                for (int it : adj.get(node)) {
                    indegree[it]--;
                    if (indegree[it] == 0) {
                        deque.add(it);
                    }
                }
            }
            return topo;

        }
    }

=======
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
>>>>>>> 49dd3d720dca2d308fa1c2640bd58573f08b075b
}
