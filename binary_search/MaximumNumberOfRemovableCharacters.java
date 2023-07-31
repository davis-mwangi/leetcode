package binary_search;

/**
 * https://leetcode.com/problems/maximum-number-of-removable-characters/
 * 
 * Input: s = "abcacb", p = "ab", removable = [3,1,0]
   Output: 2

   The goal is to use binary search on removable array, such that all values we find upto mid we 
   can mark them using a special character e.g #  on string S,
   Then we can proceed to check if p is still a subsequence of the newly formed string.
   if we find they are still subsequence we can continue search on right, else if find its not we may search towards left.
 */
public class MaximumNumberOfRemovableCharacters {

    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0;
        int right = removable.length - 1;
        while(left <= right){
            int mid = left + ((right - left) / 2);
            StringBuilder sb = new  StringBuilder(s);
 
            //Replace the removable[i] with '#' so that we dont consider it
            for(int i = 0; i <= mid; i++){
                sb.setCharAt(removable[i], '#');
            }
            //Check if still p is subsquence of s
            if( isSubseq(sb.toString(), p)){
                left = mid + 1;
            }else{
                right = mid - 1;
            }  
        }
        return right + 1;
         
     }
 
     //Check if string is a subsequence of another
     private boolean isSubseq(String s, String subseq ){
        int i1 = 0;
        int i2 = 0;
 
        while(i1 < s.length() && i2 < subseq.length()){
            if( s.charAt(i1) != subseq.charAt(i2) ){
                i1 += 1;
                continue;
            }
            i1 += 1;
            i2 += 1;
        }
        return i2 >= subseq.length();
     }
}
