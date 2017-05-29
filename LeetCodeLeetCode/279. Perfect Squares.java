public class Solution {
    public int numSquares(int n) {
    	int[] dp = new int[n + 1];
    	Arrays.fill(dp, Integer.MAX_VALUE);
    	dp[0] = 0;
    	for(int i = 1; i <= n; i++) { // 和416对比 就会发现这里i 可以从头开始 而在416里面要从后面开始 这是因为这里 每个平方数可以用无数次
    		int j = 1;
    		while(i - j * j >= 0) {
    			dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
    			j++;
    		}
    	}		
    	return dp[n];
    }
}