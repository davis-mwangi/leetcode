package Neetcode_450_Questions.MEDIUM;

/*

https://leetcode.com/problems/diagonal-traverse-ii/description/

*/
import java.util.*;

public class DiagonalTraverseII_LC1424 {
    class Solution {
        public int[] findDiagonalOrder(List<List<Integer>> nums) {
            Map<Integer, List<Integer>> map = new HashMap<>(); // {(i+j) : [ num, num2]}

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int r = 0; r < nums.size(); r++) {
                for (int c = 0; c < nums.get(r).size(); c++) {
                    int key = r + c;
                    min = Math.min(min, key);
                    max = Math.max(max, key);

                    if (!map.containsKey(key)) {
                        map.put(key, new ArrayList<>());
                    }
                    map.get(key).add(nums.get(r).get(c));
                }
            }

            List<Integer> temp = new ArrayList<>();
            for (int i = min; i <= max; i++) {
                List<Integer> diag = map.get(i);
                for (int j = diag.size() - 1; j >= 0; j--) {
                    temp.add(diag.get(j));
                }
            }
            int[] res = new int[temp.size()];
            for (int i = 0; i < temp.size(); i++) {
                res[i] = temp.get(i);
            }
            return res;

        }
    }
}
