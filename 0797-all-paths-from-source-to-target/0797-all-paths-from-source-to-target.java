class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(0, graph , ans , path);
        return ans;
    }

    private void dfs(int node , int[][] graph , List<List<Integer>> ans , List<Integer> path){
        path.add(node);
        if(node == graph.length-1){
            ans.add(new ArrayList<>(path));
        } else {
            for(int neighbor : graph[node]){
            dfs(neighbor, graph , ans, path);
            }
        }

        path.remove(path.size()-1);
    }

}