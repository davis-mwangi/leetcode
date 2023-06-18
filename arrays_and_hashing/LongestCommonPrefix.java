package arrays_and_hashing;
/**
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * ["flower", "flow","flight"]
 *  str = flower
 */
public class LongestCommonPrefix {
    
    public String longestCommonPrefix(String [] strs) {

        String first = strs[0];
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < first.length(); i++){
            char ch = first.charAt(i);

            for(String word: strs){
                if(i >= word.length() ||  ch != word.charAt(i)){
                    return sb.toString();
                }
            }
            sb.append(ch);
        }
        return sb.toString();

    }
}
