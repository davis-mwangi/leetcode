package binary_search;
/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * YouTube Guide: https://www.youtube.com/watch?v=U8XENwh8Oy8
 * Input: nums = [4,5,6,7,0,1,2], target = 0
   Output: 4
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int n =  nums.length;
        int left = 0;
        int right =  n - 1;
        while(left <=  right){
            int mid = left + ((right - left)/2);
            
            if(nums[mid] == target){
                return mid;
            }

            //Search left sorted array portion
            if(nums[mid] >= nums[left]){
                if(target >  nums[mid]){//search right
                  left = mid + 1;
                }else if(target < nums[left]){//Search right
                   left  = mid + 1;
                }else{ //search left portion
                    right =  mid - 1;
                }

            }else{//Search right  sorted array portion
               
                if(target > nums[right]){//search left
                   right =  mid -1;
               }else if(target < nums[mid]){//Search left
                   right= mid - 1;
               }else{//search the right portion
                   left = mid + 1;
               }
            }
        }
        return -1;

    }
    
}
