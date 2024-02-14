package arrays_and_hashing;
/*
https://leetcode.com/problems/largest-number/

*/
import java.util.*;
public class  LargestNumber {
    class Solution {
        /*
        [3,30,34,5,9] => "9534330"
    
        */
        public String largestNumber(int[] nums) {
            int n =  nums.length;
            //convert int nums to string array
            String [] strs = new String[n];
            
            for(int i = 0; i < n; i++){
                strs[i] = Integer.toString(nums[i]);
            }
            //Sort the string per  size
            Arrays.sort(strs, new CustomComparator() );
    
            //Handle case when res is "00000" we need to return "0"
            String large = String.join("", strs);
            
            // Remove trailing zeros
            StringBuilder sb = new StringBuilder(large);
            
            if(sb.charAt(0) == '0'){
                int i = 0;
                while(i < sb.length() && sb.charAt(i) == '0' ){   
                    sb.deleteCharAt(i);
                    i++; 
                }
            }
            return sb.toString();
        }
    
    
        static class CustomComparator implements Comparator<String> {
            @Override
            public int compare(String str1, String str2){
                if( Long.parseLong(str1+str2) > Long.parseLong(str2 + str1) ){
                    return -1;
                }else {
                    return 1;
                }
            }
        }
    }
}
