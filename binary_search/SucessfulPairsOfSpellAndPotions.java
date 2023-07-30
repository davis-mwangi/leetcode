package binary_search;

import java.util.*;
/**
 * https://leetcode.com/problems/successful-pairs-of-spells-and-potions/
 */

public class SucessfulPairsOfSpellAndPotions {
    /*spells[i] * potions[j] == successs [5, 1,3] n success=7
    pairs length n []   [1,2,3,4,5] n      [5,10,15,20,25]  ~ Bruteforce: O(m * n) 
    /Sort potions n log n
    //Binary search value less or equal to 7

    s=[3,1,2]  p=[8,5,8] sort [5,8,8]
    */
    //Time Complexity:   spells(n) potions(m) => O(m log m) + O(n * log m)
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];

        Arrays.sort(potions);

        for(int i = 0 ; i < spells.length; i++){

            int left = 0;
            int n = potions.length;
            int right = n - 1;

            // Find the weakest cutoff point (furthest left) e.g 1, 2, 2, 2, 3
            int idx = n;

            while(left <= right){
                int mid = left + ((right - left) / 2);
                long product = (long) spells[i] * (long) potions[mid];
                
                if(product >= success){
                    right = mid - 1;
                    idx = mid;                  
                }else{
                    left = mid + 1;  
                }
            }

            result[i] = (n - idx);
        }
        return result;
    }

    //Bruteforce O(m * n) 
    public int[] successfulPairs2(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];

        for(int i = 0 ; i < spells.length; i++){
            int count = 0;
            for(int j=0; j < potions.length; j++){
               if( ( ((long)spells[i])* ((long)potions[j])) >= success){
                   count+=1;
               }
            }
            result[i] = count;
        }
        return result;
    }
}
