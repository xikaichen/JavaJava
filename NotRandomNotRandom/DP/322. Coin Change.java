public class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 0) {
            return 0;
        }

        int[] minLength = new int[amount + 1];
        for (int i = 1; i < minLength.length; i++) {
            minLength[i] = Integer.MAX_VALUE; // minLength[0] = 0 always.假设amount = i 的钱不可能被组成
            for (int j = 0; j < coins.length; j++) { //遍历所有的coin
                if (coins[j] <= i && minLength[i - coins[j]] != Integer.MAX_VALUE) { //如果 i - coin[j]有解，那么minLengt[i - coins[j]] + 1就是minLength[i]的解， 或者已经有更好的解了，那么就保持不变
                    minLength[i] = Math.min(minLength[i], 1 + minLength[i - coins[j]]);
                } 
            }
        }
        if (minLength[amount] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return minLength[amount];
        }
    }
}



public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        // dp的初始值表示没有硬币时，dp[i]最小硬币数，那么只有i = 0时，才有一个解，其他时候都是无解所以设成max_value
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
        
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[amount];
        }
    }
}