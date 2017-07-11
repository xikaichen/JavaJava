public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 9;
        for (int i = 2; i <= n; i++) {
            if (10 - i + 1 < 0) {
                break;
            }
            dp[i] = dp[i - 1] * (10 - i + 1);
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res += dp[i];
        }
        return res;
    }
}

// dp[i] = dp[i - 1] * (10 - i + 1)
// 2位数每个数字不同的数量 = 1位数每个数字不同的数量 * 8个不同的数字