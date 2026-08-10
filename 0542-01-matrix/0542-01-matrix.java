class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows=mat.length;
        int cols=mat[0].length;
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        Queue<int[]> queue = new ArrayDeque<>();

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(mat[i][j]==0){
                    queue.add(new int[]{i,j});
                } else {
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for(int[] direction: directions){
                int newrow = row+direction[0];
                int newcol = col + direction[1];

                if(newrow >=0 && newrow <rows && newcol >=0 && newcol <cols && mat[newrow][newcol]>mat[row][col]+1){
                    mat[newrow][newcol] = mat[row][col] +1;
                    queue.add(new int[]{newrow, newcol});
                }
            }
        }
        return mat;
    }
}