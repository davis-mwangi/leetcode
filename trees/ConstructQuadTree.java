package trees;

/**
 * https://leetcode.com/problems/construct-quad-tree/
 */
public class ConstructQuadTree {
    
    public Node construct(int[][] grid) {
        return dfs(grid, grid.length, 0, 0);
        
    }
    private Node dfs(int[][] grid, int n, int row, int col){
        boolean allSame = true;
        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if(grid[row][col] != grid[row + i][col + j]){
                    allSame = false;
                }
            }
        }
        if(allSame){
            return  new Node( grid[row][col]== 1 ? true: false , true);
        }
        n = n / 2;
        Node topLeft = dfs(grid, n, row, col);
        Node topRight = dfs(grid, n, row, col + n);
        Node bottomLeft = dfs(grid, n, row +n, col);
        Node bottomRight = dfs(grid, n, row +  n, col + n);
        return new Node( false, false, topLeft, topRight, bottomLeft, bottomRight );
    }

    // Definition for a QuadTree node.
    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

}
