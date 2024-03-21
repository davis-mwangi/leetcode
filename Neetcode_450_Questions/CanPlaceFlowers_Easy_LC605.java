package Neetcode_450_Questions;
/*
https://leetcode.com/problems/can-place-flowers/description/

*/
public class CanPlaceFlowers_Easy_LC605 {
    class Solution {
        /*
        0[1,0,0,0,1]0
    
         Space Complexity: O(N)
         Time Complexity: O(N)
        */
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int len =  flowerbed.length;
            int [] f = new int[len+2];
            int j = 1;
            for(int i = 0;i < len; i++){
                f[j] = flowerbed[i];
                j+= 1;
            }
          
            for(int k = 1; k < f.length -1; k++){
                if( f[k-1]== 0 && f[k] == 0 && f[k+1] == 0){
                     f[k]= 1;
                     n--;
                }
            }
            return n<=0;
        }
    }
}
