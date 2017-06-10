// 先算preSum超时了 因为这里还有update的过程 所以如果update很多的话 还是很耗时间
public class NumArray {
    public int[] sums;
    public int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        if (nums == null) {
            sums = null;
        } else if (nums.length == 0) {
            sums = new int[0];
        } else {
            this.sums = new int[nums.length];
            sums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sums[i] = sums[i - 1] + nums[i];
            }
        }
    }
    
    public void update(int i, int val) {
        int diff = nums[i] - val;
        for (int start = i; start < sums.length; start++) {
            sums[start] -= diff;
        }
        nums[i] = val;
    }
    
    public int sumRange(int i, int j) {
        if (i == 0) {
            return sums[j];
        } else {
            return sums[j] - sums[i - 1];
        }
    }
}



/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */