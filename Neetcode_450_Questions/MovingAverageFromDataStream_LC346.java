package Neetcode_450_Questions;
/*

https://leetcode.ca/all/346.html

*/
public class MovingAverageFromDataStream_LC346 {
    class MovingAverage{
         int maxDivisor = 0;
         int count = 0;
         int sum = 0;
         MovingAverage(int val){
             this.maxDivisor = val;
         }
        int next(int val){
            this.count += 1;
            int counter = Math.min(this.count, maxDivisor);
            this.sum += val;

           return sum  / counter;
        }
    }
}
