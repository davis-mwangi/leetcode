package dynamic_programming_1;

/*
https://www.codingninjas.com/studio/problems/ninja-s-training_3621003

              t0, t1,t2
     day0 ->  [1, 2, 5] 
     day1 ->  [3, 1, 1] 
     day2 ->  [3, 3, 3] 

Since you cannot pick the same task in consecutive days,
 on each recursive call we will maintain a previous  task so that we dont repeat the task

 Recursion Steps:
 1)  define the index (day, last)
 2) Do stuffs using those indexes
 3) find max value;
*/
import java.util.*;

public class NinjasTraining {

    // Memoized Solution
    // Time Complexity: O(N) * 4 * 3
    // Space Complexiy: O(n) * 3
    public class Solution {
        public static int ninjaTraining(int n, int points[][]) {

            // Write your code here..

            int[][] dp = new int[n + 1][3 + 1];
            fill(dp, -1);
            return dfs(n - 1, 3, points, dp);
        }

        private static int dfs(int day, int last, int[][] points, int[][] dp) {
            // Base Case
            if (day == 0) {
                int maxi = 0;
                for (int task = 0; task < 3; task++) {
                    if (task == last) {
                        continue;
                    }
                    maxi = Math.max(maxi, points[0][task]);
                }
                return dp[day][last] = maxi;

            }
            if (dp[day][last] != -1) {
                return dp[day][last];
            }
            int max = 0;
            for (int task = 0; task < 3; task++) {

                if (task == last) {
                    continue;
                }
                int pts = points[day][task] + dfs(day - 1, task, points, dp);
                max = Math.max(max, pts);
            }
            return dp[day][last] = max;
        }

        private static void fill(int[][] arr, int val) {
            for (int[] row : arr) {
                Arrays.fill(row, val);
            }
        }

    }
    //Bottom-Up Solution (Tabulation)
    //Time Complexity: O(N *  4 *  3)
    //Space Complexity: O(N * 4)
    public class Solution2 {
        public static int ninjaTraining(int n, int points[][]) {

            //Tabulation
            int[][] dp = new int[n][4];
            //Base case
            dp[0][0] = Math.max(points[0][1], points[0][2]);
            dp[0][1] = Math.max(points[0][0], points[0][2]);
            dp[0][2] = Math.max(points[0][0], points[0][1]);
            dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
    
            //Iterate over days
            for(int day = 1; day < n; day++){
                //Iterate over tasks
                for(int last = 0; last < 4; last++ ){
                    dp[day][last] = 0;
                    int maxi = 0;
                    for(int task = 0; task < points[day].length; task++){
                        if(last == task) continue;
    
                        int pts =  points[day][task] + dp[day - 1][task];
                        maxi = Math.max(maxi, pts);
                    }
                    dp[day][last] = maxi;
                }
            }
            return dp[n-1][3];
        }

        //Space Optimization
        //Time Complexity: O(N *  4 *  3)
        //Space Complexity: O(4) ~ O(1)
        public static int ninjaTraining2(int n, int points[][]) {

            //Tabulation
            int[] prev = new int [4];
            //Base case
            prev[0] = Math.max(points[0][1], points[0][2]);
            prev[1] = Math.max(points[0][0], points[0][2]);
            prev[2] = Math.max(points[0][0], points[0][1]);
            prev[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));
    
            //Iterate over days
            for(int day = 1; day < n; day++){
                //Iterate over tasks
                int[]temp =  new int[4];
                for(int last = 0; last < 4; last++ ){
                    temp[last] = 0;
                    int maxi = 0;
                    for(int task = 0; task < points[day].length; task++){
                        if(last == task) continue;
    
                        int pts =  points[day][task] + prev[task];
                        maxi = Math.max(maxi, pts);
                    }
                    temp[last] = maxi;
                }
                prev = temp;
            }
            return prev[3];
        }
    }
}
