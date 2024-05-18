package Neetcode_450_Questions.MEDIUM;

/*
https://leetcode.com/problems/top-k-frequent-elements/description/
*/
import java.util.*;

public class TopKFrequentElements_Medium_LC347 {
    class Solution {
        /*
         * {1 : 3, 2 :2 , 3: 1}
         * k = 2
         * [1,3], [2,2], []= 2
         */

        public int[] topKFrequent(int[] nums, int k) {

            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }

            PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // max Heap by default {num :
                                                                                      // frequency}
            for (Integer num : map.keySet()) {
                pq.add(new Integer[] { num, map.get(num) });
                if (pq.size() > k) {
                    pq.poll();
                }
            }
            // Create ans
            int[] ans = new int[k];
            int i = 0;
            while (!pq.isEmpty()) {
                Integer[] pair = pq.poll();
                ans[i] = pair[0];
                i++;
            }
            return ans;
        }
    }
}
