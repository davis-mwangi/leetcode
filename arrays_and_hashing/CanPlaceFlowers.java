package arrays_and_hashing;
/**
 * https://leetcode.com/problems/can-place-flowers/
 * 
 *  [1,0,0,0,1] n = 2
 * 
 *  Algorithm: 
 *  Solution 1:
 *     Since we can only place a flower if the adjacent spaces are empty or its at the edge, 
 *     to solve this , we assume we have empty space at -1 position and n  position e.h  0 [1,0,0,0,1] 0
 *     this will help with edge cases,
 *      then we iterate through the new flowerbed  checking if  current and adjacent spaces are empty,
 *      If they are, we mark it and  decrement the flower count to be planted
 *     
 *      At the end we just check if we have exhausted  the n count 
 *    Solution 2: 
 *        we consider edge cases [0, 0, 1] or [1, 0, 0]  and 0[i -1, i, i + 1]
 * 
 */
public class CanPlaceFlowers {
    
    //TC: O(N)
    //SC: O(N)
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int [] flNew =  new int[len + 2];//by default int has 0
    
        for(int  i = 0; i < len; i++){
               flNew[i+1] = flowerbed[i];
         }
          
         for(int i = 1; i < flNew.length - 2; i++){
            if( flNew[i-1] == 0 && flNew[i] == 0 && flNew[i+1] == 0){
                 flNew[i] = 1;
                 n -= 1; // reduce flowers count
            }
         }
     return  n <= 0;

    }

    //TC : O(N)
    //SC : O(1)
    public boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int len = flowerbed.length;
         for(int i = 0; i < len && n > 0; i++){// to optimize when n becomes 0 we exit the loop
             if(  (flowerbed[i] == 0)  && 
                  (i == 0 || flowerbed[i - 1] == 0) &&
                  ( i == (len - 1) || flowerbed[i+1] == 0 ) ){
                     flowerbed[i] = 1;
                     n -= 1;
                 }
         }
         return n <= 0;
  
      }
}
