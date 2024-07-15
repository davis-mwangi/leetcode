package Neetcode_450_Questions.HARD;

/*

Question :  https://leetcode.com/problems/alien-dictionary/description/

There is a new alien language that uses the English alphabet. However, the order of the letters is unknown to you.

You are given a list of strings words from the alien language's dictionary. Now it is claimed that the strings in words are 
sorted lexicographically
 by the rules of this new language.

If this claim is incorrect, and the given arrangement of string in words cannot correspond to any order of letters, return "".

Otherwise, return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there are multiple solutions, return any of them.

 
Example 1:

Input: words = ["wrt","wrf","er","ett","rftt"]
Output: "wertf"
Example 2:

Input: words = ["z","x"]
Output: "zx"
Example 3:

Input: words = ["z","x","z"]
Output: ""
Explanation: The order is invalid, so return "".
 
Example 4:
["z","x","a","zb","zx"]
Output: ""
Explanation: The order is invalid, so return "".

*/
import java.util.*;

public class AlienDictionary_LC269 {
    /*
     * Topological Sort Rules
     * 1. Find the vertes with an indegree of zero and add it to the Queue
     * 2. Remove the node from the outgoing edges fro. the graph
     * 3. Reassign in-degrees of the Nodes affected
     * Repeat the steps
     * 
     * 
     * Example:
     * ["z","x","a","zb","zx"]
     * {a=[z], b=[x], x=[a], z=[x]}
     */

    class Solution {
        public String alienOrder(String[] words) {

            // Create an adjacency list(graph)
            Map<Character, List<Character>> graph = new HashMap<>(); // {a;[b,f]}
            Map<Character, Integer> inDegree = new HashMap<>();

            // Initialize Graph and inDegree
            for (String word : words) {
                for (char ch : word.toCharArray()) {
                    graph.put(ch, new ArrayList<>());
                    inDegree.put(ch, 0);
                }
            }

            // Build Graph and InDegree
            for (int i = 0; i < words.length - 1; i++) {
                String first = words[i];
                String second = words[i + 1];

                int len = Math.min(first.length(), second.length());
                // Handle case where first is longer than second
                // E.g [wrt, wr]
                if (first.length() > second.length() && first.substring(0, len).equals(second)) {
                    return "";
                }

                // Compare character by character
                for (int j = 0; j < len; j++) {
                    char chF = first.charAt(j);
                    char chS = second.charAt(j);

                    if (chF != chS) {
                        graph.get(chF).add(chS);
                        inDegree.put(chS, inDegree.get(chS) + 1);

                        // Immediately we get a mismatch we update the graph
                        // and inDegree and break out of the loop
                        break;
                    }

                }

            }
            System.out.println(inDegree);

            // Start the Topological Sort
            Deque<Character> deque = new LinkedList<>();
            // Add the chracters with zero indegree
            for (Character ch : graph.keySet()) {
                if (inDegree.get(ch) == 0) {
                    deque.add(ch);
                }
            }

            StringBuilder res = new StringBuilder();

            while (!deque.isEmpty()) {
                char ch = deque.poll();
                res.append(ch);

                // Get Neighbors
                // Once we remove anode we need to reduce the indegree of the
                // neighboring nodes
                for (char neigh : graph.get(ch)) {
                    inDegree.put(neigh, inDegree.get(neigh) - 1);
                    if (inDegree.get(neigh) == 0) {
                        deque.add(neigh);
                    }
                }
            }
            // Check if all the character has been processed, else not lexigraphical order
            // could not be achieved
            // E.g ["z","x","a","zb","zx"]
            if (res.length() != inDegree.size()) {
                return "";
            }

            return res.toString();
        }
    }
}
