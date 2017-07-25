// 从右到左两次，用stack
// 遍历nums碰到比nums[i]小的从stack里弹出来
// 碰到比nums[i]大的就是next greater element，因为是circle所以要遍历两次
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(nums.length - 1);
        for (int i = nums.length - 2; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res[i] = nums[stack.peek()];
            }
            stack.push(i);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res[i] = nums[stack.peek()];
            }
            stack.push(i);
        }
        return res;
    }
}