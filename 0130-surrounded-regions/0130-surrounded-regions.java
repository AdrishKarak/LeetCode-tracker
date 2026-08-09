class Solution {

    public void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        // Marks all border-connected O's
        boolean[][] visited = new boolean[rows][cols];

        // DFS from left and right borders
        for (int r = 0; r < rows; r++) {

            if (board[r][0] == 'O' && !visited[r][0]) {
                dfs(r, 0, board, visited);
            }

            if (board[r][cols - 1] == 'O' && !visited[r][cols - 1]) {
                dfs(r, cols - 1, board, visited);
            }
        }

        // DFS from top and bottom borders
        for (int c = 0; c < cols; c++) {

            if (board[0][c] == 'O' && !visited[0][c]) {
                dfs(0, c, board, visited);
            }

            if (board[rows - 1][c] == 'O' && !visited[rows - 1][c]) {
                dfs(rows - 1, c, board, visited);
            }
        }

        // Any unvisited O is surrounded by X's
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (board[r][c] == 'O' && !visited[r][c]) {
                    board[r][c] = 'X';
                }
            }
        }
    }

    private void dfs(int r, int c, char[][] board, boolean[][] visited) {

        int rows = board.length;
        int cols = board[0].length;

        // Invalid cell
        if (r < 0 || c < 0 || r >= rows || c >= cols) {
            return;
        }

        // Already processed or not an O
        if (visited[r][c] || board[r][c] == 'X') {
            return;
        }

        // Mark border-connected O
        visited[r][c] = true;

        // Explore all 4 directions
        dfs(r + 1, c, board, visited); // down
        dfs(r - 1, c, board, visited); // up
        dfs(r, c + 1, board, visited); // right
        dfs(r, c - 1, board, visited); // left
    }
}
