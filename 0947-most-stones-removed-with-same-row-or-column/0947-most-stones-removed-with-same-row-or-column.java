class Solution {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        int[] parent = new int[n];
        int[] size= new int[n];

        for(int i=0; i<n; i++){
            parent[i]=i;
            size[i]=1;
        }
        // Connect stones sharing row or column
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    unionBySize(i, j, parent, size);
                }
            }
        }

        int removableStones = 0;
        for(int i = 0; i < n; i++) {
            // Only count from the root of each component
            if(parent[i] == i) {
                removableStones += (size[i] - 1);
            }
        }
        return removableStones;

    }
    private int find(int[] parent , int node){
        if(parent[node] == node) return node;
        return parent[node] = find(parent, parent[node]);
    }

    private void unionBySize(int u, int v, int[] parent, int[] size){
        int pu = find(parent, u);
        int pv = find(parent, v);
        if(pu == pv) return;

        if(size[pu] < size[pv]){
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}