class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int [] visited = new int[n];
        return solve(graph,source,destination,visited);
    }

    public boolean solve(List<List<Integer>> graph, int start , int end , int[] visited){
        if(start == end) return true;

        visited[start] = 1;

        for(int neighbour: graph.get(start)){
            if(visited[neighbour]==0){
                if(solve(graph , neighbour, end , visited)) return true;
            }
        }
        return false;
    }
}