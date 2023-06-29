package arrays_and_hashing;
/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
import java.util.*;

//Time Complexity:  O(n)
//Space Complexity: O(n)
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums){
        Set<Integer>hashSet =  new HashSet<>();
       
        for(int num :  nums){
            hashSet.add(num);
        }
        
        int longest = 0;
        
        
        for(int num: nums){
            
            if(!hashSet.contains( (num-1 ) )){
                int j = 0;
                
                while (hashSet.contains( (num + j) ) ){
                    j++;
                }
                
                longest = Math.max(longest, j);
            }
        }
        return longest;
    }
}
