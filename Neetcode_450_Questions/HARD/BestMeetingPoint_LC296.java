package Neetcode_450_Questions.HARD;

/*

Given an m x n binary grid grid where each 1 marks the home of one friend, return the minimal total travel distance.

The total travel distance is the sum of the distances between the houses of the friends and the meeting point.

The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

Example 1:


Input: grid = [[1,0,0,0,1],[0,0,0,0,0],[0,0,1,0,0]]
Output: 6
Explanation: Given three friends living at (0,0), (0,4), and (2,2).
The point (0,2) is an ideal meeting point, as the total travel distance of 2 + 2 + 2 = 6 is minimal.
So return 6.

Example 2:

Input: grid = [[1,1]]
Output: 1

GUIDE : (Cracking FAANG )https://www.youtube.com/watch?v=KfH51O3l2EM

APPROACH:
  Find Median point
      - Iterate through matrix collection all rows that has a house in order
      - Iterate thought mtrix collection all cols that has house column by colunm within row
      - Find median of col and get the value
       -Find the media row b and the value
    Calculate min distance
       -  Calculate the manhattatan distance from the medium col and row,   

TC:  3 * O(M * N) ~ O(N*M)
SC : 3 * O(M*N) if all spaces has a house ~ O(M*N)       
*/
import java.util.*;

public class BestMeetingPoint_LC296 {
    class Solution {
        public int minTotalDistance(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;

            List<Integer> houseRows = new ArrayList<>();
            List<Integer> houseCols = new ArrayList<>();
            List<List<Integer>> houses = new ArrayList<>();

            // Add all rows that contain houses
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (grid[r][c] == 1) {
                        houseRows.add(r);
                        houses.add(Arrays.asList(r, c));
                    }
                }
            }
            // Add all cols that contain houses
            for (int c = 0; c < cols; c++) {
                for (int r = 0; r < rows; r++) {
                    if (grid[r][c] == 1) {
                        houseCols.add(c);
                    }
                }
            }

            // Find the median point
            int medianCol = houseCols.get(houseCols.size() / 2);
            int medianRow = houseRows.get(houseRows.size() / 2);

            // Calculate the manhattan distance from the median point
            // distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
            int minDist = 0;
            for (List<Integer> hse : houses) {
                minDist += Math.abs(hse.get(0) - medianRow) + Math.abs(hse.get(1) - medianCol);
            }
            return minDist;
        }
    }
}
