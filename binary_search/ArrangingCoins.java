package binary_search;
/**
 * https://leetcode.com/problems/arranging-coins/
 * 
 * Gauss's Formulae  (n / 2)*(n + 1)
 * 
 * 1............100 
 */
public class ArrangingCoins {
    
    public int arrangeCoins(int n) {
        long left = 1;
        long right = n;
        int completedRows = 0;
        while(left <= right ){
            int mid = (int) ((right + left) / 2);

            // Gauss Formulae
            long coins = (long) ((mid / 2.0 ) * (mid + 1));
            if(coins > n){
                right = mid - 1;
            }else{ // Equals, or less than coins required
                completedRows = Math.max(completedRows, mid);
                left = mid + 1;
                
            }
        }
        return completedRows;
    }
}
