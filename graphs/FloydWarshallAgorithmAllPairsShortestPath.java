package graphs;
/*
Geek for Geeks :  https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1
Techdose(Best Explanation): https://www.youtube.com/watch?v=nV_wOZnhbog


*/

public class FloydWarshallAgorithmAllPairsShortestPath {
    class Solution {
        public void shortest_distance(int[][] matrix) {
            // Code here
            int v = matrix.length;
            int [][] distance = new int[v][v];
            
            //Assign all values of graph to all graph pairs
            for(int i = 0;  i<  v; i++){
                for(int j = 0; j < v; j++){
                    distance[i][j] = matrix[i][j];
                }
            }

            //Find all pairs shortest path by trying all possible paths
            for(int k = 0; k <v; k++){ //Try all intermediate nodes
                for(int i = 0; i < v; i++){ // Try for all possible starting position
                    for(int j =0; j < v; j++){ //Try for all possible ending position
                      
                        if(distance[i][k] == -1 || distance[k][j] == -1){ //SKIP if k is unreachable from i or j is unreachable from k 
                            continue;
                        }else if( distance[i][k] + distance[k][j] <  distance[k][j] ){
                           distance[i][j] =  distance[i][k] + distance[k][j];
                        }

                    }
                }
            }

            //Check for negative edge weight cycle
            for(int i = 0; i < v; i++){
                if(distance[i][i] < 0){
                    return;
                }
            }
        }
    }
}
