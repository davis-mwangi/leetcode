package Neetcode_450_Questions;

/*
There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1). The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the m x n maze, the ball's start position and the destination, where start = [startrow, startcol] and destination = [destinationrow, destinationcol], return true if the ball can stop at the destination, otherwise return false.

You may assume that the borders of the maze are all walls (see examples).


Example 1: 

Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [4,4]
Output: true
Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.

Example 2:
Input: maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], start = [0,4], destination = [3,2]
Output: false
Explanation: There is no way for the ball to stop at the destination. Notice that you can pass through the destination but you cannot stop there.
Example 3:

Input: maze = [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]], start = [4,3], destination = [0,1]
Output: false

*/
import java.util.*;

public class TheMaze_LC490 {
    class Solution {
        // BFS solution
        // TC: O(m.n.(m+n))
        // SC : O(m.n)
        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
            int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };// down, up, left, right
            int rows = maze.length;
            int cols = maze[0].length;

            Deque<int[]> deque = new LinkedList<>();
            boolean[][] visited = new boolean[rows][cols];

            deque.add(start);
            visited[start[0]][start[1]] = true;

            while (!deque.isEmpty()) {
                int[] point = deque.poll();
                int currR = point[0];
                int currC = point[1];

                // After we hit the wall check if the current space
                // is the destination
                if (currR == destination[0] && currC == destination[1]) {
                    return true;
                }

                // Try add directions
                for (int i = 0; i < 4; i++) {
                    int nR = currR;
                    int nC = currC;
                    // Move in the same direction until you hit a wall
                    while (nR >= 0 && nR < rows && nC >= 0 && nC < cols && maze[nR][nC] == 0) {
                        nR += directions[i][0];
                        nC += directions[i][1];
                    }
                    // Move one step back to move back to empty space
                    // After getting into a wal
                    nR -= directions[i][0];
                    nC -= directions[i][1];
                    // If the end point has not been seen before, then it services
                    // as our next starting point
                    if (!visited[nR][nC]) {
                        deque.push(new int[] { nR, nC });
                        visited[nR][nC] = true;
                    }
                }
            }
            return false;
        }
    }
}
