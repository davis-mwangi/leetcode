package binary_search;
/**
 * https://leetcode.com/problems/guess-number-higher-or-lower/description/
 * 
 */
public class GuessNumberHigherOrLower {
   
    //Time Complexity: O(log n)
    //Space complexity: O(1)
    public int guessNumber(int n) {
        int l = 1; 
        int r = n;
        while(true){
            int m = l + (r -  l) / 2;
            int res = guess(m);
            if(res == -1){
              r = m -1;
            }else if(res == 1){
              l = m + 1;
            }else{
                return m;
            }
        }
       
    }

    //Guess function
    private int guess(int num){
      int min = 0;
      int max = num;
      return (int) Math.random() * (max - min) + min;
    }
}
