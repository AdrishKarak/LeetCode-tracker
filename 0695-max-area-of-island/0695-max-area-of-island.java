class Solution {

    public int maxAreaOfIsland(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        // Track visited cells
        boolean[][] visited = new boolean[rows][cols];

        int maxIsland = 0;

        // Visit every cell in the grid
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                // Start DFS from an unvisited land cell
                if (grid[r][c] == 1 && !visited[r][c]) {

                    int area = dfs(grid, visited, r, c);

                    // Update maximum island size
                    maxIsland = Math.max(maxIsland, area);
                }
            }
        }

        return maxIsland;
    }

    private int dfs(int[][] grid, boolean[][] visited, int r, int c) {

        int rows = grid.length;
        int cols = grid[0].length;

        // Out of bounds
        if (r < 0 || r >= rows || c < 0 || c >= cols) {
            return 0;
        }

        // Water cell or already visited
        if (grid[r][c] == 0 || visited[r][c]) {
            return 0;
        }

        // Mark current land cell as visited
        visited[r][c] = true;

        // Count current cell + all connected land cells
        return 1
                + dfs(grid, visited, r + 1, c) // down
                + dfs(grid, visited, r - 1, c) // up
                + dfs(grid, visited, r, c + 1) // right
                + dfs(grid, visited, r, c - 1); // left
    }
}
