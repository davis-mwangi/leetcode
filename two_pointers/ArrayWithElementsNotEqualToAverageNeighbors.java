package two_pointers;
/**
 * https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors/description/
 * 
 *  Ensure neighbours are larger than nums[i] or smaller than nums[i]
    This can be done by spacing the values by skipping a value
    1) Sort [6,2,0,9,7] => [0,2,6,7,9]
    2) place values alternating large and small  0_9_2_7_6

 */
import java.util.*;
public class ArrayWithElementsNotEqualToAverageNeighbors {
    
  
    public int[] rearrangeArray(int[] nums) {

        Arrays.sort(nums);
        
        int n = nums.length;
        int[] res =  new int[n];
        int left = 0;
        int right = n -1;

        int  k = 0;
        while(left <= right){
            if(k < n){
                res[k++] = nums[left++];   
            }
            if(k < n){
                res[k++] = nums[right--];
            }
        }
        return res;
    }
}
