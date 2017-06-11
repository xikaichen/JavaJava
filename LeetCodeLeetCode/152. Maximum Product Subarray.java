关键就是要保存最大和最小值 这样才能handle负数乘负数又变化正数的情况，另外还要和自己比较，handle有0的情况，使用prevMin因为min先变了而max还是要用之前的min
public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1, min = 1, result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int prevMin = min;
            min = Math.min(nums[i], Math.min(nums[i] * min, nums[i] * max));
            max = Math.max(nums[i],Math.max(nums[i] * prevMin, nums[i] * max));
            result = Math.max(result ,max);
        }
        return result;
    }
}