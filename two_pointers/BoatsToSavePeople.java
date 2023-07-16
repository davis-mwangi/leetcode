package two_pointers;
import java.util.*;

/**
 * 
 * https://leetcode.com/problems/boats-to-save-people/description/
 * 
 * Algorithm:
 *   Sort array [3,2,2,1] => [1, 2, 2, 3]
 *   Be greedy, allocate the heaviest to the boat, if remainder can accomodate 
 *       smaller one , add it as well.
 * 
 */
public class BoatsToSavePeople {

    // Time Complexity: O(n log n) + O(n) ~ O(n log n)
    // Space complexity: O(1)
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int n = people.length;
        int l = 0;
        int r = n - 1;

        int res = 0;
        while(l <= r){
           int rem = limit - people[r];
           res += 1;
           r -= 1;
           if(l <= r && rem >= people[l]){
              l += 1;
           }
        }
        return res;
    }
    
}
