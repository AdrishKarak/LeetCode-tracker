class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        dfs(0,rooms , visited);

        for(boolean isVisited: visited){
            if(!isVisited){
                return false;
            }
        }
        return true;
    }
    public void dfs(int currentroom , List<List<Integer>> rooms , boolean[] visited){
        visited[currentroom] = true;

        for(int key: rooms.get(currentroom)){
            if(!visited[key]){
                dfs(key, rooms, visited);
            }
        }
    }
}