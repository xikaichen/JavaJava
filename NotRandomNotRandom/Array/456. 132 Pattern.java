public class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        Stack <Integer> stack = new Stack <Integer>();
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++){
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] > min[j]) {
                while (!stack.isEmpty() && stack.peek() <= min[j]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < nums[j]) {
                    return true;
                }
                stack.push(nums[j]);
            }
        }
        return false;
    }
}
//       [6, 12, 3, 4, 6, 11, 20]
// min = [6,  6, 3, 3, 3,  3,  3]
// stack = {20}
// {20, 11}
// {20, 11, 6}
// {20, 11, 6, 4}
// {20, 11, 6, 4}
// 开始pop，因为min[i] >= stack.peek() {20, 11, 6, 4}
// 4, 6 都被弹出去之后, 找到了11， 11 > min[i]但是同时 11 < nums[i] = 12所以return true

