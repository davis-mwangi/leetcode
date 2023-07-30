package binary_search;
/**
 * https://leetcode.com/problems/koko-eating-bananas/description/
 * 
 * 
 */
public class KokoEatingBananas {
    // piles = [3,6,7,11], h = 8
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = max(piles);
        int res = right;
        while(left<=right){
            int k = left + ((right - left) / 2);
            int hours = 0;
           
            for (int i = 0; i < piles.length; i++) {
             double spd =  (double)piles[i]  / (double) k; 
             hours +=  Math.ceil (spd );
            }
 
            if(hours <= h){
                 res = Math.min(k, res);
                 right = k - 1;
            }else{
                 left = k + 1;
            }
        }
        return res;
     }
     private int max(int [] arr){
         int max = Integer.MIN_VALUE;
         for(int num: arr){
             max = Math.max(max, num);
         }
         return max;
     }
}
