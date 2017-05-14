//基本思路是 用异或算出不同的bits位， 因为^是 相同返回0 不同返回1， 然后统计有多少个1
public class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y, count = 0;
        for (int i = 0; i < 32; i++) {
            count += (xor >> i) & 1;  // a >> b 把a向右移b位， 所以一开始是向右移0位 & 1 是和最后一位比较
        }
        return count;
    }
}

