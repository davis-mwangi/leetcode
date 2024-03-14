package Top_Leetcode_150.Arrays_and_Strings;

/*

https://leetcode.com/problems/majority-element/description/?envType=study-plan-v2&envId=top-interview-150

*/
import java.util.*;
public class MajorityElement_LC169 {
    class Solution {
        /*
         * [2,2,1,1,1,2,2]
         * { 2: 4, 1: 3 } n = 7 / 2 ~ 3
         * Time Complexity: O(N)
         * Space Complexity: O(N)
         * 
         */
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>(); // { num: frequency}
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int times = nums.length / 2;
            for (int num : map.keySet()) {
                if (map.get(num) > times) {
                    return num;
                }
            }
            return -1;

        }
    }

}