//O(n ^ 2)  space
public class Solution {
    public boolean canPartition(int[] nums) {
        // check edge case
        if (nums == null || nums.length == 0) {
            return true;
        }
        // sum(nums) % 2 should be 0
        int volumn = 0;
        for (int num : nums) {
            volumn += num;
        }
        if (volumn % 2 != 0) {
            return false;
        }
        volumn /= 2;
        // now the question convert to 0/1 knapsack problem
        // pick numbers in nums to see if they can sum up to volumn
        boolean[][] dp = new boolean[nums.length][volumn + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true; 
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = nums[i - 1]; j <= volumn; j++) {
                dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                // 前i个数到j = i - 1个数到j不选第i个， 或者i - 1个数到j - 第i个数（nums[i - 1]表示第i个数）
                // 并不是说一定要把前i - 1个数全部取掉
            }
        }
        return dp[nums.length - 1][volumn];
    }
}

// O(n) space
public class Solution {
    public boolean canPartition(int[] nums) {
        // check edge case
        if (nums == null || nums.length == 0) {
            return true;
        }
        // preprocess
        int volumn = 0;
        for (int num : nums) {
            volumn += num;
        }
        if (volumn % 2 != 0) {
            return false;
        }
        volumn /= 2;
        // now the question convert to 0/1 knapsack problem
        // pick numbers in nums to see if they can sum up to volumn
        boolean[] dp = new boolean[volumn + 1];
        // dp初始值表示的是，当一个数字都不选的时候，合理的解，那么只有在dp[0]的时候才是true
        // 而dp[i] i != 0时 都是没有解的
        // 对应的背包问题时，如果要求恰好装满背包，那么只有dp[0] = 0，其他都是负无穷
        dp[0] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = volumn; j > 0; j--) { // 只能从后朝前，因为dp[j]要用到dp[j - 1]的信息，而从后朝前更新时，前面还没有更新的格子还保留着上一个时刻的信息
                if (j >= nums[i - 1]) {
                    dp[j] = dp[j] || dp[j - nums[i - 1]];
                    // i 个数到j = i - 1时刻已经到j 或者i时刻到了j - 第i个数，然后再取第i个数(nums[i - 1])
                }
            }
        }
        return dp[volumn];
    }
}