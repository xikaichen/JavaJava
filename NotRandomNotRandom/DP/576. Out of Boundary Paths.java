public class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        int res = 0;
        final int MOD = 1000000007;
        int[][] dp = new int[m][n];
        dp[i][j] = 1;
        int[][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        for (int step = 0; step < N; step++) {
            int[][] temp = new int[m][n];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dirs[d][0];
                        int nc = c + dirs[d][1];
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            res = (res + dp[r][c]) % MOD; // res根据上一个step的dp来更新
                        } else {
                            temp[nr][nc] = (temp[nr][nc] + dp[r][c]) % MOD; // temp根据上一个step的dpo来更新
                        }
                    }
                }
            }
            dp = temp; // 更新完temp后 另dp = temp
        }
        return res % MOD;
    }
}