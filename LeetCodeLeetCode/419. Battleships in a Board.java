public class Solution {
    public class Coordinates {
        int x;
        int y;
        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    int[] X_Coordinates = {1, -1, 0, 0};
    int[] Y_Coordinates = {0, 0, 1, -1};
    
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    count++;
                    BFS(board, i, j);
                }
            }
        }
        return count;
    }
    
    private void BFS(char[][] board, int i, int j) {
        Queue<Coordinates> queue = new LinkedList<Coordinates>();
        queue.offer(new Coordinates(i, j));
        board[i][j] = '.';
        while (!queue.isEmpty()) {
            Coordinates cur = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = cur.x + X_Coordinates[k];
                int y = cur.y + Y_Coordinates[k];
                if (isBound(board, x, y) && board[x][y] == 'X') {
                    board[x][y] = '.';
                    queue.offer(new Coordinates(x,y));
                }
            }
        }
    }
    
    private boolean isBound(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x > board.length - 1 || y > board[0].length - 1) {
            return false;
        }
        return true;
    }
}