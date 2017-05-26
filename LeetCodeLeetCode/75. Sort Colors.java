public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        sort(nums, 0, nums.length - 1, 0, 2);
    }
    
    private void sort(int[] nums, int left, int right, int colorFrom, int colorTo) {
        if (colorFrom == colorTo) {
            return;
        }
        int l = left, r = right;
        int midColor = (colorFrom + colorTo) / 2;
        while (l < r) {
            while (l < r && nums[l] <= midColor) {
                l++;
            }
            while (l < r && nums[r] > midColor) {
                r--;
            }
            if (l < r) {
                swap(nums, l, r);
                l++;
                r--;
            }
        }
        sort(nums, left, r, colorFrom, midColor);
        sort(nums, l, right, midColor + 1, colorTo);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
}