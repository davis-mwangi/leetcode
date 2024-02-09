package arrays_and_hashing;
/*
https://leetcode.com/problems/pascals-triangle-ii/description/
*/
import java.util.*;

public class PascalsTriangleII {

    //Time Complexity:  O(n*2)
    //Space Complexity: O(n)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            //Create pascals triangle, keeping track of previous row untill you get to rowIndex
            //Remember to append zero at the beginning and at the end.
            
            
            //Case when rowIndex = 0;
           
            List<Integer>prev = new ArrayList<>();
            prev.add(1);
    
           if(rowIndex == 0) {
              return prev;
            }
    
            List<Integer>result = new ArrayList<>();
            for(int i = 1; i  <= rowIndex; i++){
                List<Integer>temp = new ArrayList<>();
                temp.add(0);
                for(int j = 0; j < prev.size(); j++){
                    temp.add( prev.get(j) );
                }
                temp.add(0);
    
                //Calculate the next row
                List<Integer>currRow = new ArrayList<>();
                for(int  k = 0; k < temp.size() -1; k++){
                    currRow.add( temp.get(k) + temp.get(k + 1) );
                }
                result = currRow;
                prev = currRow;
            }
            return result;
     
        }
    }
}
