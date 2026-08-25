class Solution {
    public int minReorder(int n, int[][] connections) {
         // Adjacency list:
        // [neighbor, cost]
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build graph
        for (int[] connection : connections) {

            int from = connection[0];
            int to = connection[1];

            // Original direction
            graph[from].add(new int[]{to, 1});

            // Reverse direction
            graph[to].add(new int[]{from, 0});
        }

        // Start DFS from city 0
        return dfs(0, -1, graph);
    }

    private int dfs(int city,
                    int parent,
                    List<int[]>[] graph) {

        int changes = 0;

        for (int[] edge : graph[city]) {

            int nextCity = edge[0];
            int cost = edge[1];

            // Don't go back to parent
            if (nextCity == parent) {
                continue;
            }

            // Add reversal cost
            changes += cost;

            // Explore subtree
            changes += dfs(nextCity, city, graph);
        }

        return changes;
    }


}