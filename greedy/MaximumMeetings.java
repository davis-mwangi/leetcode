package greedy;

/*
https://www.codingninjas.com/studio/problems/maximum-meetings_1062658

Algorithm:
   We create a object that we can store, start, end and index
   We sort the object by the order of the end meeting, 
   we iterate through grouped meetings then every time we check if the  start of meeting is greater than the end 
   of the ending of the last meeting,
   Every time we encouter  a  match then we increase a counter by one

 */
import java.util.*;

public class MaximumMeetings {

    public class Solution {
        public static int maximumMeetings(int[] start, int[] end) {
            // Write your code here.
            int n = start.length;
            // Sort by end of the meeting
            Meeting[] meetings = new Meeting[n];
            for (int i = 0; i < n; i++) {
                meetings[i] = new Meeting(start[i], end[i], i + 1);
            }
            // Sort by meeting end time
            Arrays.sort(meetings, new MeetingComparator());

            int counter = 1;
            int meetingEndTime = meetings[0].end;

            for (int i = 1; i < n; i++) {
                if (meetings[i].start > meetingEndTime) {
                    counter += 1;
                    meetingEndTime = meetings[i].end;
                }
            }
            return counter;
        }

        static class MeetingComparator implements Comparator<Meeting> {
            @Override
            public int compare(Meeting m1, Meeting m2) {
                if (m1.end > m2.end) {
                    return 1;
                } else if (m1.end < m2.end || m1.index < m2.index) {
                    return -1;
                }
                return 1;
            }
        }

        static class Meeting {
            public int start;
            public int end;
            public int index;

            public Meeting(int start, int end, int index) {
                this.start = start;
                this.end = end;
                this.index = index;
            }
        }

    }

}
