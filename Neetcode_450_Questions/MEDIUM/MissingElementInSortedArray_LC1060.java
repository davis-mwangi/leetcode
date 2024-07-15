package Neetcode_450_Questions.MEDIUM;

/*
Given an integer array nums which is sorted in ascending order and all of its elements are unique and given also an integer k, return the kth missing number starting from the leftmost number of the array.

 

Example 1:

Input: nums = [4,7,9,10], k = 1
Output: 5
Explanation: The first missing number is 5.
Example 2:

Input: nums = [4,7,9,10], k = 3
Output: 8
Explanation: The missing numbers are [5,6,8,...], hence the third missing number is 8.
Example 3:

Input: nums = [1,2,4], k = 3
Output: 6
Explanation: The missing numbers are [3,5,6,7,...], hence the third missing number is 6.

Solution : 

Binary Search Guide :  https://www.youtube.com/watch?v=WQRjK5jTvSc

*/
public class MissingElementInSortedArray_LC1060 {
    class Solution {
        /*
        4,7,9,10
       d = 7-4= 3
       TC : O(N)
       SC: O(1)
        */
        /*
        public int missingElement2(int[] nums, int k) {
            
            int res = 0;
            int n = nums.length;
            for(int i = 0;  i < n-1; i++){
                int diff = nums[i+1] - nums[i];
                if(diff != 1){
                    for(int num = nums[i] + 1; num < nums[i+1]; num++){
                        k--;
                        if(k == 0){
                            return num;
                        }
                    }
                }
            }
            if(k != 0){
                return nums[n-1] + k;
            }
            return -1;
        }
        */
        //Optimized Solution
       public int missingElement(int [] nums, int k){
            int startNumber = nums[0];
            int left = 0;
            int right = nums.length - 1;
            int mid = 0;
            int missingNumbers = 0;
            int expectedIdx = 0;
    
            while(left <= right){
                mid = left + (right - left) / 2;
                expectedIdx = nums[mid] - startNumber;
                missingNumbers = expectedIdx - mid;
                if(missingNumbers >= k){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            //When we come out of the loop will have 3 cases, when missing numbers less than k, greater than k or equal to k
    
            //Case 1: when missing are less than k , then value are mid - (k-missing) E.g [1,2,4], k = 3
            // mid =2, expectedIdx = (4-1)= 3, missingNumbers = (2-1)=1, therefore first missing => 4 + (k(3) - missing(1)) = 6
            System.out.println("Missing Numbers :: " + missingNumbers);
            if(missingNumbers < k){
                return nums[mid] + (k - missingNumbers);
            }
            //[4,7,9,10]  If missing == k, then the number is to the left of A[mid] since we can return current mid since its already present
            //This we minus - 1
            else{
                return nums[mid] + (k-missingNumbers) -1;
            }
    
        }
    }
}
