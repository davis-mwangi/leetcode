package Neetcode_450_Questions.MEDIUM;
/*
Question : https://leetcode.ca/all/1762.html
Guide : 

*/
import java.util.*;
public class BuildingsWithAnOceanView_LC1762 {
     //SC : O (2 * N) ~ O(N)
    //TC : O (N)
    public static int[] findBuildings(int[] heights) {
        int maxHeight = -1;
        int n = heights.length;
        List<Integer>idxs  = new ArrayList<>();

        for(int i = n -1; i >= 0; i--){
            if( heights[i] > maxHeight ){
                idxs.add(i);
                maxHeight = heights[i];
            }
        } 
        //Revese
        int [] ans = new int[idxs.size()];
        int l = 0;
        int r = idxs.size() - 1;
        while(l <= r){
            ans[l] = idxs.get(r);
            ans[r] = idxs.get(l);
            l++;
            r--;
        }
        return ans;
    }
}
