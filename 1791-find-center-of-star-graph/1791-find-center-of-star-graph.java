class Solution {
    public int findCenter(int[][] edges) {
         // If first node of edge 0 appears in edge 1,
        // then it is the center
        if (edges[0][0] == edges[1][0] ||
            edges[0][0] == edges[1][1]) {

            return edges[0][0];
        }

        // Otherwise second node of edge 0 is the center
        return edges[0][1];
    }
}