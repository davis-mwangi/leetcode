package dynamic_programming_2.dp_on_strings;

/*
Leetcode: https://leetcode.com/problems/edit-distance/
Coding Ninjas :  https://www.codingninjas.com/studio/problems/edit-distance_630420

Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Algorithm:

1. Express the recusrion in terms of i, j => word1, word 2 respectively
2.Explore all paths
     1. chars match,  no operation  is require, so we move forward i.e 0 +  i -1, j -2
     2. chars dont match we do three opertaions
         - delete, i.e we reduce chars in word 1 and word2 remains the same i.e i -1, j
         - insert, i,e add an extra char on word 1, so i remains the same and since j  has matched, we reduce j i.e i, j - 1
         - replace, if we replace char, then we have  matched both so move  to the next chars i.e i -1, j -1
       -  At the end we take the minimun  of the the three if dont match
3. Write down the base case
   when i < 0  and j > 0, then means to match the two we do insertion so  will be j + 1 operations
   when j < 0 and i > 0, then to match the string we have to do deletions in i, so it will i + 1 deletions

*/
import java.util.*;

public class EditDistance {
  
    //Recursive Solution 
    //TC:  Exponential
    //SC:  O(m + n)
public class Solution1 {

    public static int editDistance(String str1, String str2) {
        //Your code goes here
        int n = str1.length();
        int m = str2.length();

        return dfs(n -1, m- 1, str1, str2);
    
    }
    private static int dfs(int i , int j, String str1, String str2){
        //Base case
        if(j < 0){
            return i + 1; //no. of deletions on str1
        }
        if(i < 0){
            return j + 1; //no. of  insertions into str1
        }

        //case where chars match, then no operations are performed
        if(str1.charAt(i)== str2.charAt(j)){
            return 0 + dfs(i -1, j -1, str1, str2);
       
        }else{//dont mach we perform three operations i.e delete, replace or insert
           int delete = 1 + dfs(i -1, j, str1, str2);
           int replace = 1 + dfs(i -1, j -1, str1, str2);
           int insert = 1 +dfs(i, j-1, str1, str2);

           return Math.min( delete , Math.min(replace, insert) );

        }

    }

    //Memoized Solution
    //TC: O(m * n)
    //SC: O(m * n) + O(m+n)
    public class Solution2 {

        public static int editDistance(String str1, String str2) {
            //Your code goes here
            int n = str1.length();
            int m = str2.length();
    
            int [][] dp = new int[n][m];
    
            fill(dp, -1);
    
            return dfs(n -1, m- 1, str1, str2, dp);
        
        }
        private static int dfs(int i , int j, String str1, String str2, int[][] dp){
            //Base case
            if(j < 0){
                return i + 1; //no. of deletions on str1
            }
            if(i < 0){
                return j + 1; //no. of  insertions into str1
            }
            if(dp[i][j] != -1){
                return dp[i][j];
            }
    
            //case where chars match, then no operations are performed
            if(str1.charAt(i)== str2.charAt(j)){
                return dp[i][j] =  0 + dfs(i -1, j -1, str1, str2, dp);
           
            }else{//dont mach we perform three operations i.e delete, replace or insert
               int delete = 1 + dfs(i -1, j, str1, str2, dp);
               int replace = 1 + dfs(i -1, j -1, str1, str2, dp);
               int insert = 1 +dfs(i, j-1, str1, str2, dp);
    
               return dp[i][j] = Math.min( delete , Math.min(replace, insert) );
    
            }
    
        }
        private static void fill(int[][] arr, int val){
            for(int[] a :  arr){
                Arrays.fill(a, val);
            }
        }
    }
}

// Convert into 1-indexed array to help us to tabulation

public class Solution3 {
        public static int editDistance(String str1, String str2) {
            //Your code goes here
            int n = str1.length();
            int m = str2.length();
    
            int [][] dp = new int[n + 1][m + 1];
    
            fill(dp, -1);
    
            return dfs(n, m, str1, str2, dp);
        
        }
        private static int dfs(int i , int j, String str1, String str2, int[][] dp){
            //Base case
            if(j == 0){
                return i ; //no. of deletions on str1
            }
            if(i == 0){
                return j; //no. of  insertions into str1
            }
            if(dp[i][j] != -1){
                return dp[i][j];
            }
    
            //case where chars match, then no operations are performed
            if(str1.charAt(i - 1)== str2.charAt(j -1)){
                return dp[i][j] =  0 + dfs(i -1, j -1, str1, str2, dp);
           
            }else{//dont mach we perform three operations i.e delete, replace or insert
               int delete = 1 + dfs(i -1, j, str1, str2, dp);
               int replace = 1 + dfs(i -1, j -1, str1, str2, dp);
               int insert = 1 +dfs(i, j-1, str1, str2, dp);
    
               return dp[i][j] = Math.min( delete , Math.min(replace, insert) );
    
            }
    
        }
        private static void fill(int[][] arr, int val){
            for(int[] a :  arr){
                Arrays.fill(a, val);
            }
        }
    }

    //Tabulation method
    //TC: O(n * m)
    //SC : O(m * n)
    public class Solution4 {
        /*
                d c
              0 0 0
            a 0
            b 0
            c 0
            
        
        */
            public static int editDistance(String str1, String str2) {
                //Your code goes here
                int n = str1.length();
                int m = str2.length();
        
                int [][] dp = new int[n + 1][m + 1];
        
                dp[0][0] = 0;
                for(int i = 1; i <= n; i++){
                    dp[i][0] = i;
                }
                for (int j = 1; j <= m; j++){
                    dp[0][j] = j;
                }
                
                for(int i =1; i <= n; i++){
                    for(int j = 1; j <= m ; j++){
                         //case where chars match, then no operations are performed
                        if(str1.charAt(i - 1)== str2.charAt(j -1)){
                            dp[i][j] =  0 + dp[i -1][j -1];
                    
                        }else{//dont mach we perform three operations i.e delete, replace or insert
                        int delete = 1 + dp[i -1][j];
                        int replace = 1 + dp[i -1][j -1];
                        int insert = 1 +dp[i][j-1];
        
                          dp[i][j] = Math.min( delete , Math.min(replace, insert) );
                        }
                    }
                }
                return dp[n][m];
            
            }
           
        }
}
