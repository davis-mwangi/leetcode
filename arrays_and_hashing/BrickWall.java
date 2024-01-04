/**
 * https://leetcode.com/problems/brick-wall/description/
 * 
 * Algorithm:
 *    Naive approach:
 *        Take the sum of all bricks and then subsdivide then into portions of ones such that it will be  1 -> sum(N) -1
 *         and then determine how many gaps we cut through, this will grow if the length of the total width increeases.
 * 
 *    Optimal Solution:
 *        We can consider the gaps  at each row, with help of a hashmap we can maintain the gap position as the key and value as 
 *       the count of gaps at that position.
 *       - at the end we position with most gaps will be the one with minimal cuts.
 *       - Then we can get min cuts as total number of rows - max gaps
 *     
 *      TC: O(M * N)
 *      SC: O(M * N )
 */

import java.util.*;
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
         Map<Integer,Integer>map = new HashMap<>(); // {gap position :  count of gaps in that position}
         int maxPositionGaps = 0;
         int rows = wall.size();
         for(List<Integer>row :  wall){
             
             int position = 0;
  
             //Ignore gaps at 0 and n -1 position since are edges
             for(int i = 0; i < row.size() -1; i ++){
                 int brickWidth = row.get(i);
                 position +=  brickWidth;
                 map.put( position, map.getOrDefault(position, 0) + 1 );
                 
                 maxPositionGaps = Math.max(maxPositionGaps, map.get(position));
             }
         }
         return rows - maxPositionGaps;
     }
  
  }