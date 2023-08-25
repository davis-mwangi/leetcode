package trees;
import java.util.*;
/*
https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/description/

Example:
Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]
Output: 8 
1) Create an adjacency list  mapping parent to child and child to parent since will need to go back
   0 -> [1, 2]
   1 -> [0, 4,5]
   2  ->[0, 3, 6]
   3  ->[2]
   4  ->[1]
   5 -> [1]
   6 -> [2]

 we add 2 if the call returns number greater than 0 or child has apple, 
 zero means no apple has been found from the subtree   

 Time Complexity: O(n) since we have to traverse al nodes at least twice O(2n) ~ O(n)
 Space complexity : O(n)
*/
public class MinTimeCollectAllAplesInTree {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        //Create adjacency list
        Map<Integer, List<Integer>>adj = new HashMap<>();
        for(int i = 0;i < n; i++){
            adj.put(i, new ArrayList<>() );
        }

        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        return dfs(adj, 0, -1, hasApple);


   }
   private int dfs(Map<Integer, List<Integer>>adj, int curr, int parent, List<Boolean> hasApple){
       int time = 0;
       for(int child: adj.get(curr)){
           if(child == parent){
               continue;
           }
           int childTime = dfs(adj,child, curr,hasApple);
           if(childTime > 0 || hasApple.get(child)){
               time +=  2+ childTime;
           }
       }
       return time;
   }
}
