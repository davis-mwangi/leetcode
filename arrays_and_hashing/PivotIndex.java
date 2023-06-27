package arrays_and_hashing;

import java.util.Arrays;;
/*
https://leetcode.com/problems/find-pivot-index/

[1,7,3,6,5,6]
**/
//Time Complexity O(n^2)
//Space complexity O(1)
public class PivotIndex {

    public int pivotIndex(int[] nums){
        for(int i = 0; i< nums.length; i++){
            int l = i - 1 ;
            int r = i + 1;
            int lSum = 0;
            int rsum = 0;
            
            while(l >= 0){
             lSum += nums[l];
             l--;
            }   
 
            while(r < nums.length){
                rsum += nums[r];
                r++;
            }
            if(rsum == lSum){
                return i;
            }
 
        }
        return -1;
        
    }
}
//Time Complexity O(n)
//Space complexity O(1)
public class PivotIndex {

    public int pivotIndex(int[] nums){
        int total = Arrays.stream(nums).sum();
        int lSum = 0;

        for(int i = 0; i < nums.length; i++){
            int rSum = total - nums[i] - lSum;
            if(rSum == lSum){
                return i;
            }
            lSum += nums[i];
        }
        return -1;
        
    }
}
