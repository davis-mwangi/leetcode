package Neetcode_450_Questions;

/*
https://leetcode.com/problems/last-stone-weight/description/
*/
import java.util.*;

public class LastStoneWeight_Easy_LC1046 {
    class Solution {
        public int lastStoneWeight(int[] stones) {
            /*
             * 8, 1
             * 
             */
            // Max heap
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);// Max. heap
            // Add All items to the heap
            for (int stone : stones) {
                pq.add(stone);
            }

            while (!pq.isEmpty() && pq.size() >= 2) {

                int y = pq.poll();
                int x = pq.poll();

                if (x != y) {
                    pq.add(y - x);
                }

            }

            return pq.isEmpty() ? 0 : pq.peek();
        }
    }
}
