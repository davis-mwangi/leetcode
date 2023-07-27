package binary_search;
import java.util.*;
/**
 * 
 */
public class SquaresOfASortedArray {
     
    //Using Priority queue
    //Time Complexity: O(n log n)
    //Space Complexity: O(n)
    public int[] sortedSquares2(int[] nums) {
        PriorityQueue<Integer>pq =  new PriorityQueue<>( (a, b) -> a - b );
       
        for(int num:  nums){
           int sqrt = (int) Math.pow(num, 2);
           pq.add(sqrt);
        }
        int n = pq.size();
        // int[]result =  new int [n];
        for(int i = 0; i < n; i++){
            nums[i] = pq.poll();
        }
        return nums;
    }


    // Time Complexity: O(n)
    //Space complexity: O(n)
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int [] result = new int[n];
        int x = 0;
        while(left <= right){
            int lSqrt =  (int) Math.pow(nums[left],2);
            int rSqrt =  (int) Math.pow(nums[right],2);
  
            if( lSqrt >  rSqrt){
               result[x] = lSqrt;
               left++; 
            }else{
                result[x] = rSqrt;
                right --;
            }
            x++;
        }
        //Since values are reverse, we need to reverse the output
        reverse(result);
        
        return result;
      }
      public void reverse(int[] arr){
          int l = 0;
          int r = arr.length - 1;
          while(l <= r){
              int temp = arr[l];
              arr[l] = arr[r];
              arr[r] = temp;
              l++;
              r--;
          }
      }
}
