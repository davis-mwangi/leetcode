/**
 * https://leetcode.com/problems/contains-duplicate/
 */

//Time Complexity : O(n)
//Space Complexity:  O(n)
package arrays_and_hashing;

class Solution {
    public boolean containsDuplicate(int[]nums){
        Set<Integer>set = new HashSet<>();
        int n =  nums.length;
        for(int i =0; i < n; i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}