public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            while (left + 1 < right && nums[left] == nums[right]) {
                right--; // 和 I 比 只多了这一行其他的代码都是一样的
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] >= nums[left]) {
                if (target <= nums[mid] && target >= nums[left]) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (target >= nums[mid] && target <= nums[right]) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (nums[left] == target || nums[right] == target) {
            return true;
        }
        return false;
    }
}

// 因为有了duplicates的存在，即使满足nums[mid] >= nums[left]，也不能说left到mid之间是递增的，他们之间也可能有断点
// 例如
// 1，1，2，1，1，1，1
// mid = 1， left = 1
// 但是即使有重复，重复也只有可能出现在两个端点，否则依然是递增的如1，1，1，1，2，2，2，3，3，4。所以用一行就可以跳掉这种情况
// 最坏情况下算法的时间复杂度是O(n)