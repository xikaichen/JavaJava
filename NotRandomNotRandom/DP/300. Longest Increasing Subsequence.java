public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i]++;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}

// O(nlogn)的算法
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            if (i == len) {
                len++;
            }
        }
        return len;
    }
}
// dp存数字，用二分搜索
// 例如
// 0 8 4 12 2
// dp = [0]
// dp = [0, 8]
// dp = [0, 4]
// dp = [0, 4, 12]
// dp = [0, 2, 12] maxLength = 3
// 3 5 6 2 5 4 19 5 6 12
// dp = [3]
// dp = [3, 5]
// dp = [3, 5, 6]
// dp = [2, 5, 6]
// dp = [2, 5, 6]
// dp = [2, 4, 6]
// dp = [2, 4, 6, 19]
// dp = [2, 4, 5, 19]
// dp = [2, 4, 5, 6]
// dp = [2, 4, 5, 6, 12]