public class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, nums[i] + i); // max is the current reachable farest distance, if i > max it means you can't get there
        }
        return true;
    }
}