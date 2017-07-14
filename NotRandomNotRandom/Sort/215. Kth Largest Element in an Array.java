// quick selection
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, k);
    }
    
    private int quickSelect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return nums[start];
        }
        int left = start, right = end;
        int mid = nums[left + (right - left) / 2];
        while (left <= right) {
            while (left <= right && nums[left] > mid) {
                left++;
            }
            while (left <= right && nums[right] < mid) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        if (right - start >= k - 1) {
            return quickSelect(nums, start, right, k);
        } else if (left - start <= k - 1) {
            return quickSelect(nums, left, end, k - (left - start));
        }
        return nums[right + 1];
    } 
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}


