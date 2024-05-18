package Neetcode_450_Questions.MEDIUM;

/*
https://leetcode.com/problems/brick-wall/description/
*/
import java.util.*;

public class BrickWall_Medium_LC554 {
    class Solution {
        /*
         * [ ][ ] [. ] 1
         * [. ][. ] 2
         * [. ][. ][. ] 3
         * 
         * [[1,2,2,1], 1:1, 3: 1, 5:1
         * [3,1,2], 1:1, 3: 2, 4: 1, 5:1
         * [1,3,2], 1:2, 3: 2, 4: 2, 5:1
         * [2,4], 1:2, 2:1, 3: 2, 4: 2, 5:1
         * [3,1,2], 1:2, 2:1, 3: 3, 4: 3, 5:1
         * [1,3,1,1]]. 1:3, 2:1, 3: 3, 4: 4, 5:2
         * 
         * Observations : all rows have same length
         * 1, 2, 2,1 = 6
         * map [gap : count] 1 -> 6
         * brick with least gaps(count)
         * 
         * The minimum crossed bricks => no.of rows - max gaps
         * Time: n * m
         * space (n)
         */
        public int leastBricks(List<List<Integer>> wall) {
            Map<Integer, Integer> gapCountMap = new HashMap<>(); // {gap : count}
            int sum = sum(wall.get(0));
            int rowsCount = wall.size();
            for (int i = 0; i < rowsCount; i++) {
                int gap = 0;

                for (int j = 0; j < wall.get(i).size(); j++) {
                    gap += wall.get(i).get(j);

                    if (gap == sum)
                        continue;

                    gapCountMap.put(gap, gapCountMap.getOrDefault(gap, 0) + 1);

                }
            }

            int maxGaps = 0;
            for (Integer gap : gapCountMap.keySet()) {
                maxGaps = Math.max(maxGaps, gapCountMap.get(gap));
            }
            return rowsCount - maxGaps;
        }

        private int sum(List<Integer> list) {
            return list.stream().mapToInt(Integer::intValue).sum();
        }
    }
}
