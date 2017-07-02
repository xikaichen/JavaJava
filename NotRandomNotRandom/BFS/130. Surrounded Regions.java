// just noraml BFS
public class Solution {
    private int[] X_Coordinate = {1, -1, 0, 0};
    private int[] Y_Coordinate = {0, 0, 1, -1};
    public class Coordinates {
        int x;
        int y;
        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                BFS(board, i, 0);
            }
            if (board[i][m - 1] == 'O') {
                BFS(board, i, m - 1);
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[0][i] == 'O') {
                BFS(board, 0, i);
            }
            if (board[n - 1][i] == 'O') {
                BFS(board, n - 1, i);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void BFS(char[][] board, int x, int y) {
        Queue<Coordinates> queue = new LinkedList<Coordinates>();
        queue.offer(new Coordinates(x, y));
        board[x][y] = '#';
        while (!queue.isEmpty()) {
            Coordinates cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = cur.x + X_Coordinate[i], newY = cur.y + Y_Coordinate[i];
                if (isBound(board, newX, newY) && board[newX][newY] == 'O') {
                    queue.offer(new Coordinates(newX, newY));
                    board[newX][newY] = '#';
                }
            }
        }
    }
    private boolean isBound(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }
        return true;
    }
}