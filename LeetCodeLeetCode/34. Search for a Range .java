public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) {
            return res; 
        }
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (target <= nums[mid]) { // 找到开头的关键在这里，也可以修改为找最后一个 所以算法可以改为用两次二分搜索， 一次找头一次找尾
                right = mid;
            } else {
                left = mid;
            }
        }
        
        if (nums[left] == target) {
            res[0] = left;
            res[1] = left;
        } else if (nums[right] == target) {
            res[0] = right;
            res[1] = right;
        }
        int index = res[0];
        while (index + 1 < nums.length && nums[++index] == target) {
            res[1]++;
        }
        return res;
    }
}