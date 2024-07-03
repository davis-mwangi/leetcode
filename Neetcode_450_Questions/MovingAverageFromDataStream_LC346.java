package Neetcode_450_Questions;

/*

https://leetcode.ca/all/346.html

*/
import java.util.*;

public class MovingAverageFromDataStream_LC346 {

    // Time Complexity :  O(1)
    // Space Complexity: O(N)
    class MovingAverage {
        Deque<Integer> deque;
        int count = 0;
        int size = 0;
        int currSum = 0;

        MovingAverage(int size) {
            this.deque = new LinkedList<>();
            this.size = size;
        }

        double next(int val) {

            if (deque.size() < size) {

                this.deque.add(val);
                currSum += val;

            } else {
                // Remove value to the left
                int leftVal = this.deque.pollFirst();
                currSum -= leftVal;

                // Add value to the right
                deque.add(val);
                currSum += val;
            }
            if (count < size) {
                count += 1;
            }

            return (double) currSum / (double) count;

        }
    }
}
