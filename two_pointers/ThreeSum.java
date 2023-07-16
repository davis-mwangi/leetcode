package two_pointers;

import java.util.*;
/**
 * https://leetcode.com/problems/3sum/description/
 * 
 * Algo:
 *  1) sort
 *  2) sum = nums[i] + nums[l] + nums[r]
 *  3) use two sum II concept, if sum is greater reduce right if smaller reduce left, if matches add result
 *  4) incremenet the left counter for case of dublicates
 */ 
public class ThreeSum {
    //[-1,0,1,2,-1,-4]
    // l  i         r
    public List<List<Integer>> threeSum(int[] nums) {
        int n =  nums.length;
        List<List<Integer>>result = new ArrayList<>();
        //Sort Array
        Arrays.sort(nums);

        for(int i = 0; i < n -1; i++){
            int a = nums[i];
            if(i > 0 &&  a == nums[i -1]){
                continue;
            }
            int l = i + 1;
            int r = n - 1;
            while(l < r){
               int threeSum = a + nums[l] + nums[r];
               if(threeSum > 0){
                   r--;
               }else if(threeSum < 0){
                   l++;
               }else{
                    result.add(Arrays.asList(a,nums[l], nums[r]));
                    l += 1;

                    //Duplicate [-1,0,1,2,-1,-1,-1,-1,-4]
                    while( (l < r) && (nums[l] == nums[l - 1]) ){
                        l += 1;
                    }
               }
            }
        }
        return result;
    }
}
