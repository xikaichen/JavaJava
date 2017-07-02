// basic DP, state[i] only be influenced by state[i - 1]
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int[] res = new int[nums.length];
        if (nums[0] == 1) {
            res[0] = 1;
        } else {
            res[0] = 0;
        }
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                res[i] = res[i - 1] + 1;
            } else {
                res[i] = 0;
            }
        }
        
        int max = res[0];
        for (int i = 1; i < res.length; i++) {
            if (res[i] > max) {
                max = res[i];
            }
        }
        return max;
    }
}