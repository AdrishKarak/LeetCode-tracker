class Solution {
    public int makeConnected(int n, int[][] connections) {
        int[] parent = new int[n];
        int extraedges = 0;

        for(int i=0; i<n; i++){
            parent[i]=i;
        }
        for(int[] edge : connections){
            int p1 = findparent(edge[0], parent);
            int p2 = findparent(edge[1], parent);

            if(p1 == p2){
                extraedges++;
            } else{
                n--;
            }
            parent[p2]=p1;
        }
        return extraedges >= n-1 ? n-1 : -1;
    }
    private int findparent(int node , int[] parent){
        if(parent[node] == node){
            return node;
        }

        return parent[node] = findparent(parent[node], parent);
    }
}