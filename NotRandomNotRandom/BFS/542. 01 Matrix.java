public class Solution {
    int[] X_Coordinate = {1, -1, 0, 0};
    int[] Y_Coordinate = {0, 0, 1, -1};
    public class Coordinates{
        int x;
        int y;
        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        
        Queue<Coordinates> queue = new LinkedList<Coordinates>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new Coordinates(i, j));
                    visited[i][j] = true;
                }
            }
        }
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinates cur = queue.poll();
                res[cur.x][cur.y] = distance;
                for (int j = 0; j < 4; j++) {
                    int newX = cur.x + X_Coordinate[j], newY = cur.y + Y_Coordinate[j];
                    if (isBound(matrix, newX, newY) 
                        && matrix[newX][newY] == 1 
                        && !visited[newX][newY]) {
                        queue.offer(new Coordinates(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }
            distance++;
        }
        return res;
    }
    
    private boolean isBound(int[][] matrix, int x, int y) {
        if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
            return false;
        }
        return true;
    }
}