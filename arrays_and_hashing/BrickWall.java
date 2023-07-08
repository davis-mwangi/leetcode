/**
 * https://leetcode.com/problems/brick-wall/description/
 */
//Time Complexity: O(m * n)
//Space Complexity:  O(m * n)
//Trick, take gap's position as keys and count number of gaps
//Take the size - maximum gaps
public class Solution {

    public int leastBricks(List<List<Integer>> wall) {

        //Create a gap count map
        HashMap<Integer,Integer>gapCountMap = new HashMap<>();

        int n = wall.size();
        int maxGaps = 0;
        
        for(List<Integer> row: wall){
           int pos = 0;
           for(int i = 0; i < row.size() -1; i++){
              pos += row.get(i);
              gapCountMap.put(pos, gapCountMap.getOrDefault(pos, 0) +1 );
              maxGaps = Math.max(maxGaps, gapCountMap.get(pos));
           }
        }
        return n - maxGaps;
        
    }

}