package Top_Leetcode_150.Arrays_and_Strings;
/*
https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150

*/
public class MergeSortedStrings_LC88 {
    class Solution {
        /*
        [1,2,3,0,0,0]
             ^
        [2,5,6]
             ^
    
        */
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            
            int i =  m - 1;
            int j =  n - 1;
            int k = nums1.length - 1;
    
            while (i >= 0 && j >= 0){
               
                if( nums1[i] > nums2[j] ){
                    nums1[k] = nums1[i];
                    i--;
                }else {
                    nums1[k] = nums2[j];
                    j--;
                }
                k--;
            }
    
            //Case when nums1 if not exhausted and nums2 is exhaust
            while(i >= 0){
                nums1[k] = nums1[i];
                k--;
                i--;
            }
    
            while(j >= 0){
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
    }
}
