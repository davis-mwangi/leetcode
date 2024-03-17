package Neetcode_450_Questions;
/*
https://leetcode.com/problems/pascals-triangle/description/

*/
import java.util.*;
public class PascalsTriangle_Easy_LC118 {
    class Solution {
        /*
         [0 1 0]
        0[1,1]0
        0[1,2,1]0,
        0[1,3,3,1]0,
        0[1,4,6,4,1]0
    
    
        */
        public List<List<Integer>> generate(int numRows) {
            
            List<List<Integer>>rows = new ArrayList<>();
            List<Integer>firstRow = new ArrayList<>();
            firstRow.add(1);
            rows.add(firstRow);
            for(int i = 1; i < numRows; i++){
                //Add prefix and suffix zeros
                List<Integer> prev = new ArrayList<>();
                prev.add(0);
                for(Integer num: rows.get(i-1) ){
                    prev.add(num);
                }
                prev.add(0);
    
                List<Integer>newRow = new ArrayList<>();
                for(int j = 1; j < prev.size();j++){
                    int sum = prev.get(j-1) + prev.get(j);
                    newRow.add(sum);
                }
                rows.add(newRow);
    
            }
            return rows;
        }
    }
}
