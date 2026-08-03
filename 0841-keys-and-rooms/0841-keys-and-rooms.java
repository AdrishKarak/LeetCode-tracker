class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        // Start our depth-first exploration from Room 0
        dfs(0, rooms, visited);

        // If any room remains unvisited, return false
        for (boolean isVisited : visited) {
            if (!isVisited) {
                return false;
            }
        }

        return true;
    }

    private void dfs(int currentRoom, List<List<Integer>> rooms, boolean[] visited) {
        // Mark the current room as visited
        visited[currentRoom] = true;

        // Grab all keys available in the current room
        for (int key : rooms.get(currentRoom)) {
            // If we haven't visited the room that this key unlocks, go visit it
            if (!visited[key]) {
                dfs(key, rooms, visited);
            }
        }
    }
}
