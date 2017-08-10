public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0 || (nums.length == 1 && val == nums[0])) {
            return 0;
        } 
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {   //must use <= because you need check if location left = right still satisfied the condition
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
// left + 1 < right，left和right相邻的情况已经不考察了，binary searh的写法，所以需要在判断left和right的情况
// left < right, left和right相邻的情况还考察，但是left = right的情况不考察了
// left <= right, 还考察了left = right的情况，quickselect的写法