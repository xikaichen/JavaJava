// Definition of dp[i][j]: minimum number of money to guarantee win for subproblem [i, j].
// Target: dp[1][n]
// Corner case: dp[i][i] = 0 (because the only element must be correct)
// Equation: we can choose k (i<=k<=j) as our guess, and pay price k. 
// After our guess, the problem is divided into two subproblems. 
// Notice we do not need to pay the money for both subproblems. 
// We only need to pay the worst case (because the system will tell us which side we should go) to guarantee win. 
// So dp[i][j] = min (i<=k<=j) { k + max(dp[i][k-1], dp[k+1][j]) }

public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int jminusi = 1; jminusi < n; jminusi++) {
            for (int i = 1; i + jminusi <= n; i++) {
                int j = i + jminusi;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                        k + Math.max(k == i ? 0 : dp[i][k - 1], k == j ? 0 : dp[k + 1][j]));
                }
            }
        }
        return dp[1][n];
    }
}