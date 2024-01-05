package arrays_and_hashing;
/**
 * https://leetcode.com/problems/longest-common-prefix/
 * 
 * Algorithm
 *     Pick one string, iterate from first  character to end , 
 *        loop through each word and compare it with character position in string picked first
 *     
 *       Note edge case where string picked is smaller,  whenenever i becomes bigger than current word we just return
 *       the formed characters. 
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
