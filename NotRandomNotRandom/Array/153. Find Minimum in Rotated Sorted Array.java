// 最后一个元素师关键所在，如果小于最后一个元素right = mid 如果大于 left = mid
public class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[nums.length - 1]) {
                left = mid;
            } else if (nums[mid] < nums[nums.length - 1]) {
                right = mid;
            }
        }
        if (nums[left] < nums[right]) {
            return nums[left];
        } else {
            return nums[right];
        }
    }
}