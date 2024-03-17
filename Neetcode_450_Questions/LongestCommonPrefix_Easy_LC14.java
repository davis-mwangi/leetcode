package Neetcode_450_Questions;
/*

https://leetcode.com/problems/longest-common-prefix/description/

*/
public class LongestCommonPrefix_Easy_LC14 {
    class Solution {
        /*
         flower","flow","flight, flow
        1. pick one string
        2. iterate through each word, whenever we find a mismatch we return the result
    
         flowwer => flow

         Time Complexity : O(m * n) m = length of selected word, n = size of array
         Space Complexity : O(1)
        */
        public String longestCommonPrefix(String[] strs) {
            int n = strs.length;
            if(n == 0){
                return "";
            }
            if(n == 1){
                return strs[0];
            }
            String word = strs[0];
            StringBuilder common = new StringBuilder();
            int wordLen = word.length();
            for (int i = 0; i < wordLen; i++){
                for(String str: strs){
                    if(i >= str.length() || str.charAt(i) != word.charAt(i)){
                        return common.toString();
                    }
                }
                //If all we found matching character, we add it to the result
                common.append(word.charAt(i));
            }
            return common.toString();
        }
    }
}
