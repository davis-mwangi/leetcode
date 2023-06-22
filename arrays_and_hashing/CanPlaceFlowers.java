package arrays_and_hashing;
/**
 * https://leetcode.com/problems/can-place-flowers/
 * 
 * 
 */
public class CanPlaceFlowers {
    
    
    public boolean canPlaceFlowers(int[] flowerbed, int n ) {
        
        int len = flowerbed.length;

        int [] f = new int[len + 2];
        int x = 1;
       
        for (int i = 0; i < len; i++) {
             f[x] = flowerbed[i];
             x++;
        }

        for(int i = 1; i < f.length - 1 ; i++){
            if(f[i - 1] == 0  && f[i] == 0 && f[i+1] == 0){
                f[i] = 1;
                n --;
            }
        }
        return n <= 0; 
    }
}
