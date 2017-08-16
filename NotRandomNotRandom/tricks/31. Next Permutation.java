// 算法
// step1: 从右开始找，找到第一个小于之前一个的数字 534976 找到4，
// step2: 再从右开始找，找比4大的最小的那个数字，因为从右向左是递增的，所以找到的第一个比4大的数字就是了，找到6
// step3: 交换4 和 6的位置，变成 536974
// step4: 对974进行排序（因为之前的性质，不需要排序只需要reverse即可），变成536479, 得到结果
public class Solution {
    public void nextPermutation(int[] nums) {
        int k = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                k = i;
            }
        }
        if (k == -1) {
            reverse(nums, 0);
            return;
        }
        int l = k;
        for (int i = l; i < nums.length; i++) {
            if (nums[k] < nums[i]) {
                l = i;
            }
        }

        int temp = nums[l];
        nums[l] = nums[k];
        nums[k] = temp;
        reverse(nums, k + 1);
    }
    
    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}