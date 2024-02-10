package arrays_and_hashing;

import java.util.*;

/**
 * https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/description/
 * 
 * Formulae result = (count + 1 ) / 2
 * 
 * Algorithm:
 *    Keep track of how many extra closing brackets ,
 *       - whenever we find  a closing bracket we add 1 and for opening we -1
 *    - we also keep track of maximum closing bracket 
 * 
 *     One observation is if we perform one swap E.g on ]]] | [[[ ==> []] | ][] the extra closing brakets
 *     will be reduced by 2, since each the brackets cancels each other from 3 not its  1 
 *     If we do another swap []]][]  ==> [][][]   1 - 2 = 0 
 * 
 * 
 */
public class MinSwapsToBalanceString {


   // Best Easy to Understand Solution
   // Guide: https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
    class Solution {
        //closed, open  brackets count
        //When closed becomes more than open swap, then decrease closing and increase open
     
         public int minSwaps(String s) {
             int closing = 0;
             int open = 0;
             int swaps = 0;
             for(char bracket : s.toCharArray() ){
                 if(bracket == '['){
                     open += 1;
                 }else {
                     closing += 1;
                 }
                 //Case when closing are more than open
                 if(closing >  open){
                     //Perform swap
                     swaps += 1;
                     //Reduce closing and increase opening
                     closing -= 1;
                     open += 1;
                 }
             }
             return swaps;
     
             
         }
     }

    //Space Complexity: O(n)
    //Time Complexity: O(n)
    //Helpful Videos: https://www.youtube.com/watch?v=17hUpx4GdEA
    public int minSwaps2(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '[') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() && ch == ']') {
                    stack.pop();
                } else {
                    count++;
                }
            }
        }
        return (count + 1) / 2;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    //Guide:  https://www.youtube.com/watch?v=3YDBT9ZrfaU
    public int minSwaps(String s) {
        int extraClosingbrackets = 0, max = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i)== ']') {
                extraClosingbrackets++;
                max = Math.max(extraClosingbrackets, max);
            }
            else 
                extraClosingbrackets--;
        }

        return (max + 1) / 2;
    }

}
