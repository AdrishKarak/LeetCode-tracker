class Solution {

    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;

        // Put all initially rotten oranges into the queue
        // and count the total fresh oranges
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (grid[r][c] == 2) {
                    q.offer(new int[]{r, c});
                    visited[r][c] = true;
                }
                else if (grid[r][c] == 1) {
                    fresh++;
                }
            }
        }

        // No fresh oranges means nothing needs to rot
        if (fresh == 0) {
            return 0;
        }

        int minutes = -1;

        // Four possible directions
        int[][] directions = {
            {-1, 0}, // up
            {1, 0},  // down
            {0, -1}, // left
            {0, 1}   // right
        };

        // Each BFS level represents one minute
        while (!q.isEmpty()) {

            int size = q.size();
            minutes++;

            // Process all oranges that are rotten at this minute
            for (int i = 0; i < size; i++) {

                int[] current = q.poll();

                for (int[] dir : directions) {

                    int nr = current[0] + dir[0];
                    int nc = current[1] + dir[1];

                    // Ignore invalid cells, empty cells and visited cells
                    if (nr < 0 || nr >= rows ||
                        nc < 0 || nc >= cols ||
                        grid[nr][nc] == 0 ||
                        visited[nr][nc]) {
                        continue;
                    }

                    // Fresh orange becomes rotten
                    visited[nr][nc] = true;
                    fresh--;

                    // This orange spreads rot in the next minute
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        // If all fresh oranges became rotten, return time taken
        return fresh == 0 ? minutes : -1;
    }
}
