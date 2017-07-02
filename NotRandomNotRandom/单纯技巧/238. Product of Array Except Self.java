public class Solution {
    public int[] productExceptSelf(int[] nums) { // [1, 2, 3, 4]
        int[] result = new int[nums.length];
        int tmp1 = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = tmp1;
            tmp1 *= nums[i];
        }   // [1, 1, 2, 6]
        int tmp2 = 1;
        for (int i = nums.length - 1; i >= 0; i--) { // from the tail to the head 6 * (1) = 6, 2 * (4) = 8, 1 * (4 * 3) = 12, 1 * (4 * 3 * 2) = 24 
            result[i] *= tmp2;
            tmp2 *= nums[i];
        }
        return result;
    }
}