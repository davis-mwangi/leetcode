package Neetcode_450_Questions.MEDIUM;

/*
https://leetcode.com/problems/number-of-pairs-of-interchangeable-rectangles/description/
*/

import java.util.*;

public class NumberOfPairsOfInterchangeableRectangles_Medium_LC2001 {
    class Solution {
        /*
         * r[i] = w, h
         * w/h = w/h (double division)
         * 
         * Map[ratio : count ]
         * 
         * [[4,8],[3,6],[10,20],[15,30]]
         * 4/8 = 0.5
         * 3/6 = 0.5
         * 10/20 = 0.5
         * 15/30 = 0.5
         * [[4,5],[7,8]]
         * 4/5 = 0.8
         * 7/8= 0.875
         * - get permuatons
         */
        // Bruteforce
        public long interchangeableRectangles(int[][] rectangles) {
            long count = 0;
            Map<Double, Long> ratioCount = new HashMap<>();
            for (int[] pair : rectangles) {
                double ratio = (double) pair[0] / (double) pair[1];
                if (!ratioCount.containsKey(ratio)) {
                    ratioCount.put(ratio, 0L);
                } else {
                    ratioCount.put(ratio, ratioCount.getOrDefault(ratio, 0L) + 1L);
                    count += ratioCount.get(ratio);
                }
            }
            return count;
        }
    }
}
