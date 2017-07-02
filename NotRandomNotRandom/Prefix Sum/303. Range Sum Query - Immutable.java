public class NumArray {
    private int[] preSum;
    public NumArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            preSum = new int[0];
        }
        if (nums.length > 0) {
            preSum = new int[nums.length];
            preSum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                preSum[i] = nums[i] + preSum[i - 1];
            }
        }
    }
    
    public int sumRange(int i, int j) {
        if (i == 0) {
            return preSum[j];
        } else {
            return preSum[j] - preSum[i - 1];
        }
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */