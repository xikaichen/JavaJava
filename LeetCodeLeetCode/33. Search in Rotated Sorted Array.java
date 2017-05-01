public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[left]) {
                if (target < nums[mid] && target >= nums[left]) {  // >= can include nums[left] 
                    right = mid;
                } else {
                    left = mid;
                }
            } else if (nums[mid] < nums[left]) {
                if (target > nums[mid] && target <= nums[right]) {   // <= can include nums[right]
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (nums[left] == target) {
            return left;
        } else if (nums[right] == target) {
            return right;
        } else {
            return -1;
        }
    }
}