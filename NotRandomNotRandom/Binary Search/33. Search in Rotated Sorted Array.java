// 注意和81对比 代码基本是一样的
// 先确定mid的位置，在确定target的位置
public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[left]) { // 说明mid 和 left在同一边
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
        if (nums[left] == target) {
            return left;
        } else if (nums[right] == target) {
            return right;
        }
        return -1;
    }
}
// 先用nums[mid] >= nums[left] 来判断mid和left的相对位置，满足这一条件说明，mid和left都在递增的那一条线上
// 这样如果target位于left和mid之间，就可以让right = mid。 而其他一切情况都是left = mid
// 如果不满足nums[mid] >= nums[left]， 则说明left和mid之间有断电，那么mid和right之间是递增的一条线，如果target
// 位于mid和right之间 可以让left = mid，其他情况right = mid