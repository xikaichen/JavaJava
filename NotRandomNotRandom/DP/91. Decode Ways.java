// 例如121，先抽出1，然后再看21有多少种可能，这种不是recursion就是DP
public class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= s.length(); i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) { // 如127，7可以和12分开 他的可能性和12的可能性是一样的
               dp[i] += dp[i-1];  
            }
            if(second >= 10 && second <= 26) { // 可以和前面的合起来如126 他的可能性是之前的12的可能性 + 1的可能性（26合起来）
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }
}