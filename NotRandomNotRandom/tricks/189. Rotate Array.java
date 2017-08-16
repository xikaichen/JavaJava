public class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length; // consider if k > nums.length, like nums.length = 3, k = 10. then u just need rotate 1 step.
        reverse(nums, 0, nums.length - 1); // 整个翻转
        reverse(nums, 0, k - 1); // 翻转前k个
        reverse(nums, k, nums.length - 1); // 翻转后面
        
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}