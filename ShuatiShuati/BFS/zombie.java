public class zombie {
    /**
     * @param grid  a 2D integer grid
     * @return an integer
     */
     
    private class Coordinates {
        int x;
        int y;
        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    } 
    
    private int days = 0;
    private int[] directionX = {0, 1, -1, 0};
    private int[] directionY = {1, 0, 0, -1};
    
    public int zombie(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int people = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Coordinates> queue = new LinkedList<Coordinates>();
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    people += 1;
                } else if (grid[i][j] == 1) {
                    queue.offer(new Coordinates(i, j));
                }
            }
        }
        
        if (people == 0) {
            return days;
        }
        
        while (!queue.isEmpty()) {
            days += 1;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Coordinates cur = queue.poll();
                for (int j = 0; j < 4; j++) {
                    Coordinates adj = new Coordinates(cur.x + directionX[j], cur.y + directionY[j]);
                    if (inBound(grid, adj) && grid[adj.x][adj.y] == 0) {
                        people -= 1;
                        if (people == 0) {
                            return days;
                        }
                        grid[adj.x][adj.y] = 1;
                        queue.offer(adj);
                    }
                }
            }
        }
        
        return -1;
    }
    
    private boolean inBound(int[][] grid, Coordinates adj) {
        if (adj.x <0 || adj.x > grid.length - 1) {
            return false;
        } 
        if (adj.y < 0 || adj.y > grid[0].length - 1) {
            return false;
        }
        return true;
    }
}