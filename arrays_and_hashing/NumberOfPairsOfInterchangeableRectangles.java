package arrays_and_hashing;
/*
https://leetcode.com/problems/number-of-pairs-of-interchangeable-rectangles/description/

Solution 1:
     Create a ratio to count pair 
     for each ratio greater than 1, then calculate the number of unique combinations by formulae:  c * (c - 1) / k,
      where k is the size of combinations, in our case is 2.

Solution 2:
     We maintain a map of ratio : count
     every time we find the ratio exists we increment count and add the current ratio count to our results.

     return the results sum after iteration.
*/
import java.util.*;
public class NumberOfPairsOfInterchangeableRectangles {
    

    class Solution1 {
        /*
          0.5.   0.5.   0.5.   0.5   
         [[4,8],[3,6],[10,20],[15,30]]
         O(n ^ 2)
         map , {ratio :  count}
          { 0.5 : 4, }
    
         */
        
    
        public long interchangeableRectangles(int[][] rectangles) {
  
            Map<Double, Integer>map = new HashMap<>(); // {ratio :  counter}
           
            for(int [] m :  rectangles){
               double ratio = (double)m[0] / (double) m[1];
               map.put(ratio, map.getOrDefault(ratio, 0) + 1);
            }
            long counter = 0L;
            for(Integer c :  map.values() ){
                if(c > 1 ){
                  counter +=  ((long)c * ((long)c - 1L)) / 2L;
                }
                  
            }
            return counter;
            
    
        }
    
    }


    class Solution2 {
    
         public long interchangeableRectangles(int[][] rectangles) {
             Map<Double, Integer>map = new HashMap<>();
             long count = 0;
            
             for(int [] m : rectangles){
                double ratio = (double)m[0] / (double) m[1];
                if(!map.containsKey(ratio)){
                    map.put(ratio, 0);
                }else{
                    map.put(ratio, map.get(ratio) +  1 );
                    count += (long)map.get(ratio);
                   
                }
             }
             return count;
    
        
        }
    
    }
}
