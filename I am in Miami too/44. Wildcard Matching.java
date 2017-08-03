public class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1]; // 长度多留一个 用来处理空字符串
        dp[0][0]= true; // s和p长度都是0的时候是true
        for (int i = 1; i <= p.length(); i++) { // 初始化，先处理p
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i <= s.length(); i++) { // 然后可以开始从s，p的第一个字符开始遍历，外层s里层p的话dp矩阵是从上向下，从左到右一列一列计算的
            for (int j = 1; j <= p.length(); j++){
                if (p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}