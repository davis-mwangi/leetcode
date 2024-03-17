package Neetcode_450_Questions;
/*
https://leetcode.com/problems/two-sum/description/
*/
import java.util.*;
public class TwoSum_Easy_LC1 {
    class Solution1 {
        /*
         0.1 2  3
        [2,7,11,15], target = 9
         
         {7:i, }


         Time Complexity : O(N)
         Space Complexity : O(N)
        */
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer>map = new HashMap<>(); // {remainder : index of first occurrence}
            for(int i = 0; i < nums.length; i++){
                int remainder =  target - nums[i];
                if(map.containsKey(nums[i])){
                    return new int[]{map.get(nums[i]), i};
                }
                map.put(remainder, i);
            }
            return new int[]{-1, -1};
        }
    }

    //Variation if we were to find if there is a target or not
    class Solution{
        public static boolean twoSum(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            Arrays.sort(nums);
            while( left < right){
                int sum = nums[left] + nums[right];
                //Sum equals target then we found our match
                if(sum == target){
                    return  true;
                }
                //Case sum is bigger than target, then we reduce right to get a smaller number
                if(sum > target){
                    right--;
                }else if(sum < target){ // we try find a bigger number, so increment left pointer
                    left++;
                }
    
            }
            return false;
            
        }
    }
}
