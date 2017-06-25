public class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            arr[i] = Math.min(arr[i - 1], nums[i]);
        }
        int k = nums.length;
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] <= arr[j]) {
                continue;
            }
            while (k < nums.length && arr[k] <= arr[j]) {
                k++;
            }
            if (k < nums.length && nums[j] > arr[k]) {
                return true;
            }
            arr[--k] = nums[j];
        }
        return false;
    }
}