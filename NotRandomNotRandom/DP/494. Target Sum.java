public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum + S) % 2 != 0 || sum < S) { // notice sum < S, otherwise if sum << S, when you creat int[] dp, it might be a very large array, so memory limited exceed
            return 0;
        }
        return partition(nums, (sum + S) / 2);
    }
    
    private int partition(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}