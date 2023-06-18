package arrays_and_hashing;

import java.util.HashMap;

public class TwoSum {
    // nums = [1,6,3,7,7]
    // target = 9
    //return  [2,3]
    public int[] twoSum(int [] nums, int target) {
        //HashMap {8: 0, 3: 1 , 6:2, 2:3, 2:4}
        int n = nums.length;
        HashMap<Integer, Integer>remIndexMap= new HashMap<>();
       
        for(int i = 0; i < n; i++){
            
            if(remIndexMap.containsKey(nums[i])){
                return new int[]{remIndexMap.get(nums[i]), i};
            }
            int rem = target - nums[i];
            remIndexMap.put(rem, i);
        }
        return new int[]{};
    }    
    
}
