package graphs;
/*


*/
public class UnionFind {
    int [] parents;
    int [] rank;
    int numOfComponents = 0;

    public  UnionFind(int n){
        this.parents = new int[n];
        this.rank = new int[n];
        this.numOfComponents = n;

        //Initialize parents self nodes
        for(int i = 0; i < parents.length; i++) {
            parents[i] = i;
            rank[i] = 1;
        }
    }
    public int findComponents(int curr){
        int parent = find(curr);
        return  rank[parent];
    }
    public  int find(int curr){
       if(curr == parents[curr]) {
           return curr;
       }
       //Path Compression
        return parents[curr] = find(parents[curr]);
    }

    public  int findIterative(int curr){
        int root = curr;
        while (root != parents[root]){
            root = parents[root];
        }

        //Path Compression
        while(curr != root){
            int preParent = parents[curr];
            parents[curr] = root;
            curr = preParent;
        }
        return root;
    }
    public void union(int node1, int node2){
        int node1Parent =  find(node1);
        int node2Parent =  find(node2);

        //Belong to same parent
        if(node1Parent == node2Parent){
            return;
        }

        //Find parent node with higher rank
        if(rank[node1Parent] > rank[node2Parent]){
            parents[node2Parent] = node1Parent;
            rank[node1Parent] += rank[node2Parent];
        }else{
            parents[node1Parent] =  node2Parent;
            rank[node2Parent] =  rank[node1Parent];
        }
        numOfComponents --;

}
