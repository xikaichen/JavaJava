// 注意这一个DFS，DFS的写法是用recursion
public class Solution {
    private int[] X_Coordinate = {1, -1, 0, 0};
    private int[] Y_Coordinate = {0, 0, 1, -1};
    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        if (word == null) {
            return true;
        }
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (DFS(board, i, j, word, 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean DFS(char[][] board, int x, int y, String word, int pos) {
        if (pos == word.length()) {
            return true;
        }
        for (int i = 0; i < 4; i++) {
            int newX = x + X_Coordinate[i], newY = y + Y_Coordinate[i];
            if (!isBound(board, newX, newY) || visited[newX][newY]) {
                continue;
            }
            if (board[newX][newY] == word.charAt(pos)) {
                visited[x][y] = true;
                if (DFS(board, newX, newY, word, pos + 1)) { // 一开始写的是 DFS(board, newX, newY, word, pos + 1)但是这样即使上一层的DFSreturn 了 true，到最后也还是false，所以要在本层设置出口
                    return true;
                }
                visited[x][y] = false;
            }
            
        }
        return false;
    }
    
    private boolean isBound(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }
        return true;
    }
}