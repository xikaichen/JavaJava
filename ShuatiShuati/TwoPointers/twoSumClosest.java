public class twoSumClosest {
    public int twoSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
    
        int left = 0;
        int right = nums.length - 1;
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return 0;
            } else if (sum < target) {
                diff = Math.min(target - sum, diff);
                left++;
            } else {
                diff = Math.min(sum - target, diff);
                right--;
            }
        }
        return diff;
    }
}