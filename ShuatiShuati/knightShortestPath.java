public class knightShortestPath {
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        if (source == null || destination == null) {
            return -1;
        }
        if (source == destination) {
            return 0;
        }
        Queue<Point> queue = new LinkedList<Point>();
        int shortPath = 0;
        queue.offer(source);
        
        while (!queue.isEmpty()) {
            
            int[] directionX = {1, 1, -1, -1, 2, 2, -2, -2};  //coordinates transform
            int[] directionY = {2, -2, 2, -2, 1, -1, 1, -1};
            
            int size = queue.size();    //find shortest path == level order traversal
            shortPath++;
            for (int i = 0; i < size; i++) {
                Point cur = queue.poll();
                for (int j = 0; j < 8; j++) {
                    int x = cur.x + directionX[j];
                    int y = cur.y + directionY[j];
                    if (x == destination.x && y == destination.y) {
                        return shortPath;
                    }
                    if (isValid(grid, x, y)) {
                        queue.offer(new Point(x, y));
                        grid[x][y] = true;   //remember not add same node into the queue
                    }
                }
            }
        }
        return -1;
    }
    
    private boolean isValid(boolean[][] grid, int x, int y) {
        if (x >= 0 && x < grid.length && y >= 0 
            && y < grid[0].length && grid[x][y] == false) {
            return true;
        }
        return false;
    }
}