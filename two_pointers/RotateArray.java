package two_pointers;
/**
 * https://leetcode.com/problems/rotate-array/description/
 */
public class RotateArray {
    //using an extra array
    //Time Complexity:  O(n)
    //Space Complexity: O(n)
    public void rotate(int[] nums, int k) {
        int n =  nums.length;
        int [] arr = new int[n];

        for(int i = 0; i < n; i++){
            int index = (i+k) % n;
            arr[index] = nums[i];
        }

        for(int i = 0; i< n; i++){
            nums[i] = arr[i];
        }  
    }

    //reverse the entire array [1,2,3,4,5,6,7] => [7,6,5 ,4,3,2,1] k = 3
    //reverse k array [5,6,7   ,4,3,2,1] 
    //reverse  n-k => [5,6,7,1,2,3,4]
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
         //for k to be within lenghth of array
         k = k % n;
  
         reverse(nums, 0, n -1);
         reverse(nums, 0, k-1);
         reverse(nums, k, n -1 );
      }
      private void reverse(int[]nums, int left, int right){
          while(left <= right){
              int temp = nums[left];
              nums[left] = nums[right];
              nums[right] = temp;
              left++;
              right--;
          }
      }
}
