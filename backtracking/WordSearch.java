package backtracking;
/*
https://leetcode.com/problems/word-search/


We do a  recusrive backtrack

Time Complexity: O(m * n  *  4 ^ len(word))
Space Complexity: O(n)
*/
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        
        int rows =  board.length;
        int cols = board[0].length;
        
         boolean [][] visited = new boolean[rows][cols]; 
        
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                
                //Call dfs method
                if( dfs(board, visited, r, c, word, 0) ){
                    return true;
                }
                
            }
        }
        return false;
    }
    
    public  boolean dfs(char[][] board, boolean [][] visited, int row, int col, String word, int wordIndex ){
        
        if(wordIndex ==  word.length()){
            return true;
        }
        
        if(row < 0 || col < 0 ||  row >= board.length || col >= board[0].length 
           || visited[row][col] || word.charAt(wordIndex) != board[row][col] ){
            return false;
        }
        
        visited[row][col] = true;
        
       boolean result = (dfs(board,visited, row - 1 , col, word, wordIndex + 1)  ||
                        dfs(board, visited, row  + 1 , col, word, wordIndex + 1)  ||
                        dfs(board, visited, row , col -1 , word, wordIndex + 1)  ||
                        dfs(board, visited, row , col + 1, word, wordIndex + 1)  );
       
        visited[row][col] = false;
        
        return result;
    }
}
