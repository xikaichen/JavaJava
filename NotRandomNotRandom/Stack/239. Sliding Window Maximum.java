public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Deque<Integer> deque = new LinkedList<Integer>();
        // deque存下标
        for (int i = 0; i < nums.length; i++) {
            // remove element(index) out of range [i - (k - 1), i];
            while (!deque.isEmpty() && i - deque.peek() + 1 > k) { // deque里的第一个，和目前的i不能相差k(保持window大小)
                deque.poll();
            }
            // remove the element(index) that smaller than cur nums[i];
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i >= k - 1) {
                res[index++] = nums[deque.peek()];
            }
        }
        return res;
    }
}