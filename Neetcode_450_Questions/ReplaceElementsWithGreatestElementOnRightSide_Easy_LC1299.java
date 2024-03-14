package Neetcode_450_Questions;
/*
https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/description/

*/
public class ReplaceElementsWithGreatestElementOnRightSide_Easy_LC1299 {
   
    class Solution {
        /*
       [17,18,5,4,6,1] 
        move right to left, tracking gretest element
    
       Time Complexity : O(n) + O(n)
       Space Complexity : O(1)
        */
        public int[] replaceElements(int[] arr) {
            int i = arr.length - 1;
            int max = arr[i];
            while(i > 0){
                if(max > arr[i]){
                    arr[i] = max;
                }
                max = Math.max(max, arr[i]);
                i--;
            }
    
            for(int j = 0; j < arr.length; j++){
                if(j == arr.length - 1){
                    arr[j] = -1;
                    break;
                }
                arr[j] = arr[j + 1];
            }
    
            return arr;
        }
    }
}
