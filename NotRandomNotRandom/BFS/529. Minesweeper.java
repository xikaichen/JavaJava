public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.add(click);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            if (board[row][col] == 'M') {
                board[row][col] = 'X';
                return board;
            } else {
                //只有可能是空 开始统计周边
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
                if (count > 0) {
                    board[row][col] = (char)(count + '0');
                } else { // 如果count = 0， 游戏会爆开周围八个格子，所以把周围八个点加到queue里进行搜索，同时标记为B
                    board[row][col] = 'B';
                    for (int i = -1; i < 2; i++) {
                        for (int j = -1; j < 2; j++) {
                            if (i == 0 && j == 0) {
                                continue;
                            }
                            int r = row + i, c = col + j;
                            if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
                                continue;
                            }
                            if (board[r][c] != 'B') {
                                queue.offer(new int[] {r, c});
                                board[r][c] = 'B';
                            }
                        }
                    }
                }
            }
        }
        return board;
    }
}