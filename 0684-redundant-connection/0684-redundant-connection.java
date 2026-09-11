class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] ans = new int[]{-1, -1};
        int[] parent = new int[n+1];

        for(int i=0; i<=n; i++){
            parent[i]=i;
        } 
        for(int[] edge : edges){
            int p1=findparent(edge[0], parent);
            int p2=findparent(edge[1], parent);

            if(p1 == p2)
              ans = edge;

              parent[p2]=p1;
        }
        return ans;
    }

    private int findparent(int node, int[] parent){
        if(node == parent[node])
        return node;


        return findparent(parent[node], parent);
    }
}