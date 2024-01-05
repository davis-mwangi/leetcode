package arrays_and_hashing;

/**
 * https://leetcode.com/problems/length-of-last-word/
 * 
 * Algorithm:
 * 
 *    Since we want to count the length  of last word,
 *       We can approach the question from the end, and skip the white spaces,
 *        then count until we get white space, and return the length;
 * 
 * Time Complexity  O(n)
 * Space Complexity O(1)
 */
public class LengthOfLastWord {

    //s =  "Hello World "
    //           ^   n = length - i
    public int lengthOfLastWord(String s){
       
        int i =  s.length() - 1; 
        int len = 0;

        //Skip white spaces
        while(i >=0 && Character.isWhitespace(s.charAt(i))){
            i-=1;
        }
        //Calculate length after white space
        while(i >= 0 && !Character.isWhitespace(s.charAt(i))){
            len++;
            i-= 1;
        }
        return len;

    }
}
