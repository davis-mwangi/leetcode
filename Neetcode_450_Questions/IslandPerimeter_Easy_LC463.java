package Neetcode_450_Questions;

/*

https://leetcode.com/problems/island-perimeter/description/

*/
public class IslandPerimeter_Easy_LC463 {
    class Solution {
        /*
         * [ [0,1,0,0],
         * [1,1,1,0],
         * [0,1,0,0],
         * [1,1,0,0]]
         * 
         */
        public int islandPerimeter(int[][] grid) {
            int sum = 0;
            int rows = grid.length;
            int cols = grid[0].length;

            boolean[][] visited = new boolean[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {

                    if (grid[i][j] == 1) {
                        sum += dfs(grid, i, j, visited);
                    }
                }
            }
            return sum;
        }

        public int dfs(int[][] grid, int row, int col, boolean[][] visited) {

            if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
                return 1;
            }
            if (visited[row][col]) {
                return 0;
            }

            visited[row][col] = true;

            return dfs(grid, row - 1, col, visited) +
                    dfs(grid, row + 1, col, visited) +
                    dfs(grid, row, col - 1, visited) +
                    dfs(grid, row, col + 1, visited);
        }
    }
}
