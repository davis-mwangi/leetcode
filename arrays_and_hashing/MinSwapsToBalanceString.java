package arrays_and_hashing;

import java.util.*;

/**
 * https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/description/
 * 
 
**** Intuition ****
Since at a given point, if the closing brackets are more than the open brackets, the string will not be balanced, so perform a swap whenever closing becomes more than the open brackets

**** Approach ****
Maintain counts of closing brackets, open brackets and swaps count,
We wont do manual swap but rather increment the swap count.

We iterate throught the string of brackets,

Whenever we find an open bracket "[" we increament open count by 1 and likewise, if we get a closing bracket "]" we increment the closing brackets counter by 1.

If closing brackets becomes more than the open , we increment swap, since a swap will be done to balance the brackets and then we reduce the closing by 1 and increase the open count 1.

At the end we return how many swaps has been made for the entire
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
