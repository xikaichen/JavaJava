public class Solution {
    public int getSum(int a, int b) {
        if (b == 0) {
            return a;
        }
        int sum = a ^ b; // xor也叫不进位加法： 原因 1 ^ 0 = 0 ^ 1 = 1. 1 ^ 1 = 0没有进位
        int carry = (a & b) << 1; // 算出进位，在左移一个格子
        return getSum(sum, carry); // 在相加
    }
}

