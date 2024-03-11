package graphs;

import java.util.*;

public class TopologicalSortDFS {
    public class Solution 
{
    public static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> edges, 
    int v, int e) 
    {
        // Write your code here
        int [] visited = new int[v];
        Arrays.fill(visited, -1);
        Stack<Integer>stack= new Stack<>();
        for(int i = 0; i < v; i++){
            if(visited[i] == -1){
                dfs(i,stack, edges, visited);
            }
        }

        //Add items from stack to list
        ArrayList<Integer>res = new ArrayList<>();
       while(!stack.isEmpty()){
         res.add(stack.pop() );
       }
        return res;
    }
    private static void dfs (int node, Stack<Integer>stack,ArrayList<ArrayList<Integer>> edges, 
       int [] visited ){
     
        visited[node] = 1;
        for(int it: edges.get(node)){
            if(visited[it] == -1){
                dfs(it, stack, edges, visited);
            }
        }
        //Once we no longer have other nodes linked to node
        
        stack.push(node);
    }
}
}
