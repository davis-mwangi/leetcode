package Neetcode_450_Questions.MEDIUM;

/*
https://leetcode.com/problems/sort-colors/description/


Used Heapsort

*/
public class SortColors_Medium_LC75 {

    class Solution {
        public void sortColors(int[] nums) {
            int N = nums.length;

            for (int i = N / 2; i >= 0; i--) {
                maxHeapify(nums, N, i);
            }

            for (int i = N - 1; i >= 0; i--) {
                // Swap
                int temp = nums[0];
                nums[0] = nums[i];
                nums[i] = temp;

                maxHeapify(nums, i, 0);
            }

        }

        public void maxHeapify(int[] nums, int N, int i) {
            int largest = i;
            int left = (2 * i) + 1;
            int right = (2 * i) + 2;

            while (left < N && nums[left] > nums[largest]) {
                largest = left;
            }

            while (right < N && nums[right] > nums[largest]) {
                largest = right;
            }

            if (i != largest) {
                // Swap
                int temp = nums[largest];
                nums[largest] = nums[i];
                nums[i] = temp;

                maxHeapify(nums, N, largest);
            }
        }

    }
}
