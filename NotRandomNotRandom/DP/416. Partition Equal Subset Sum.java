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
        boolean[][] dp = new boolean[nums.length + 1][volumn + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = nums[i - 1]; j <= volumn; j++) {
                dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
            }
        }
        return dp[nums.length][volumn];
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
        dp[0] = true;

        for (int i = 0; i < nums.length; i++) {
            for (int j = volumn; j > 0; j--) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }
        return dp[volumn];
    }
}