class Solution {
    // Function to perform depth-first search to find a path from source to destination
    public boolean solve(List<List<Integer>> graph, int source, int destination, int[] visited) {
        // If source and destination are the same, a path is found
        if (source == destination)
            return true;
        
        // Mark the current node as visited
        visited[source] = 1;
        
        // Traverse through all adjacent vertices of the current vertex
        for (int neighbor : graph.get(source)) {
            // If the neighbor is not visited, recursively search for a path
            if (visited[neighbor] == 0) {
                if (solve(graph, neighbor, destination, visited))
                    return true; // If a path is found, return true
            }
        }
        return false; // No path found from source to destination
    }
    
    // Function to determine if a valid path exists from source to destination
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Create an adjacency list representation of the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        // Initialize an array to keep track of visited vertices
        int[] visited = new int[n];
        
        // Call the helper function to find a path from source to destination
        return solve(graph, source, destination, visited);
    }
}
