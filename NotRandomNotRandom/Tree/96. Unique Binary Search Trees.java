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