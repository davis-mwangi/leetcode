package binary_search;
/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 * 
 * Algo :
 * Run binary search and obtain the furthest index to the right
 * Rum another binary search and obtain the further index to the left
 * 
 * This  will be 2 * O(log n)
 * //5,7,7,8,8,8,8,10
    //l      m     r
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    //Time Complexity: O(log n) + O (log n)
    //Space Complexity: O(1)
    //5,7,7,8,8,8,8,10
    //l       m     r
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n -1;
       
        int rightIdx = -1;

        while(left <= right){
            int mid = left + ((right - left)/2);
            
            if(target > nums[mid]){
                left = mid + 1;
            }else if(target < nums[mid]){
                right = mid - 1;
            }else{
                rightIdx = mid;
                left = mid + 1;
            }
        }
        
        left = 0;
        right = n -1;
        int lefttIdx = -1;
        while(left <= right){
            int mid = left + ((right - left)/2);
            
            if(target > nums[mid]){
                left = mid + 1;
            }else if(target < nums[mid]){
                right = mid - 1;
            }else{
                lefttIdx = mid;
                right = mid - 1;
            }
        }
        return new int[]{lefttIdx,rightIdx};

    }
}
