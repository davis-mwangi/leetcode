package arrays_and_hashing;
import java.util.*;

/**
 * https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/description/
 * 
 * Formulae result = (count +  1 ) / 2
 */
public class MinSwapsToBalanceString {
    
    public int minSwaps(String s){
        Stack<Character>stack = new Stack<>();
        int count = 0;
        for(char ch: s.toCharArray()){
            if(ch == '['){
                stack.push(ch);
            }else{
                if(!stack.isEmpty() && ch ==']'){
                    stack.pop();
                }else{
                    count++;
                }
            }
        }
        return (count + 1) / 2;
    }
    
}
