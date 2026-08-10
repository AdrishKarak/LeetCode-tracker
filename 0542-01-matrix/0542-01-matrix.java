class Solution {

    public int[][] updateMatrix(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        // Four possible movement directions
        int[][] directions = {
            {0, 1},   // right
            {0, -1},  // left
            {1, 0},   // down
            {-1, 0}   // up
        };

        Queue<int[]> queue = new ArrayDeque<>();

        // Put every 0 into the queue as a BFS starting point
        // and mark every 1 as unvisited using MAX_VALUE
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (mat[r][c] == 0) {
                    queue.add(new int[]{r, c});
                }
                else {
                    mat[r][c] = Integer.MAX_VALUE;
                }
            }
        }

        // Multi-source BFS
        while (!queue.isEmpty()) {

            int[] cell = queue.poll();

            int row = cell[0];
            int col = cell[1];

            // Explore all four neighbors
            for (int[] direction : directions) {

                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // Check whether the neighbor is inside the matrix
                if (newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols) {

                    // Found a shorter distance to this cell
                    if (mat[newRow][newCol] > mat[row][col] + 1) {

                        // Distance = current distance + 1
                        mat[newRow][newCol] = mat[row][col] + 1;

                        // Process this cell later
                        queue.add(new int[]{newRow, newCol});
                    }
                }
            }
        }

        return mat;
    }
}
