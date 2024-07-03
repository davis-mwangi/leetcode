package Neetcode_450_Questions.MEDIUM;

/*
https://leetcode.com/problems/group-shifted-strings/description/

Guide: https://www.youtube.com/watch?v=g_CWHtPSQmQ
*/

import java.util.*;

public class GroupShiftedStrings_LC249 {
    class Solution {
        /*
         * ["abc","bcd","acef","xyz","az","ba","a","z"]
         * [1,1] =[abc, bcd, xyz]
         * [2,2,1] = [acef]
         * [25] =[az]
         * [-1] = [ba]
         * [-1] =[a]
         * [-1] = z
         * 
         */
        public List<List<String>> groupStrings(String[] strings) {
            Map<String, List<String>> charDiffMap = new HashMap<>();

            for (String str : strings) {

                StringBuilder charDiff = new StringBuilder();

                if (str.length() == 1) {
                    charDiff.append("-1");

                } else {
                    for (int i = 1; i < str.length(); i++) {
                        int diff = (str.charAt(i) - 'a') - (str.charAt(i - 1) - 'a');
                        if (diff < 0) {
                            diff = ((diff % 26) + 26) % 26;
                        }
                        charDiff.append(diff);
                        charDiff.append(":");
                    }
                }
                if (!charDiffMap.containsKey(charDiff.toString())) {
                    charDiffMap.put(charDiff.toString(), new ArrayList<>());
                }
                charDiffMap.get(charDiff.toString()).add(str);
            }

            List<List<String>> ans = new ArrayList<>();
            ans.addAll(charDiffMap.values());
            return ans;
        }
    }
}
