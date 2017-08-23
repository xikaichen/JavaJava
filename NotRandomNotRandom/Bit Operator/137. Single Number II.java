
// 通用做法：问题一个数组里有一些数出现了K次（或者每个数出现了任意次 但是都不是M次）而有一个数字出现了M次（如果是两个数字 可以分组）
// 方法建一个int[32]的bitCount 统计每个bit 1出现的次数，然后找到等于M次的。（也可以其他数出现了K次 而该数出现了任意次 但不是K的倍数）
// 找到出现该次数的数字即可。
// 这道题告诉了你其他数字出现了3次，只有一个出现次数小于3次，那么就 模3 出现了3次的一模之后就变成0了。那么不管这个数字出现了2次还是1次都可以找到。
// 因为原题给定了3次，所以事实上不需要使用int[32]可以使用bit[32][2]也就是三个数字表示出现1次，2次和3次，但是这样技巧性太强
public class Solution {
    public int singleNumber(int[] nums) {
        int[] bitCount = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                if ((nums[i] & (1 << j)) != 0) { //用 != 0因为1 << 31是负数 用 > 0 或 = 1会出错
                    bitCount[j] = (bitCount[j] + 1) % 3;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) { // 利用得到的bitCount还原 这个数字
            if (bitCount[i] > 0) {
                res = res | (1 << i); // 在bitCount[i] > 0的位置设为1
            }
        }
        return res;
    }
}