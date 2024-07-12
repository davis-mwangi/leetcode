package Neetcode_450_Questions.MEDIUM;

/*
https://leetcode.com/problems/meeting-rooms-ii/description/

Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1
 

Constraints:

1 <= intervals.length <= 104
0 <= starti < endi <= 106

*/
import java.util.*;

public class MeetingRoomsII_LC253 {

    // Time Complexity : O(N log N) + O(N)
    // Space Complexity : O(N)
    class Solution {
        public int minMeetingRooms(int[][] intervals) {
            int n = intervals.length;
            int[] start = new int[n];
            int[] end = new int[n];
            int maxParallelMeetings = 0;
            int count = 0;
            int s = 0;
            int e = 0;
            // Populate start and end
            for (int i = 0; i < n; i++) {
                start[i] = intervals[i][0];
                end[i] = intervals[i][1];
            }
            // Sort
            Arrays.sort(start);
            Arrays.sort(end);

            while (s < n && e < n) {

                if (start[s] < end[e]) {
                    count += 1;
                    s++;
                    maxParallelMeetings = Math.max(maxParallelMeetings, count);
                } else {
                    count -= 1;
                    e++;
                }
            }
            return maxParallelMeetings;

        }
    }
}
