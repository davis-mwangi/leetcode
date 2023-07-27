package binary_search;
/**
 * https://leetcode.com/problems/valid-perfect-square/description/
 */
public class ValidPerfectSquare {
    static class Solution {
        public boolean isPerfectSquare(int num) {
            // 1,2,3....14,15,16
            long l = 1L;
            long r = (long) num;
            while(l <= r){
                long mid = (l + r) / 2L;
                long midSqr = (long) Math.pow(mid, 2);
              
                if(midSqr == num){
                    return true;
                }else if(midSqr > num){
                    r = mid - 1L;
                }else if(midSqr < num){
                    l = mid + 1L;
                }
            }
            return false;
        }
    }
}
