package dynamic_programming_2.dp_on_strings;
/*
Conding Ninjas: https://www.codingninjas.com/studio/problems/wildcard-pattern-matching_701650?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos
Leetcode:  https://leetcode.com/problems/wildcard-matching/

Algorithm:
'?' matches any single character
'*' matches any sequence of characters

1) Express the func in terms of i , j
2) Explore the possible paths
    - chars match  
        case where  char matches or '?' then we just move forward
         case where char is a "*", since * means anything from 0 to  n, then we can decide just ignore and move on
          or we conside it as part of the sequence to match
    - dont match

*/
import java.util.*;

public class WildcardPatternMatching {
    
    //Memoized Solution (top-down)
    public class Solution1 {
        public static boolean wildcardMatching(String pattern, String text) {
            // Write your code here.
            int n = pattern.length();
            int m = text.length();
    
            int [][]dp = new int[n][m];
    
            fill(dp, -1);
    
            return dfs(n -1, m -1, pattern, text, dp);
        }
        private static boolean dfs(int i, int j, String pattern, String text, int[][]dp){
            //Base Case
            //If both i and j gets exhausted, then we can say they match
            if(i < 0 && j < 0){
                return true;
            }
            //If i gets exhausted and j has some chars, then they can never match
            if(i < 0 && j >= 0){
                return false;
            }
            
            //If j gets exhausted and i has some chars, then the remaining chars in i must all be '*'
            if(j< 0 && i>= 0){
                for(int ii = 0; ii <= i; ii++){
                    if(pattern.charAt(ii) != '*'){
                       return false;
                    }
                     
                }
                return true;
            }
    
            if(dp[i][j] != -1){
                return dp[i][j] == 1 ? true: false;
            }
    
            //Explore paths
            if(pattern.charAt(i) == text.charAt(j) || pattern.charAt(i) == '?'){
                boolean match  = dfs(i -1, j -1, pattern, text, dp);
                dp[i][j]= match ? 1: 0;
                return match;
            }
    
            if(pattern.charAt(i) == '*'){
                 boolean  ingoreStar = dfs(i-1, j, pattern, text, dp);
                 boolean  considerStar = dfs(i, j -1, pattern, text, dp);
    
                 boolean starCase  = ingoreStar || considerStar;
                 dp[i][j] = starCase ? 1 : 0;
                 return starCase;
            }
    
            dp[i][j] = 0;
            return false;
    
        }
        private static void fill(int[][] arr, int val){
            for(int[]a: arr){
                Arrays.fill(a, val);
            }
        }
    }


    //We convert  memoized solution to 1-indexed arr
public class Solution2 {
	
	public static boolean wildcardMatching(String pattern, String text) {
		// Write your code here.
		int n = pattern.length();
		int m = text.length();

		boolean [][]dp = new boolean[n + 1][m + 1];

        //Base case
		dp[0][0] = true;

		for(int j = 1; j <= m; j++){
			dp[0][j]= false;
		}

		for(int i =1; i<= n; i++){
			 boolean flag = true;
			for(int ii = 1; ii <= i; ii++){
				if(pattern.charAt(ii -1 ) != '*'){
                   flag =  false;
				   break;
				}
				 
			}
			dp[i][0] = flag;
		}
		
		//Paths in i , j
		for(int i = 1; i <= n; i++){
			for(int j = 1; j<=m; j++){
				  
				if(pattern.charAt(i -1 ) == text.charAt(j -1) || pattern.charAt(i -1) == '?'){
					dp[i][j]=  dp[i -1][j -1];
					
				}else if(pattern.charAt(i -1) == '*'){
				    boolean  ingoreStar = dp[i-1][j];
					boolean  considerStar = dp[i][j -1];

					dp[i][j] = ingoreStar || considerStar;
				
				}else{
					dp[i][j] = false;
				}
			}
		}

		return dp[n][m];
	}
}


    
}
