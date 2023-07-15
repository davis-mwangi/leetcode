package two_pointers;

public class ValidPalindromeII {
    // abca => abc a | a bca
    // l  r
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() -1;
        while(left <= right){
             if(s.charAt(left) == s.charAt(right)){
                 left++;
                 right--;
             }else{
                 return (isValidPalindrome(s, left, right - 1) || isValidPalindrome(s, left+ 1 , right) );
             }
        }
        return true;
     }
 
     public boolean isValidPalindrome(String s, int left, int right ){
       while(left <= right){
           if(s.charAt(left) == s.charAt(right)){
             left++;
             right--;
           }else {
             return false;
           }
           
       }
       return true;
     }
}
