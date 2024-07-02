package Neetcode_450_Questions.MEDIUM;

/*
Question : https://leetcode.com/problems/kth-largest-element-in-an-array/description/

Quick Select Solution : https://www.youtube.com/watch?v=ooLKYx1TlSE

Min heap Solution : https://www.youtube.com/watch?v=AzDs7qV1ugA

*/
import java.util.*;

public class KthLargestElementInAnArray_LC215 {
    // Time complexity : O(N log k)
    // Space Complexity : O(k)
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);// min heap
        for (int num : nums) {
            if (pq.isEmpty() || pq.size() < k) {
                pq.add(num);
            } else {
                if (num > pq.peek()) {
                    pq.poll();
                    pq.add(num);
                }
            }
        }
        return pq.peek();
    }

    // Space Complexity : O(1)
    // Time Complexity :
    // Average :O(N)
    // Worst Case : O(N^2ß)
    public int findKthLargest2(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }

    private int quickSelect(int[] nums, int low, int high, int k) {
        int pivotIdx = getPivotIdx(nums, low, high); // 4

        int searchIdx = nums.length - k; // 4

        if (pivotIdx < searchIdx) {
            return quickSelect(nums, pivotIdx + 1, high, k);
        } else if (pivotIdx > searchIdx) {
            return quickSelect(nums, low, pivotIdx - 1, k);
        } else {
            return nums[pivotIdx];
        }
    }

    private int getPivotIdx(int[] nums, int low, int high) {
        // Choose pivot element
        int pivotElement = nums[high];
        int pivotIdx = low;

        for (int j = low; j < high; j++) {
            if (nums[j] < pivotElement) {
                // Swap
                int temp = nums[pivotIdx];
                nums[pivotIdx] = nums[j];
                nums[j] = temp;
                pivotIdx++;
            }
        }
        // Swap with pivot element
        int temp = nums[pivotIdx];
        nums[pivotIdx] = nums[high];
        nums[high] = temp;

        return pivotIdx;
    }
}
