public class numOfIslands {
    private class Coordinates {
        int x;
        int y;
        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } 
    
    public int numIslands(boolean[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int island = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == true) {
                    BFS(grid, i, j);
                    island += 1;
                }
            }
        }
        return island;
    }
    /* It is also using BFS in graph, we change every node's value to avoid adding same node
     * into a queue.
    */
    private void BFS(boolean[][] grid, int x, int y) {
        int[] directionX = {0, 1, -1, 0};
        int[] directionY = {1, 0, 0, -1};
        
        Queue<Coordinates> queue = new LinkedList<Coordinates>();
        queue.offer(new Coordinates(x, y));
        grid[x][y] = false;
        while(!queue.isEmpty()) {
            Coordinates cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                    Coordinates adj = new Coordinates(cur.x + directionX[i], cur.y + directionY[i]);
                    if (!inBound(grid, adj)) {
                        continue;
                    }
                    if (grid[adj.x][adj.y]) {
                        grid[adj.x][adj.y] = false;
                        queue.offer(adj);
                    }
            }
        }
    }
    
    private boolean inBound(boolean[][] grid, Coordinates adj) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (adj.x >= 0 && adj.x < rows && adj.y >= 0 && adj.y < cols) {
            return true;
        }
        return false;
    }
}