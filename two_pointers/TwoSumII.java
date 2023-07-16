package two_pointers;
/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 * 
 * 
 */
public class TwoSumII {
    //[2, 7, 11, 15]  
    // l  r
    // 2 + 15 = 17 > 9, 2+11=13 > 9, 2+7 = 9 == 9 [0+1, 1+1] => [1,2]
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1 ;

        while(l <= r){
            int sum =  numbers[l] +  numbers[r];
            if(sum == target){
               return new int[]{l+1, r+1};
            }
            
            if(sum > target){
                r--;
            }else{
               l++;
            }
        }
       return new int []{}; 
   }
}
