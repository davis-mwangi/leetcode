package binary_search;
/**
 * 
 * https://leetcode.com/problems/search-insert-position/description/
 * 
 * We do a binary search, if we get the match we return the value
 * else we return left pointer reason been, 
 * E.g  t = 1 , [2] => in this case if we return right it will  opposite of left pointer
 *      l = 0, r = -1, so left
 *      t =  3  [2] => in this case l = 1 , since target is greater than value
 *      hence we can always return left pointer.
 * 
 */
public class SearchInsertPosition {

    //Time Complexity: O(log n)
    // Space Complexity: O(n)
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1 ;

        while(left <=  right){
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
        return left;    
    }
}
