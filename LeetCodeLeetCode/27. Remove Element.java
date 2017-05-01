public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0 || (nums.length == 1 && val == nums[0])) {
            return 0;
        } 
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {   //mush use <= because you need check if location left = right still satisfied the condition
            while (left <= right && nums[left] != val) {
                left++;
            }
            while (left <= right && nums[right] == val) {
                right--;
            }
            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        return left;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}