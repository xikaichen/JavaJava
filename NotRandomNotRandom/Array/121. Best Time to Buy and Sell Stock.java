//use only one for-loop, the question is to find the biggest positive difference.
//record current min_value, use current value minus min_value, get current difference, if current difference is bigger than previous one update!
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (min > prices[i]) {
                min = prices[i];
            }
            if (maxProfit < prices[i] - min) {
                maxProfit = prices[i] - min;
            }
        }
        return maxProfit;
    }
}