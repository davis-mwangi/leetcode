package arrays_and_hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/group-anagrams/
 * // Use unicode to create a hash [tea, tan, ate] [20, 19, 25]
 * // hash: [tea, ate]
 */
public class GroupAnagrams {
    
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>>hashStrMap = new HashMap<>();
        List<List<String>>result = new ArrayList<>();

        for(String word: strs){
            //get hash of the word
            char[] chars = new char[26];
            for(int i = 0; i < word.length(); i++){
                chars[word.charAt(i) - 'a']++;
            }
            String str= new String(chars);

            if(hashStrMap.containsKey(str)){
                hashStrMap.get(str).add(word);
            }else{
                List<String>lst = new ArrayList<>();
                lst.add(word);
                hashStrMap.put(str, lst);
            }
        }

        for(Map.Entry<String,List<String>> entry: hashStrMap.entrySet()){
             result.add(entry.getValue());
        }
        return result;
    }
}
