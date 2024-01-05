package arrays_and_hashing;
/**
 * https://leetcode.com/problems/first-missing-positive/description/
 * 
 * We can use the analogy of  mum with 5 children, each are requested to sit aon the appropriate  chair 
 *  labelled their respective names, once they sit we can easily identify who is missing
 * 
 * 
 * Youtube Ref: https://www.youtube.com/watch?v=aBhla9jSAeg (Code with Alisha)
 * 
 * 
 */
//Time Complexity : O(3.n) ~O(n)
//Space Complexity: O(1)
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        //First Convert all -ve numbers  to 0 since we dont consider it as part of our range (1 =>  len(A) +1)
        int n = nums.length;
        for(int i = 0; i< n; i++){
            if(nums[i] < 0){
                nums[i] = 0;
            }
        }
 
        // Mark all numbers to corresponding indexes
        for(int i = 0; i < n; i++){
            int index = Math.abs(nums[i]) - 1;
 
            if(index >= 0 &&  index < n){
                //For num that are already zeros mark a value out of ranging to avoid changing the input array
                if(nums[index] > 0){
                   nums[index] *= -1;
                }else if(nums[index] == 0){
                    nums[index] = (n + 1) * -1 ;
                }
            }
        }
        //Check the missing  value starting from 1, if value is -ve then the value exists
        for(int i = 1; i < n + 1; i++){
           if(nums[i - 1] >= 0){
               return i;
           }
        }
        return n + 1;
  
     }
}
