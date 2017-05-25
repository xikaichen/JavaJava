public class Solution {
    public int[] X_Coordinate = {1, -1, 0, 0};
    public int[] Y_Coordinate = {0, 0, 1, -1};
    public class Coordinates {
        int x;
        int y;
        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int island = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    island++;
                    BFS(grid, i, j);
                }
            }
        }
        return island;
    }
    
    private void BFS(char[][] grid, int x, int y) {
        Queue<Coordinates> queue = new LinkedList<Coordinates>();
        queue.offer(new Coordinates(x, y));
        grid[x][y] = '0';
        while (!queue.isEmpty()) {
            Coordinates cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = cur.x + X_Coordinate[i];
                int newY = cur.y + Y_Coordinate[i];
                if (isBound(grid, newX, newY) && grid[newX][newY] == '1') {
                    queue.offer(new Coordinates(newX, newY));
                    grid[newX][newY] = '0';
                }
                
            }
        }
    }
    
    private boolean isBound(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return false;
        }
        return true;
    }
}