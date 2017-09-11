//这个解法是对的 但是数字大的话 会超时，所以考虑用DP解
public class Solution {
    
    public int numTrees(int n) {
        return countNum(1, n);
    }
    
    private int countNum(int start, int end) {
        if (start > end) {
            return 1;
        }
        int res = 0;
        for (int i = start; i <= end; i++) {
            int left = countNum(start, i - 1);
            int right = countNum(i + 1, end);
            res += left * right;
        }
        return res;
    }
}

// DP: G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0) (左子树个数 * 右子树个数)
public class Solution {
    
    public int numTrees(int n) {
        int [] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}


//O(n ^ 2) space
class Solution {
    public int numTrees(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 1;
        } // 不知道为什么要初始化1因为下面已经说了k - 1 <= i 和 k + 1 >= j 取1了
        for (int step = 1; step < n; step++) {
            for (int i = 1; i + step <= n; i++) {
                int j = i + step;
                for (int k = i; k <= j; k++) {
                    dp[i][j] += (k - 1 <= i ? 1 : dp[i][k - 1]) * (k + 1 >= j ? 1 : dp[k + 1][j]);
                }
            }
        }
        return dp[1][n];
    }
}