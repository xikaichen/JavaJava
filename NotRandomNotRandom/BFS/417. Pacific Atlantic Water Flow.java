// 意思是算出 从陆地上能流到太平洋和大西洋的水源坐标
// 从洋出发 两个洋交汇的地方就是 都可以到达的点
public class Solution {
    public class Coordinates {
        int x;
        int y;
        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int[] X_Coordinate = {1, -1, 0, 0};
    public int[] Y_Coordinate = {0, 0, 1, -1};
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList<int[]>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] pVisited = new boolean[m][n];
        boolean[][] aVisited = new boolean[m][n];
        Queue<Coordinates> pQueue = new LinkedList<Coordinates>();
        Queue<Coordinates> aQueue = new LinkedList<Coordinates>();
        for (int i = 0; i < m; i++) { // 从四条边缘开始
            pVisited[i][0] = true;
            aVisited[i][n - 1] = true;
            pQueue.offer(new Coordinates(i, 0));
            aQueue.offer(new Coordinates(i,n - 1));
        }
        for (int i = 0; i < n; i++) {
            pVisited[0][i] = true;
            aVisited[m - 1][i] = true;
            pQueue.offer(new Coordinates(0, i));
            aQueue.offer(new Coordinates(m - 1, i));
        }
        BFS(matrix, pQueue, pVisited);
        BFS(matrix, aQueue, aVisited);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pVisited[i][j] && aVisited[i][j]) {
                    res.add(new int[] {i, j});
                }
            }
        }
        return res;
    }
    
    private void BFS(int[][] matrix, Queue<Coordinates> queue, boolean[][] visited) {
        while (!queue.isEmpty()) {
            Coordinates cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = cur.x + X_Coordinate[i], newY = cur.y + Y_Coordinate[i];
                if (!inBound(matrix, newX, newY)) {
                    continue;
                }
                if (visited[newX][newY]) {
                    continue;
                }
                if (matrix[newX][newY] >= matrix[cur.x][cur.y]) {
                    queue.offer(new Coordinates(newX, newY));
                    visited[newX][newY] = true;
                }
            }
        }
    }
    
    private boolean inBound(int[][] matrix, int x, int y) {
        if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
            return false;
        }
        return true;
    }
}