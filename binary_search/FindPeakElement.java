package binary_search;
/**
 * https://leetcode.com/problems/find-peak-element/
 * 
 * Notes: Since we finding pick element, we wil pick the side with the value greater than our
 * mid element since we are guaranted either we find a deep or we find another value greater.
 * 
 */
public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int n =  nums.length;
       int left = 0;
       int right =  n - 1;

        while(left <=  right){
            int mid = left + ((right - left) / 2);

            //Left neighbor greater, avoid the ones on the beginning
            if( (mid > 0) &&  nums[mid -1] > nums[mid]){
                right = mid - 1;

             //Right neighbor greater , avoid one on the last end since its a candidate of pick element 
            }else if( (mid < (n - 1))  &&  nums[mid + 1] > nums[mid]){
                left = mid + 1;
            
            //Return the pick element
            }else {
                 return mid;
            }
        }
        return  -1;
    }
}
