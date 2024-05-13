package Neetcode_450_Questions;

/*
https://leetcode.com/problems/kth-largest-element-in-a-stream/description/
*/
import java.util.*;
public class KthLargestElementInAStream_Easy_LC703 {
    class KthLargest {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int maxSize;

        public KthLargest(int k, int[] nums) {
            maxSize = k;

            for (int i = 0; i < nums.length; i++) {
                pq.add(nums[i]);

                if (pq.size() > k) {
                    pq.remove();
                }
            }

        }

        public int add(int val) {
            pq.add(val);
            if (pq.size() > maxSize) {
                pq.remove();
            }
            return pq.peek();

        }
    }
}
