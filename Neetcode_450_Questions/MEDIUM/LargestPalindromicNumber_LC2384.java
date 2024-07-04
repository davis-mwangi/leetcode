package Neetcode_450_Questions.MEDIUM;
/*
https://leetcode.com/problems/largest-palindromic-number/description/

Guide: https://www.youtube.com/watch?v=UOenJWenzz8

1.Since its digits only, we can  have  an an array holding digits 0 to 9, then determine their frequency
2.Iterate from right to left, and pick any number whose count is greater than 2
3. We divide by 2 to get a value per pair and add the digits to a string builder
   -> We ignore any zero if we dont any digit yet in our first half.
4. Iterate from  right to left and pick the first number we find oddd, incase we dont we return -1;
5. We append the first half, the center value and reverse of first half.
   - Handle case where we dont find center value(no odd number)
   - Handle case where all values are zeros and its even, then we return zero


*/
public class LargestPalindromicNumber_LC2384 {
    class Solution {
        public String largestPalindromic(String num) {
           int [] digits =  new int[10];
           for(char ch : num.toCharArray() ){
                digits[ch - '0']++;
           } 
    
           //Iterate from right to left picking the biggest number > 
           int n =  digits.length; // 10
           StringBuilder firstHalf = new StringBuilder();
           for(int i = n-1; i >= 0; i--){
                 if(digits[i] > 1){
                     //Handle case for zero e.g "00009"
                     //Only append zero if there is already a digit
                     if(firstHalf.length() == 0 && i==0){
                        continue;
                     }
    
                     int count = digits[i] / 2;
                      while(count > 0){
                        firstHalf.append(i);
                        count--;
                      }
                 }
           }
    
           //Move from  right to left looking for first  odd big number
           int centerDigit = -1;
           for(int i =  n - 1; i >= 0; i--){
                if(digits[i] % 2 != 0){
                    centerDigit = i;
                    break;
                }
           }
           StringBuilder secondHalf = new StringBuilder(firstHalf);
    
           //Handle case the digits are even and no odd number
           if(centerDigit == -1){
    
              //Handle even zeros E.g 0000
              if(firstHalf.length() == 0){
                  return "0";
              }else{
                  return firstHalf.append(secondHalf.reverse()).toString();
              }
           }
           return firstHalf.append(centerDigit).append(secondHalf.reverse()).toString();
        }
    }
}
