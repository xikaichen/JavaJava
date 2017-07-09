public class Solution {
    public int numSquares(int n) {
    	int[] dp = new int[n + 1];
    	Arrays.fill(dp, Integer.MAX_VALUE);
    	dp[0] = 0;
    	for (int i = 1; i <= n; i++) { // 和416对比 就会发现这里i 可以从头开始 而在416里面要从后面开始 这是因为这里 每个平方数可以用无数次, 这是一个无限次的背包问题
    		int j = 1;
    		while(i - j * j >= 0) {
    			dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
    			j++;
    		}
    	}		
    	return dp[n];
    }
}


// 颠倒两个for循环是可以的， 一般的背包问题是先遍历物品，但是对无限次的背包问题两种都可以
public class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            for (int j = 1; j <= n; j++) {
                if (j >= square) {
                    dp[j] = Math.min(dp[j], dp[j - square] + 1);
                }
            }
        }       
        return dp[n];
    }
}