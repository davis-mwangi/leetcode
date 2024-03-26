package Neetcode_450_Questions;
/*


*/
import java.util.*;

public class FindAllNumbersDisappearedInAnArray_Easy_448 {

    //Bruteforce Solution
    class Solution1 {
        /*
         1 -> n 
         0 -> n -1
    
        1.sort 
    
        1,2,3,3,4, 7, 8

        Time Complexity : O(N)
        Space Complexity : O(N)
        */
        public List<Integer> findDisappearedNumbers(int[] nums) {
            Set<Integer>set = new HashSet<>();
            int n = nums.length;
            for(int i = 0; i< n; i++){
                set.add(nums[i]);
            }
            List<Integer>ans = new ArrayList<>();
            for(int i= 1; i <= n; i++){
                if(!set.contains(i)){
                   ans.add(i);
                }
            }
            return ans;
        }

        //Optimal Solution
        //Time Complexity : O(N)
        //Space Complexity : (1)
        class Solution2 {
            /*
             [-4,-3,-2, -7,  8, 2, -3, -1]
              0  1  2    3   4  5   6    7             
            */
            public List<Integer> findDisappearedNumbers(int[] nums) {
                int n = nums.length;
                for(int i = 0; i < n; i++){
                    int num =  Math.abs(nums[i]);
                    int idx = num - 1;
                    if(idx >= 0 && idx < n &&  (nums[idx] > -1 ) ){
                        nums[idx] *= -1; 
                    }
                }
                
                List<Integer>ans = new ArrayList<>();
                for(int i = 0; i < n; i++){
                    if(nums[i] > 0){
                        ans.add(i+1);
                    }
                }
                return ans;
            }
        }
    }
}
