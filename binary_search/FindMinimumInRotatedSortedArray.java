package binary_search;
/**
 * 
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * 
 * Trick is using a binary search, then 
 * if nums[mid] > nums[left]:
 *    then its a valid sorted portion
 */
public class FindMinimumInRotatedSortedArray {
    /**
sorted asc
[0,1,2,4,5,6,7]  4 times => [4,5,6,7,0,1,2]
[0,1,2,4,5,6,7]  7 times => [0,1,2,4,5,6,7]
[4,5,6,7,0,1,2]
l      m     r
 */

public int findMin(int[] nums) {
    int n = nums.length;
    int l = 0;
    int r =  n - 1;
    int res = nums[0];
    while(l <= r){
        //check if valid sorted array, pick left value and end loop
        if(nums[l] <= nums[r]){
            res = Math.min(res, nums[l]);
            return res;
        }
        int mid = l + ((r - l) / 2);
        res = Math.min(res, nums[mid]);

        
        if(nums[mid] >= nums[l]){//search right
            l = mid + 1;
        }else{ // search left
            r = mid - 1;
        }
    }
  
    
}
