public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        int closeSum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(sum - target);
                if (diff < min) {
                    min = diff;
                    closeSum = sum;
                }
                if (sum > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return closeSum;
    }
}