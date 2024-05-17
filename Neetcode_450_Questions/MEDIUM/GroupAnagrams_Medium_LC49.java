package Neetcode_450_Questions.MEDIUM;

/*

https://leetcode.com/problems/group-anagrams/description/

*/
import java.util.*;

public class GroupAnagrams_Medium_LC49 {
    class Solution {
        /*
         * HashMap {hash : [eat,tea,ate]}
         * characters 25
         * 
         * ["eat","tea","tan","ate","nat","bat"]
         */
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] chars = new char[26];

                for (char ch : str.toCharArray()) {
                    chars[ch - 'a']++;
                }
                // convert to string
                String hash = new String(chars);
                if (!map.containsKey(hash)) {
                    map.put(hash, new ArrayList<>());
                }
                map.get(hash).add(str);

            }
            List<List<String>> ans = new ArrayList<>();
            ans.addAll(map.values());
            return ans;
        }
    }
}
