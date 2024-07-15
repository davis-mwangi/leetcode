package Neetcode_450_Questions.HARD;
/*
Question :  https://leetcode.com/problems/number-of-distinct-islands-ii/description/


You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

An island is considered to be the same as another if they have the same shape, or have the same shape after rotation (90, 180, or 270 degrees only) or reflection (left/right direction or up/down direction).

Return the number of distinct islands.

 

Example 1:


Input: grid = [[1,1,0,0,0],[1,0,0,0,0],[0,0,0,0,1],[0,0,0,1,1]]
Output: 1
Explanation: The two islands are considered the same because if we make a 180 degrees clockwise rotation on the first island, then two islands will have the same shapes.
Example 2:


Input: grid = [[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]
Output: 1



*/

import java.util.*;

//ToDo: To revisit
public class NumberOfDistinctIslandsII_LC711 {
    class Solution {
        /*
         * - Find Number of Islands
         * - Each Island mark it with unique Island id
         * - Collection all points of each Island
         * 
         */
        public int numDistinctIslands2(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;

            boolean[][] visited = new boolean[rows][cols];

            List<List<int[]>> islands = new ArrayList<>();
            int islandId = 1;

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {

                    if (grid[r][c] == 1 && !visited[r][c]) {
                        List<int[]> islandPoints = new ArrayList<>();
                        dfs(r, c, grid, visited, islandPoints, islandId);
                        islands.add(islandPoints);
                        islandId += 1;
                    }

                }
            }
            // Check for Same Islands (Campare pair of islands)
            for (int i = 0; i < islands.size(); i++) {
                for (int j = i + 1; j < islands.size(); j++) {
                    // Check if Island i and j are same
                    boolean sameIsland = checkSameIsland(islands.get(i), islands.get(j));
                    System.out.println(sameIsland);

                    if (sameIsland) {
                        // Change ids of 2 islands to that of 1
                        int islandID = islands.get(i).get(0)[2];
                        islands.set(j, changeIslandId(islandID, islands.get(i)));
                    }
                }
            }
            // Get unique Ids id islands
            Set<Integer> uniqueIslandIds = new HashSet<>();
            for (List<int[]> island : islands) {
                uniqueIslandIds.add(island.get(0)[2]);
            }
            return uniqueIslandIds.size();

        }

        private boolean checkSameIsland(List<int[]> A, List<int[]> B) {
            int aLen = A.size();
            int bLen = B.size();

            if (aLen != bLen) {
                return false;
            }

            // Let the top left point be the base point of reference
            int ax0 = A.get(0)[0];//
            int ay0 = A.get(0)[1];

            int bx0 = B.get(0)[0];
            int by0 = B.get(0)[1];

            // Compute relative positions and check if its same for all points
            for (int i = 0; i < bLen; i++) {
                System.out.println("A:" + Arrays.toString(A.get(i)) + " <=>" + "B:" + Arrays.toString(B.get(i)));
                System.out.println();

                if ((A.get(i)[0] - ax0) != (B.get(i)[0] - bx0) ||
                        (A.get(i)[1] - ay0) != (B.get(i)[1] - by0)) {
                    return false;
                }
            }

            return true;

        }

        private List<int[]> changeIslandId(int islandID, List<int[]> island) {
            List<int[]> updatedIsland = new ArrayList<>();
            for (int[] islandPoint : island) {
                updatedIsland.add(new int[] { islandPoint[0], islandPoint[1], islandID });
            }
            return updatedIsland;
        }

        private void dfs(int r, int c, int[][] grid, boolean[][] visited, List<int[]> islandPoints, int islandId) {
            // Check if the current cell is out of bounds
            if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length) {
                return;
            }

            // Check if the current cell is water or already visited
            if (grid[r][c] == 0 || visited[r][c]) {
                return;
            }

            // Mark the current cell as visited
            visited[r][c] = true;

            // Add the current cell to the list of island points
            islandPoints.add(new int[] { r, c, islandId });

            // Navigate all four possible directions (right, left, down, up)
            dfs(r, c + 1, grid, visited, islandPoints, islandId);
            dfs(r + 1, c, grid, visited, islandPoints, islandId);
            dfs(r, c - 1, grid, visited, islandPoints, islandId);
            dfs(r - 1, c, grid, visited, islandPoints, islandId);
        }

    }
}
