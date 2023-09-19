package backtracking;
import java.util.*;

/*
 * https://leetcode.com/problems/n-queens/description/
 * 
 * Approach:
 * We take the approach of back tracking where at a given row we can chose to 
 * place a queen at a given row  between 0 to n
 * We aslo consider negative diagonal which we can get applying the formulae (r - c)
 * we also consider +ve diagobal where we can get by (row + col)
 * 
 * We maintain a booelean board and perfom backtracking, 
 * we determine whether its safe to consider the queeen  the position row, col
 * since ists backtracking we unque the changes,.
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>>ans = new ArrayList<>();
        boolean [][] board = new boolean[n][n];
        
        queens(board, 0, ans);

        return ans;
    }
    private void queens(boolean[][] board, int row, List<List<String>>res){
        //base case
        if(row == board.length){
            List<String>ans = new ArrayList<>();
            createAnswer(board, ans);
            res.add(ans);
            return;
        }
        for(int col = 0; col < board.length; col++ ){
            if(isSafe(board, row, col)){
                 board[row][col]= true;
                 queens(board, row + 1, res);
                 board[row][col]= false;
            }
        }
    }
    private void createAnswer(boolean[][] board, List<String>ans){
        for(int i = 0; i< board.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j]){
                   sb.append(("Q"));
                }else{
                    sb.append(".");
                }
                
            }
            ans.add(sb.toString());
        }
    }
    private boolean isSafe(boolean[][]board, int row, int col){
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }
        int maxRight = Math.min(row, board.length - 1 - col);
        for (int i = 1; i <= maxRight; i++) {
            if (board[row - i][col + i]) return false;
        }
        return true;
    } 
}
