// 状态转移图
// s0是rest，s1是已买入，s2是已卖出
// s0可以由上个时刻s0状态，或者上个时刻s2状态得到
// s1可以由上个时刻s1状态继续休息 或者上个时刻s0这个时刻买入得到
// s2只能由上个时刻买入这个时刻卖出得到

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int len = prices.length;
        int[] s0 = new int[len];
        int[] s1 = new int[len];
        int[] s2 = new int[len];
        s0[0] = 0;
        s1[0] = -prices[0];
        s2[0] = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            s0[i] = Math.max(s0[i - 1], s2[i - 1]);
            s1[i] = Math.max(s1[i - 1], s0[i - 1] - prices[i]);
            s2[i] = s1[i - 1] + prices[i];
        }
        return Math.max(s0[len - 1], s2[len - 1]);
    }
}