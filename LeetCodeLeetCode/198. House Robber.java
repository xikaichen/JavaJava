public class Solution {
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length + 1][2];  // two dimension dp, the second dimension is the states
        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = nums[i - 1] + dp[i - 1][0];
        }
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }
}



// 遍历所有房子
// 抢i = 不抢 i - 1 + nums[i]
// 不抢i = max(不抢i - 1, 抢i - 1)

