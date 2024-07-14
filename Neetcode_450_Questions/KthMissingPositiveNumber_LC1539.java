package Neetcode_450_Questions;
/*

https://leetcode.com/problems/kth-missing-positive-number/description/

O(N) Solution : https://www.youtube.com/watch?v=R15876l3tSE

O(Log N) Solution

*/
public class KthMissingPositiveNumber_LC1539 {

    class Solution1 {
        //TC: O(N)
        //SC: O(1)
     public int findKthPositive(int[] arr, int k) {
            //Case 1: the first item not 1
            if(arr[0] != 1){
                if(arr[0] - 1 >= k){
                   return k;
                }else{
                    //Decrement by 1 to A[0] E.g A[0] = 3 k =5
                    k -= ( arr[0] -1);
                }
            }
     
            // Case : 2
            int i = 0;
            int n = arr.length;
            while(i < n - 1){ 
                int diff = arr[i+1] - arr[i];
                if(diff != 1){
                      for(int x = arr[i] + 1; x < arr[i+1]; x++){
                          k -= 1;
    
                          if(k == 0){
                            return x;
                          }
                      }
                }
                i++;
            }
            //Case: end of array
            if(k != 0){
                return arr[n-1] + k;
            }
            return -1;
    
        }
    }
}
