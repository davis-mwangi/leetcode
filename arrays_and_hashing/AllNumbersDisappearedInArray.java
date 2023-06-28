package arrays_and_hashing;
/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 * 
 */

 import java.util.*;
 //Solution 1:
 //Time Complexity: O(n)
 //Space Complexity: O(n)
public class AllNumbersDisappearedInArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer>set = new HashSet<>();
        List<Integer>result = new ArrayList<>();

        int n = nums.length;
       
        for(int  i = 1;  i<= n; i++){
           set.add(i);
        }

        for(int i = 0; i<  n; i++){
            if(set.contains(nums[i])){
                set.remove(nums[i]);
            }
        }
        result.addAll(set);
    
        return result;
    }

}

//Solution 2:
 //Time Complexity: O(n)
 //Space Complexity: O(1)
 public class AllNumbersDisappearedInArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer>result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            int index = Math.abs(nums[i]) - 1;
            nums[index] = Math.abs(nums[index]) * -1;
        }

        for(int i = 0; i <  nums.length; i++){
            if(nums[i] > 0){
               result.add( (i+1) );
            }
        }
        return result;
    }

}

