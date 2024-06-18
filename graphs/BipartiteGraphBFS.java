package graphs;
/*

https://www.geeksforgeeks.org/problems/bipartite-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=bipartite-graph

Guide : https://www.youtube.com/watch?v=-vu34sct1g8&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=17
*/
import java.util.*;
class BipartiteGraphBFS
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int [] colors = new int[V];
        //Mark visted as -ve(no color)
         Arrays.fill(colors, -1);
         
        //In case we have  several components
        for(int i = 0; i < V; i++){
            
            if(colors[i] == -1){
                if(!checkBipartite(i,V, adj, colors )){
                    return false;
                }
            }
        }
        return true;
    }
    /*
      0.   1.  2
    [0,2],[1],[0]
    
    */
    
    private boolean checkBipartite(int startNode, int parent,  ArrayList<ArrayList<Integer>>adj, int [] colors){
        colors[startNode]= 0; //Mark one color say green(1)
        Deque<Integer>deque = new LinkedList<>();
        deque.add(startNode);
        
        while(!deque.isEmpty()){
   
                  Integer node = deque.poll();
                  
                  //Loop through the neighbors
                  for(int neighbor :  adj.get(node)){
                       if(colors[neighbor] == -1){//Not assigned color
                            deque.add(neighbor);
                            //Add color opposite of what is on current node
                            colors[neighbor] =  colors[node] == 0  ? 1 : 0;
                       }//Already have color and same ascolor of the current node, then its not bipartite
                       else if( colors[neighbor] == colors[node]){
                             return false;
                       }
                  }
        
        }
        return true;
    }
}
