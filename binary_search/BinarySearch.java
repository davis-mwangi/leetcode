package binary_search;
/**
 * https://leetcode.com/problems/binary-search/
 */
public class BinarySearch {
    //Time Complexity: O(log 2 N ) ~ O(log N)
    //Space Complexity: O(1)
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
           
            int mid = (right + left) / 2;
            
            if(nums[mid] == target){
                return mid;
            }

            if(target > nums[mid]){
               left = mid + 1;
            }else{
               right = mid - 1;
            }
        }
        return -1;
    }
}
