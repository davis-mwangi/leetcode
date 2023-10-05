package dynamic_programming_1;

/*
 *    
     //Follow up Question: Instead  of from jumps  1 or 2 steps, 
     //The frog jumps K steps.

     https://www.youtube.com/watch?v=EgG3jsGoPvQ&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=4
 */
public class FrogJumpWithKSteps {

    public static int frogJump(int n, int heights[], int k) {
        return dfs(n -1, heights, k);
    }

    private static int dfs (int i,  int [] heights, int k){
        //Base Case
        if(i == 0){
            return 0;
        }

        int minSteps = Integer.MAX_VALUE;
        for(int j = 1; i <= k; i++){
            int jumps = Integer.MAX_VALUE;
            if(i - j > 0){
               jumps = dfs(i - j, heights, k) + Math.abs( heights[i]- heights[i - j]);
            }
            minSteps = Math.min(minSteps, jumps);
           
        }
        return minSteps;
     }

}
