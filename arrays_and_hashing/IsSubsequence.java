package arrays_and_hashing;

/**
 *  https://leetcode.com/problems/is-subsequence/
 * 
 * A subsequence of a string is a new string that is formed from 
 * the original string by deleting some (can be none) of the 
 * characters without disturbing the relative positions of 
 * the remaining characters. (i.e., "ace" is a subsequence of "abcde"
 *  while "aec" is not).
 */
public class IsSubsequence {
    //s [abc] i
    //t [addbaac] j
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        while(i < s.length() && j < t.length()){
            
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        //If i is equal to length of s then its subsequence
        return i == s.length();
        
    }
}
