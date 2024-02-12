package arrays_and_hashing;
/*
https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/


*/
public class  FindTheIndexOfTheFirstOccurrenceInAString {
    
    class Solution {
        //Intuition: checking if string needle is a sub string of haystack
        // get the startig index
        /*
         sadbutsad
         ^ ^
         sad
         Algorithm:
           compare the characters starting from first match , we use pointer j
            If j goes beyond size of needle then there is a match hence return start of i which is i - j
            else no match in character iterate to next character
            In case the all characters dont match then we reset both j and i by subtracting j iterations from i,
              then move to the next  iteration.
    
        */
        // public int strStr(String haystack, String needle) {
        //          return haystack.indexOf(needle);
        // }
    
         public int strStr(String haystack, String needle) {
                int i = 0; 
                int h = haystack.length();
                int n = needle.length();
                while(i < h){
                    int j = 0;
                    while( j < n && haystack.charAt(i) == needle.charAt(j) ){
                        i++;
                        j++;
                    }
                    if(j == 0){
                        i++;
                    }else if(j == n){//If j goes beyond needle size then we have found match, so return start of i
                        return i - j;
                    }else{ // Reset i if needle word was not found in haystack
                       i = (j - i) + 1;
                    }
                }
                return -1;
        }
    }
}
