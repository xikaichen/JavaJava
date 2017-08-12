public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = Math.max(nums[i], nums[i] + res[i - 1]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < res.length; i++) {
            if (res[i] > max) {
                max = res[i];
            }
        }
        return max;
    }
}