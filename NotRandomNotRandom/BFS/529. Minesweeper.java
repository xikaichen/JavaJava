public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(click);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            if (board[row][col] == 'M') { // 碰到雷 结束
                board[row][col] = 'X';
                return board;
            } 
            //碰到'E'
            int count = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == 0 && j == 0) {
                        continue; // 跳过自己
                    }
                    int r = row + i, c = col + j;
                    if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
                        continue;
                    }
                    if (board[r][c] == 'M') {
                        count++;
                    }
                }
            }
            if (count > 0) { // 周围有雷,显示雷的数量
                board[row][col] = (char) (count + '0');
            } else { // 没雷变成'B'
                board[row][col] = 'B';
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) {
                            continue; // 跳过自己
                        }
                        int r = row + i, c = col + j;
                        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
                            continue;
                        }
                        if (board[r][c] != 'B') {
                            queue.offer(new int[] {r, c});
                            board[r][c] = 'B'; // 这个时候标记成B 并不代表周围没雷了，而是表示已经访问过了，如果他周围有雷，执行这个之后board[row][col] = (char) (count + '0') 又会变回来，如果没雷 就保留是B
                        }
                    }
                }
            }
        }
        return board;
    }
}