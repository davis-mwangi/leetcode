package binary_search;
/*
https://leetcode.com/problems/search-a-2d-matrix/description/
*/
public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int top = 0;
        int bottom = rows - 1;

        while(top <=  bottom){
            int row = top + ((bottom - top) / 2);

            //Chek last item of row
           
            if( matrix[row][cols -1] > target){
                bottom = row - 1;
            }else if( matrix[row][cols -1] < target ){
                top = row + 1;
            }else{
                break;
            }
        }
       // target range not within matrix
        if(top > bottom){
            return false;
        }

        int row = top + ((bottom - top) / 2 );
        int left = 0;
        int right = cols- 1;

        while(left <= right){
            int mid = left + ((right - left) / 2);
            if( target > matrix[row][mid] ){
                left = mid + 1;
            }else if(target < matrix[row][mid]){
                right = mid - 1;
            }else{
                return true;
            }
        }
        return false;

    }
}
