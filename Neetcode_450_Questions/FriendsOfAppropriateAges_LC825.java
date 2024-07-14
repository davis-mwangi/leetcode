package Neetcode_450_Questions;

/*

https://leetcode.com/problems/friends-of-appropriate-ages/

*/
import java.util.*;

public class FriendsOfAppropriateAges_LC825 {
    class Solution {
        // Bruteforce
        // TC : O(N^2)
        // SC: O(1)
        /*
         * public int numFriendRequests(int[] ages) {
         * int count = 0;
         * for (int i = 0; i < ages.length; i++){
         * for(int j =0; j < ages.length;j++){
         * if(i==j){
         * continue;
         * }
         * if(canFriendRequest(ages, ages[i], ages[j] ) ){
         * count += 1;
         * }
         * }
         * }
         * return count;
         * 
         * }
         */
        // TC: O(N^2)
        // SC: O(N)
        public int numFriendRequests(int[] ages) {
            Map<Integer, Integer> ageCount = new HashMap<>();
            for (int age : ages) {
                ageCount.put(age, ageCount.getOrDefault(age, 0) + 1);
            }
            int friendRequestCount = 0;
            for (Integer ageA : ageCount.keySet()) {
                for (Integer ageB : ageCount.keySet()) {

                    if (!canFriendRequest(ages, ageA, ageB)) {
                        continue;
                    }
                    // Same age , cannot send to self
                    if (ageA == ageB) {
                        friendRequestCount += (ageCount.get(ageA) - 1) * ageCount.get(ageB);
                    } else {
                        friendRequestCount += (ageCount.get(ageA) * ageCount.get(ageB));
                    }
                }
            }
            return friendRequestCount;

        }

        private boolean canFriendRequest(int[] age, int from, int to) {
            // Rules
            if (to <= 0.5 * from + 7) {
                return false;
            }
            if (to > from) {
                return false;
            }
            if (to > 100 && from < 100) {
                return false;
            }
            return true;
        }
    }
}
