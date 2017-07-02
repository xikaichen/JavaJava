// Find the largest index k such that nums[k] < nums[k + 1]. If no such index exists, the permutation is sorted in descending order, just reverse it to ascending order and we are done. For example, the next permutation of [3, 2, 1] is [1, 2, 3].
// Find the largest index l greater than k such that nums[k] < nums[l].
// Swap the value of nums[k] with that of nums[l].
// Reverse the sequence from nums[k + 1] up to and including the final element nums[nums.size() - 1].

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