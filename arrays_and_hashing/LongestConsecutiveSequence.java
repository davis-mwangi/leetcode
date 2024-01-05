package arrays_and_hashing;
/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * 
 * Algorithm:
 *    We can use a set and add all nums in the set,
 *      we run through numbers, we check if there is preceeding number less than number, 
 *        else we start the count by incrementing by one untill all nums are exhausted.
 *         we get the longest
 *   
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
