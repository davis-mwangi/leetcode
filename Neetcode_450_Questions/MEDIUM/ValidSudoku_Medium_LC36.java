package Neetcode_450_Questions.MEDIUM;

/*
https://leetcode.com/problems/valid-sudoku/
*/
import java.util.*;

public class ValidSudoku_Medium_LC36 {
    class Solution {
        /*
         * We maintain 3 hashmaps to rows, cols, squares
         * Since the square is a 9 X 9 so each small square is r / 3 , c / 3 , will keep
         * this pair as our key
         * 
         */
        public boolean isValidSudoku(char[][] board) {
            Map<Integer, Set<Character>> rowsValueMap = new HashMap<>();
            Map<Integer, Set<Character>> colsValueMap = new HashMap<>();
            Map<String, Set<Character>> smallSqValueMap = new HashMap<>();

            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {

                    if (board[r][c] == '.')
                        continue;

                    String sqrKey = (r / 3) + "." + (c / 3);

                    if (rowsValueMap.getOrDefault(r, new HashSet<>()).contains(board[r][c]) ||
                            colsValueMap.getOrDefault(r, new HashSet<>()).contains(board[r][c]) ||
                            smallSqValueMap.getOrDefault(sqrKey, new HashSet<>()).contains(board[r][c])) {
                        return false;
                    }
                    // Updated maps
                    if (!rowsValueMap.containsKey(r)) {
                        rowsValueMap.put(r, new HashSet<>());
                    }

                    if (!colsValueMap.containsKey(c)) {
                        colsValueMap.put(c, new HashSet<>());
                    }

                    if (!smallSqValueMap.containsKey(sqrKey)) {
                        smallSqValueMap.put(sqrKey, new HashSet<>());
                    }
                    rowsValueMap.get(r).add(board[r][c]);
                    colsValueMap.get(c).add(board[r][c]);

                    smallSqValueMap.get(sqrKey).add(board[r][c]);

                }
            }
            return true;

        }
    }
}
