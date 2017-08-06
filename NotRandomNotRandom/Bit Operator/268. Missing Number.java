// 使用异或 一开始xor = 0
public class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }   
        int xor = 0;
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ i;
    }
}

 // 0 1 2 3 4
 // 0 1 2 4 5
 // 最后在加上下标i = 5，得到mising number = 3