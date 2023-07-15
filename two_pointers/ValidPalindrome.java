package two_pointers;
/***
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {
    // A man, a plan, a canal: Panama
    //Time Complexity : O(n)
    //Space Complexity: (1)
    public boolean isPalindrome(String s) {
        //Remove Special Characters
        String pattern = "[^a-zA-Z0-9]";
        String re = s.replaceAll(pattern, "").toUpperCase();
        //Use 2 pointers
        int l = 0;
        int r = re.length() - 1;

        while(l <= r){
            if(re.charAt(l) != re.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
        
    }
}
