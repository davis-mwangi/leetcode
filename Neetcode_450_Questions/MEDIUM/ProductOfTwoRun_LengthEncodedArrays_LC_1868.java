package Neetcode_450_Questions.MEDIUM;

/*
Run-length encoding is a compression algorithm that allows for an integer array nums with many segments of consecutive repeated numbers to be represented by a (generally smaller) 2D array encoded. Each encoded[i] = [vali, freqi] describes the ith segment of repeated numbers in nums where vali is the value that is repeated freqi times.

For example, nums = [1,1,1,2,2,2,2,2] is represented by the run-length encoded array encoded = [[1,3],[2,5]]. Another way to read this is "three 1's followed by five 2's".
The product of two run-length encoded arrays encoded1 and encoded2 can be calculated using the following steps:

Expand both encoded1 and encoded2 into the full arrays nums1 and nums2 respectively.
Create a new array prodNums of length nums1.length and set prodNums[i] = nums1[i] * nums2[i].
Compress prodNums into a run-length encoded array and return it.
You are given two run-length encoded arrays encoded1 and encoded2 representing full arrays nums1 and nums2 respectively. Both nums1 and nums2 have the same length. Each encoded1[i] = [vali, freqi] describes the ith segment of nums1, and each encoded2[j] = [valj, freqj] describes the jth segment of nums2.

Return the product of encoded1 and encoded2.

Note: Compression should be done such that the run-length encoded array has the minimum possible length.

 

Example 1:

Input: encoded1 = [[1,3],[2,3]], encoded2 = [[6,3],[3,3]]
Output: [[6,6]]
Explanation: encoded1 expands to [1,1,1,2,2,2] and encoded2 expands to [6,6,6,3,3,3].
prodNums = [6,6,6,6,6,6], which is compressed into the run-length encoded array [[6,6]].
Example 2:

Input: encoded1 = [[1,3],[2,1],[3,2]], encoded2 = [[2,3],[3,3]]
Output: [[2,3],[6,1],[9,2]]
Explanation: encoded1 expands to [1,1,1,2,3,3] and encoded2 expands to [2,2,2,3,3,3].
prodNums = [2,2,2,6,9,9], which is compressed into the run-length encoded array [[2,3],[6,1],[9,2]].
 

*/
import java.util.*;

public class ProductOfTwoRun_LengthEncodedArrays_LC_1868 {
    class Solution {
        // Time Complexity : O(M + N) where M is length encoded1 and N length encoded2
        // Space Complexity : O(M+N)
        public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
            int i = 0; // pointer for encoded1
            int j = 0; // pointer for encoded2

            int n1 = encoded1.length; // length of encoded1
            int n2 = encoded2.length; // length of encoded2
            List<List<Integer>> res = new ArrayList<>();

            while (i < n1 && j < n2) {
                int[] enc1 = encoded1[i]; // [val, freq] from encoded1
                int[] enc2 = encoded2[j]; // [val, freq] from encoded2

                // Calculate product
                int product = enc1[0] * enc2[0];

                // Determine encoding with minimum frequency
                int freq = Math.min(enc1[1], enc2[1]);

                // Check if result array already has value or top val is not the same as
                // previously computed
                if (res.size() == 0 || !res.get(res.size() - 1).get(0).equals(product)) {
                    res.add(Arrays.asList(product, freq));
                } else {
                    // Same as top element so, increment by current frequency
                    int lastIndex = res.size() - 1;
                    res.get(lastIndex).set(1, res.get(lastIndex).get(1) + freq);
                }

                // Reduce the frequencies by min frequency
                encoded1[i][1] -= freq;
                encoded2[j][1] -= freq;

                // Increment the pointer if its frequency is zero
                if (encoded1[i][1] == 0) {
                    i++;
                }
                if (encoded2[j][1] == 0) {
                    j++;
                }
            }
            return res;
        }

    }
}
