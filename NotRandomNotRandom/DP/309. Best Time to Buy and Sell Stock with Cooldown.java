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
        int[] rest = new int[len];
        int[] buy = new int[len];
        int[] sell = new int[len];
        rest[0] = 0;
        buy[0] = -prices[0];
        sell[0] = Integer.MIN_VALUE; // 因为要在sell与rest里找最大 所以初值设为MIN_VALUE
        for (int i = 1; i < len; i++) {
            rest[i] = Math.max(rest[i - 1], Math.max(buy[i - 1],sell[i - 1])); // 前一时刻休息赚到的钱，或者前一时刻卖出赚到的钱
            buy[i] = Math.max(buy[i - 1], rest[i - 1] - prices[i]); // 前一时刻买入赚到的钱，前一时刻在休息这一时刻买入赚到的钱
            sell[i] = buy[i - 1] + prices[i]; // 前一时刻买入过股票（买入动作不一定要发生在前一时刻,但总之是持有股票的，所以不能用rest[i - 1]）后赚到的钱 + 当前卖出能赚到的钱。
        }
        return Math.max(rest[len - 1], sell[len - 1]);
    }
}

//到达rest[i]状态可以是前一状态在rest, sell, buy
//到达buy[i]状态可以使前一状态买入buy[i - 1] or 前一状态在休息这一时刻买入rest[i - 1] - price[i]
//到达sell[i]状态只可以由buy状态转变而来sell[i]= buy[i - 1] + prices[i]
