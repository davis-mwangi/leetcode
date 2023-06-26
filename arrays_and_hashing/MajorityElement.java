package arrays_and_hashing;
/**
 * https://leetcode.com/problems/majority-element/
 */
//Solution: 1 
//Space Complexity: O(n) Time complexity O(n) + O(n) => O(2n) ~ O(n)
public class MajorityElement {
    
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int n  =  nums.length;
        int app = n / 2;

        for(int i = 0; i < n; i++){
            if(!map.containsKey(nums[i])){
              map.put(nums[i], 0);
            }
           map.put(nums[i], map.get(nums[i]) + 1 );
        }
        
        for(Integer num: map.keySet()){
            if(map.get(num) > app){
                return num;
            }
        }
        return -1;

    }
}
