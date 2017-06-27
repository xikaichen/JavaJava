//DP
//先排序，DP
//找到maxIdx, nums[maxIdx]对应的数字就是Largest Divisible Subset最大的那个数字，然后用这个数字去找剩下的数字
//根据1. 首先剩下的数字能被他后一个整除, 2. 其对应的dp[i]要比后一个对应的dp[j]小1
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new LinkedList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        
        int maxIdx = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > dp[maxIdx]) {
                maxIdx = i;
            }
        }
        int temp = nums[maxIdx];
        int curDp = dp[maxIdx];
        for (int i = maxIdx; i >= 0; i--) {
            if (temp % nums[i] == 0 && dp[i] == curDp) {
                res.add(nums[i]);
                temp = nums[i];
                curDp--;
            }
        }
        return res;
    }
}