package arrays_and_hashing;

/**
 * https://leetcode.com/problems/concatenation-of-array/
 * 
 *  // i = 0
    // j = n - 1
 */
// Solution 1
public class ConcatenationOfArray {
  public int[] getConcatenation(int[] nums){
    int n =  nums.length;  
    int i = 0;
    int j = n;
    int[] ans =  new int [n * 2];

    while(i < n){
        ans[i] = ans[j] =  nums[i];
        i++;
        j++;
    }
   
    return ans;
  }  
}
