package arrays_and_hashing;

/**
 * https://leetcode.com/problems/valid-anagram/
 */

public class ValidAnagram {
    public boolean isAnagram (String s, String t){
          //Check if string of same length
        //use hashing of characters(uniCode) (b -a =1)
        //Compare if  2 hashes are equal
        int sn = s.length();
        int tn = t.length();

        char [] chars  =  new char[26];//by default it zero
        if(sn != tn){
            return false;
        }

        for(int i = 0; i < sn; i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            
            chars[cs - 'a']++;
            chars[ct - 'a']--;  
        }
        for(int i =0; i < 25; i++){
            if(chars[i] >0){
                return false;
            }
        }

        return true;
    }
    
}
