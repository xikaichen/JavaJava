//solution 1:BFS, for every pointer do BFS. Will face TLE problem
public class Solution {
    private int[] X_Coordinates = {1, -1, 0, 0};
    private int[] Y_Coordinates = {0, 0, 1, -1};
    public class Coordinates {
        int x;
        int y;
        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int longestIncreasingPath(int[][] matrix) {
        int longestLength = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                longestLength = Math.max(longestLength, BFS(matrix, i, j));
            }
        }
        return longestLength;
    }
    
    private int BFS(int[][] matrix, int x, int y) {
        int path = 0;
        Queue<Coordinates> queue = new LinkedList<Coordinates>();
        queue.offer(new Coordinates(x, y));
        while (!queue.isEmpty()) {
            int size = queue.size();
            path++;
            for (int j = 0; j < size; j++) {
                Coordinates cur = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int newX = cur.x + X_Coordinates[i];
                    int newY = cur.y + Y_Coordinates[i];
                    if (isBound(matrix, newX, newY) && matrix[newX][newY] < matrix[cur.x][cur.y]) {
                        queue.offer(new Coordinates(newX, newY));
                    }
                }
            }
        }
        return path;
    }
    
    private boolean isBound(int[][] matrix, int x, int y) {
        if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
            return false;
        }
        return true;
    }
}

//solution 2: record the max length of visited pointer
public class Solution {
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        int max = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, m, n, cache);
                max = Math.max(max, len);
            }
        }   
        return max;
    }
    
    public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
        if(cache[i][j] != 0) {
            return cache[i][j];
        }
        int max = 1;
        for(int[] dir: dirs) {
            int x = i + dir[0], y = j + dir[1];
            if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) {
                continue;
            }
            int len = 1 + dfs(matrix, x, y, m, n, cache);
            max = Math.max(max, len);
        }
        cache[i][j] = max;
        return max;
    }
}



