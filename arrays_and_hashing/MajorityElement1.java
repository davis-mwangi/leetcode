package arrays_and_hashing;

import java.util.HashMap;
import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/next-greater-element-i/
 * 496. Next Greater Element I
 * 
 */

 //Time Complexity: O(n*m)
 //Space Complexity: O(n)
 //Monotonic Decreasing stack
public class MajorityElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map nums1 array to index
        HashMap<Integer, Integer> nums1Idx = new HashMap<>();
        Stack<Integer>stack =  new Stack();
        int[] result = new int[nums1.length];
        
        for(int i = 0;  i < nums1.length; i++){
           nums1Idx.put(nums1[i], i);
           result[i] = -1;
        }

        for(int i =0; i < nums2.length; i++){
            int curr =  nums2[i];
            while(!stack.isEmpty() &&  curr > stack.peek()){
                int val =  stack.pop();
                int index =  nums1Idx.get(val);
                result[index] = curr;
            }
            if(nums1Idx.containsKey(curr)){
                stack.push(curr);
            }
        }
        return result;


    }
}
