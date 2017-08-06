public class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        int bit = xor & ~(xor - 1); // find last 1 in xor, because xor = A ^ B, A and B are different in this position
        int num1 = 0;
        int num2 = 0;
        for (Integer num : nums) { // divide to two group
            if ((num & bit) > 0) { //must use (num & bit), otherwise there is compile error
                num1 ^= num;
            } else {
                num2 ^= num; 
            }
        }
        int[] res = new int[2];
        res[0] = num1;
        res[1] = num2;
        return res;
    }
}


