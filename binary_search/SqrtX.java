package binary_search;
/**
 * https://leetcode.com/problems/sqrtx/description/
 */
public class SqrtX {

    // Time Complexity: O(log n)
    //Space complexity: O(1)
    public int mySqrt(int x) {
        // 1,2,3,4
        long l = 1L;
        long r = (long) x;
        long res = 0L;
        while(l <= r){
            long mid = (l + r) / 2L;
            long msq = mid * mid;

            if(msq == x){
                return (int) mid;
            }
            if(msq > x){
                r = mid - 1L;
            }else{
                res = mid;
                l = mid + 1;
            }
        } 
        return (int) res;
    }

    //Bruteforce solution
    //Time Complexity: O(sqrt(n))
    //Space Complexity: O(1)
    public int mySqrt2(int x) {
        // 1,2,3,4
        long res = 0;
        for(long i = 1; i <= x; i++){
            long sqr = i * i;   
           
            if(sqr > x){
                break;
            }   

            if(sqr == x){
                return (int) i;
            }
           res = i;   
        }
        return (int) res;
    }
}
