package arrays_and_hashing;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 * Trick is to add zero at the beginning and the end
 */
//Solution 1 (Neetocode)
public class PascalTriangle {
    public List<List<Integer>>generate(int numRows){
        List<List<Integer>>result = new ArrayList<>();
        for(int i=0; i < numRows; i++){
              List<Integer>row = new ArrayList<>();
              
              for(int j = 0; j <=i; j++){
                  if(j > 0 && i > 0  && result.get(i-1).size() -1 >= j){
                      int left = result.get(i-1).get(j-1);
                      int right = result.get(i-1).get(j);

                      row.add(left+ right);
                  }else{
                      row.add(1);
                  }
              }
              result.add(row);
            
        }
        return result;
    }
}
//Solution 2 (Nick White:  https://www.youtube.com/watch?v=icoql2WKmbA)
public class Solution {
    public List<List<Integer>>generate(int numRows){
        List<List<Integer>>result = new ArrayList<>();

        if(numRows == 0){
            return result;
        }

        List<Integer>firstRow =  new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        for(int i = 1; i < numRows; i++){

            List<Integer>prevRow =  result.get(i -1);
            List<Integer>newRow = new ArrayList<>();
            newRow.add(1);

            for(int j = 1; j < i ; j++){
                newRow.add(prevRow.get(j-1) +  prevRow.get(j));
            }
            newRow.add(1);
            result.add(newRow);
        }
        return result;
    }
}
