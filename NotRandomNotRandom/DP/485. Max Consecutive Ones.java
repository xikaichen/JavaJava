// basic DP, state[i] only be influenced by state[i - 1]
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        
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

// O(1) solution
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int temp = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                temp++;
            } else {
                max = Math.max(max, temp);
                temp = 0;
            }
        }    
        max = Math.max(max, temp);
        return max;
    }
}