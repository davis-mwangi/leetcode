package Neetcode_450_Questions;
/*
https://leetcode.com/problems/next-greater-element-i/description/

*/
import java.util.*;
public class NextGreaterElement_I_Easy_LC496 {
    class Solution {
        /*
    [2,4] [1,2,3,4]
    [3,-1]
 
     Algorithm: 
      - Add all items in nums1 in map with its respective index;
      -  Iterate through nums2 array, checking if the value in nums2 exists in our map
      -  If it does its our candidate to check the next greater number, we do this by using a nested loop starting 
        at i + 1, since we only comparing next element. If we find the first greater element we add it to our result
        and break out of the inner loop.

        Time Complexity:  O(m * n)
        Space Complexity : O(m)

        */
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int n1 = nums1.length;
            int n2 = nums2.length;
            int [] ans = new int[n1];
            Arrays.fill(ans, -1);
            Map<Integer, Integer>map = new HashMap<>();
            
            for(int i = 0; i < n1; i++){
                map.put(nums1[i], i);
            }
    
            for( int j = 0; j < n2; j++) {
                if( !map.containsKey(nums2[j]) ){
                   continue;
                } 
                for(int i = j+1; i < n2; i++){
                    if( nums2[i] > nums2[j] ){
                        int idx =  map.get(nums2[j]);
                        ans[idx] = nums2[i];
                        break;
                    }
                }
            }
            return ans;
            
        }
       
    }


    class Solution2 {
        /*
    Using Monotonic decreasing stack
    nums1 = [4,1,2], nums2 = [1,3,4,2]
    Stack = [1]
    map = {4:0, 1:1, 2: 2}
        */
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            //Add items of nums1 to map
            Map<Integer, Integer>map = new HashMap<>();
            for(int i = 0; i < nums1.length; i++){
                map.put(nums1[i], i);
            }
    
            //Use monotonic descreasing stack
            Stack<Integer>monotonicStack = new Stack<>();
            int [] ans = new int[nums1.length];
            Arrays.fill(ans, -1);
            for(int j = 0; j < nums2.length; j++){
                int curr = nums2[j];
                while(!monotonicStack.isEmpty() && curr > monotonicStack.peek() ){
                    int popped = monotonicStack.pop();
                    int idx = map.get(popped);
                    ans[idx] = curr;
                }
                //We add only items in nums1
                if(map.containsKey(curr)){
                    monotonicStack.push(curr);
                }
            }
            return ans;
        }
    }
}
