public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robRow(nums, 0, nums.length - 2), robRow(nums, 1, nums.length - 1));
    }
    
    private int robRow(int[] nums, int start, int end) {
        int prevRob = 0, prevNotRob = 0;
        for (int i = start; i <= end; i++) {
            int curRob = prevNotRob + nums[i];
            int curNotRob = Math.max(prevRob, prevNotRob);
            prevRob = curRob;
            prevNotRob = curNotRob;
        }
        return Math.max(prevRob, prevNotRob);
    }
}



// if the house of [1,2,3,4,5,6] is a circle.
// pick the max number from the solution to the non-circle[1,2,3,4,5] and the solution to the non-circle[2,3,4,5,6]
// if they are equal, it means don't rob 1 and 6
